import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Anagram {

    private String wordToCheck;
    private Map<Character, Integer> mappedCharsOfWordToCheck;

    public Anagram(String word){
        this.wordToCheck = word;
        mappedCharsOfWordToCheck = mapCharsOfAWord(wordToCheck);
    }

    public List<String> match(List<String> wordsToCheck){
        List<String> wordsToCheckWithoutDuplications = wordsToCheck
                .stream()
                .filter(x -> !x.toLowerCase().equals(this.wordToCheck.toLowerCase()))
                .collect(Collectors.toList());
        List<String> matchingWords = new ArrayList<>();
        for(String word : wordsToCheckWithoutDuplications){
            Map<Character, Integer> mappedCharsOfWord = mapCharsOfAWord(word);
            if(mappedCharsOfWord.equals(mappedCharsOfWordToCheck)){
                matchingWords.add(word);
            }
        }
        return matchingWords;
    }
    private Map<Character, Integer> mapCharsOfAWord(String word){
        Map<Character, Integer> mapOfChars = new HashMap<>();
        for(Character c : word.toLowerCase().toCharArray()){
            if (mapOfChars.keySet().contains(c)) {
                mapOfChars.put(c, mapOfChars.get(c) + 1);
            } else {
                mapOfChars.put(c, 1);
            }
        }
        return mapOfChars;
    }
}