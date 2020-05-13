import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordProblemSolver {

    public int solve(String sentence) {

        String regexForCheckingNumbers = "-?\\d+(.\\d+)?";

        List<Integer> foundNumbers = new ArrayList<>();
        List<String> foundActions = new ArrayList<>();
        List<String> splitSentence = Arrays.asList(sentence.replace("?", "").split(" "));

        for(int word=0; word<splitSentence.size(); word++){
            String x = splitSentence.get(word);
            if (x.contains(Actions.ADD) || x.contains(Actions.SUBTRACT)
                    || x.contains(Actions.MULTIPLY) || x.contains(Actions.DIVIDED)) {
                foundActions.add(x);
            }
            if (x.matches(regexForCheckingNumbers)){
                foundNumbers.add(Integer.parseInt(x));
                try{
                    if(splitSentence.get(word+1).matches(regexForCheckingNumbers)){
                        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.print(e.getMessage());
                }

            }
        }

        if(foundNumbers.size() == 0){
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        if (foundNumbers.size() == 1 && String.format(Actions.WHAT_IS, foundNumbers.get(0)).equals(sentence)) {
            return foundNumbers.get(0);}

        if (foundActions.size() == 0 && !String.format(Actions.WHAT_IS, foundNumbers.get(0)).equals(sentence)){
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        if (foundNumbers.size() != foundActions.size()+1){
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        int numberIndexLimit = 2;
        int currentIndexNumber= 1;
        int currentNumberToManipulate = foundNumbers.get(0);
        int total = 0;

        for (int action = 0; action < foundActions.size(); action++) {
            for (int number = currentIndexNumber; number < numberIndexLimit; number++) {
                int result = 0;
                switch (foundActions.get(action)) {
                    case Actions.ADD:
                        result = currentNumberToManipulate + foundNumbers.get(number);
                        break;
                    case Actions.SUBTRACT:
                        result = currentNumberToManipulate - foundNumbers.get(number);
                        break;
                    case Actions.MULTIPLY:
                        result = currentNumberToManipulate * foundNumbers.get(number);
                        break;
                    case Actions.DIVIDED:
                        result = currentNumberToManipulate / foundNumbers.get(number);
                        break;
                }
                currentNumberToManipulate=result;
                if(number+1<=numberIndexLimit){
                    currentIndexNumber++;
                }
            }
            if(currentIndexNumber<foundNumbers.size()){
                numberIndexLimit++;
            }
        }
        total += currentNumberToManipulate;
        return total;
    }
}
