import java.util.*;

class Scrabble {

    private ArrayList<String> listOfChars;
    private Map<ArrayList<String>, Integer> values;
    private int result;

    Scrabble(String word) {
        this.listOfChars = new ArrayList<>(Arrays.asList(word.replace(" ", "").split("")));
        this.result = 0;
        this.values = new HashMap<>();
        this.values.put(new ArrayList<>(Arrays.asList("A", "E", "I", "O", "U", "L", "N", "R", "S", "T")), 1);
        this.values.put(new ArrayList<>(Arrays.asList("D", "G")), 2);
        this.values.put(new ArrayList<>(Arrays.asList("B", "C", "M", "P")), 3);
        this.values.put(new ArrayList<>(Arrays.asList("F", "H", "V", "W", "Y")), 4);
        this.values.put(new ArrayList<>(Arrays.asList("K")), 5);
        this.values.put(new ArrayList<>(Arrays.asList("J", "X")), 8);
        this.values.put(new ArrayList<>(Arrays.asList("Q", "Z")), 10);
    }

    int getScore() {
        Set<ArrayList<String>> characters = this.values.keySet();
        for(String characterInWord : listOfChars)
            for (List<String> setOfchars : characters){
                for(String character : setOfchars){
                    if(character.equals(characterInWord.toUpperCase())){
                        this.result += this.values.get(setOfchars);
                    }
                }
            }
        return this.result;
    }
}
