import java.util.*;

enum ScrabbleScores{

    VALUE_1(new String[]{"A", "E", "O", "I", "U", "L", "N", "R", "S", "T"}, 1),
    VALUE_2(new String[]{"D", "G"}, 2),
    VALUE_3(new String[]{"B", "C", "M", "P"}, 3),
    VALUE_4(new String[]{"F", "H", "V", "W", "Y"}, 4),
    VALUE_5(new String[]{"K"}, 5),
    VALUE_8(new String[]{"J", "X"}, 8),
    VALUE_10(new String[]{"Q", "Z"}, 10);

    private String[] characters;
    private Integer value;

    ScrabbleScores(String[] characters, Integer value){
        this.characters = characters;
        this.value = value;
    }

    ArrayList<String> getCharacters(){
        return new ArrayList<>(Arrays.asList(this.characters));
    }

    Integer getValue(){
        return this.value;
    }
}

class Scrabble {

    private ArrayList<String> listOfChars;
    private Map<String, Integer> values;
    private int result;

    Scrabble(String word) {
        this.listOfChars = !word.equals("") ? new ArrayList<>(Arrays.asList(word.replace(" ", "").split(""))) : null;
        this.result = 0;
        this.values = new HashMap<>();
        for(ScrabbleScores scoreChart : ScrabbleScores.values()){
            for(String character : scoreChart.getCharacters()){
                this.values.put(character, scoreChart.getValue());
            }
        }
    }

    int getScore() {
        if(this.listOfChars == null){
            return this.result;
        }else {
            for(String character : this.listOfChars) {
                this.result += this.values.get(character.toUpperCase());
            }
        }
        return this.result;
    }
}
