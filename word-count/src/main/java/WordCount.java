import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordCount{

    public Map<String, Integer> phrase(String phrase){

        String clearedPhrase = PhraseCleaner.clearPunctuation(phrase)
                .trim() //removes trailing and leading spaces
                .replaceAll("\\s+", " ") //replaces excessive spacing with just one space
                .toLowerCase();

        Map<String, Integer> results = new HashMap<>();
        List<String> words = Arrays.stream(clearedPhrase.split(" "))
                .map(QuotationCleaner::clearQuotes)
                .collect(Collectors.toList());

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

class QuotationCleaner{

    public static String clearQuotes(String string){
        if(string.charAt(0) == '"' || string.charAt(0) == "'".charAt(0)){
            string = string.substring(1);
        }
        if(string.charAt(string.length()-1) == '"' || string.charAt(string.length()-1) == "'".charAt(0)){
            string = string.substring(0, string.length()-1);
        }
        return string;
    }
}
