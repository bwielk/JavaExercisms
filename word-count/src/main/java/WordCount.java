import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordCount{

    public Map<String, Integer> phrase(String phrase){
        Map<String, Integer> results = new HashMap<>();
        List<String> words = Arrays.asList(phrase.split(" "));
        for(String word : words){
            if(results.keySet().contains(word)){
                results.put(word, results.get(word)+1);
            }else{
                results.put(word, 1);
            }
        }
        return results;
    }
}
