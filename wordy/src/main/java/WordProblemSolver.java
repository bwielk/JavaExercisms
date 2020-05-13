import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordProblemSolver {

    public int solve(String sentence) {
        String foundNumberAsChars = "";
        List<Integer> foundNumbers = new ArrayList<>();
        List<String> foundActions = new ArrayList<>();

        Arrays.asList(sentence.split(" ")).forEach(x -> {
            if (x.contains(Actions.ADD) || x.contains(Actions.SUBTRACT)
                    || x.contains(Actions.MULTIPLY) || x.contains(Actions.DIVIDED)) {
                foundActions.add(x);
            }
        });

        for (int c = 0; c < sentence.length(); c++) {
            if (Character.isDigit(sentence.charAt(c))) {
                try {
                    if (sentence.charAt(c - 1) == '-') {
                        foundNumberAsChars += sentence.charAt(c - 1);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

                int startingCharForIntSearch = c;
                while (Character.isDigit(sentence.charAt(startingCharForIntSearch))) {
                    foundNumberAsChars += sentence.charAt(startingCharForIntSearch);
                    startingCharForIntSearch += 1;
                }
                c = startingCharForIntSearch;
                foundNumbers.add(Integer.parseInt(foundNumberAsChars));
                foundNumberAsChars = "";
            }
        }

        int total = 0;
        if (foundNumbers.size() == 1) {
            return foundNumbers.get(0);}

        int numberIndexLimit = 2;
        int currentIndexNumber= 1;
        int currentNumberToManipulate = foundNumbers.get(0);

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
                if(number+1==numberIndexLimit){
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
