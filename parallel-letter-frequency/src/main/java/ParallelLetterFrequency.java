import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private String text;
    private Map<Integer, Integer> charMap = new ConcurrentHashMap<>();

    ParallelLetterFrequency(String b){
        this.text = b;
    }

    public Map<Integer, Integer> letterCounts(){
        this.charMap = text.chars()
                .parallel()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .boxed()
                .collect(Collectors.toConcurrentMap(k -> k, k -> 1, Integer::sum));
        return charMap;
    }
}