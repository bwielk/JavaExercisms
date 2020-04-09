import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordCount{

    public Map<String, Integer> phrase(String phrase){

        String clearedPhrase = PhraseCleaner.clearPunctuation(phrase)
                .trim() //removes trailing and leading spaces
                .replaceAll("\\s+", " ") //replaces excessive spacing with just one space
                .toLowerCase();

        Map<String, Integer> results = new HashMap<>();
        List<String> words = Arrays.asList(clearedPhrase.split(" "));
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

class PhraseCleaner{

    public static String clearPunctuation(String string){
        return string.replaceAll("[!\"\\#$%&()*+,\n" +
                "\\-./:;<=>?@\\[\n" +
                "\\\\\\]^_‘{|}~]", " ");
    }

}
