import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordProblemSolver {

    public int solve(String sentence) {

        /**
         * Instantiate lists storing the data we'll be iterating through
         */
        String regexForCheckingNumbers = "-?\\d+(.\\d+)?";
        List<Integer> foundNumbers = new ArrayList<>();
        List<String> foundActions = new ArrayList<>();
        List<String> splitSentence = Arrays.asList(sentence.replace("?", "").split(" "));

        /**
         * Identify keywords and digits to manipulate with
         */
        for(int word=0; word<splitSentence.size(); word++){
            String x = splitSentence.get(word);
            if (x.contains(Actions.ADD) || x.contains(Actions.SUBTRACT)
                    || x.contains(Actions.MULTIPLY) || x.contains(Actions.DIVIDED)) {
                foundActions.add(x);
            }
            if (x.matches(regexForCheckingNumbers)){
                foundNumbers.add(Integer.parseInt(x));
                if(word+1<splitSentence.size() && splitSentence.get(word+1).matches(regexForCheckingNumbers)){
                        throw new IllegalArgumentException(ErrorMessages.QUESTION_NOT_UNDERSTOOD);
                }
            }
        }

        /**
         * After picking up the words and numbers, verify that the input makes sense at all
         */

        if(foundNumbers.size() == 0){
            throw new IllegalArgumentException(ErrorMessages.QUESTION_NOT_UNDERSTOOD);
        }

        if (foundNumbers.size() == 1 && String.format(Actions.WHAT_IS, foundNumbers.get(0)).equals(sentence)) {
            return foundNumbers.get(0);}

        if (foundActions.size() == 0 && !String.format(Actions.WHAT_IS, foundNumbers.get(0)).equals(sentence)){
            throw new IllegalArgumentException(ErrorMessages.QUESTION_NOT_UNDERSTOOD);
        }

        if (foundNumbers.size() != foundActions.size()+1){
            throw new IllegalArgumentException(ErrorMessages.QUESTION_NOT_UNDERSTOOD);
        }

        /**
         * Begin the checks.
         *
         * int numberIndexLimit - defines that we're going to act on two operands at a time. This
         *    value will be increased by one after an operation has been completed
         * int currentNumberToManipulate - the first number we're going to manipulate. Later on that
         *    number becomes a total of the n+1 operation, and eventually will result in the total
         */

        int numberIndexLimit = 2;
        int currentIndexNumber= 1;
        int currentNumberToManipulate = foundNumbers.get(0);
        int total = 0;

        for (String foundAction : foundActions) {
            for (int number = currentIndexNumber; number < numberIndexLimit; number++) {
                switch (foundAction) {
                    case Actions.ADD:
                        total = currentNumberToManipulate + foundNumbers.get(number);
                        break;
                    case Actions.SUBTRACT:
                        total = currentNumberToManipulate - foundNumbers.get(number);
                        break;
                    case Actions.MULTIPLY:
                        total = currentNumberToManipulate * foundNumbers.get(number);
                        break;
                    case Actions.DIVIDED:
                        total = currentNumberToManipulate / foundNumbers.get(number);
                        break;
                }
                currentNumberToManipulate = total;
                if (number + 1 <= numberIndexLimit) {
                    currentIndexNumber++;
                }
            }
            if (currentIndexNumber < foundNumbers.size()) {
                numberIndexLimit++;
            }
        }
        return total;
    }
}
