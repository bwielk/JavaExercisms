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

        for (int action = 0; action < foundActions.size(); action++) {
            for (int number = 0; number < foundNumbers.size(); number++) {
                switch (foundActions.get(action)) {
                    case Actions.ADD:
                        foundNumbers.stream().reduce(0, Integer::sum);
                        break;
                    case Actions.SUBTRACT:
                        foundNumbers.get(0) - foundNumbers.get(1);
                        break;
                    case Actions.MULTIPLY:
                        foundNumbers.get(0) * foundNumbers.get(1);
                        break;
                    case Actions.DIVIDED:
                        foundNumbers.get(0) / foundNumbers.get(1);
                        break;
                }
            }
        }
        return total;
    }
}
