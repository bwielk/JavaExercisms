import java.util.Arrays;
import java.util.List;

class PigLatinTranslator{

    private List<String> vowels;
    private List<String> consonantClusters;

    public PigLatinTranslator(){
        vowels = Arrays.asList("a", "e", "i", "o", "u", "yt");
        consonantClusters = Arrays.asList("ch", "qu", "squ", "sch", "th");
    }

    public String translate(String word) {
        if(vowels.contains(String.valueOf(word.charAt(0)))){
           return word + "ay";
        }else{
            for(String cluster : consonantClusters) {
                if(cluster.equals(word.substring(0, cluster.length()))) {
                    return word.substring(cluster.length()) + cluster + "ay";
                }
            }
            return word.substring(1) + word.charAt(0) + "ay";
        }
    }
}

