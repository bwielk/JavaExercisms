import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PigLatinTranslator{

    private List<String> vowels;
    private List<String> consonantClusters;

    public PigLatinTranslator(){
        vowels = Arrays.asList("a", "e", "i", "o", "u", "xr", "yt");
        consonantClusters = Arrays.asList("ch", "qu", "squ", "sch", "thr", "th", "y");
    }

    public String translate(String input) {
        List<String> result = new ArrayList<>();
        List<String> splitInput = Arrays.asList(input.replaceAll("\\s+", " ").split(" "));
        splitInput.forEach(x -> {
            String processedWord = conductWordTranslation(x);
            result.add(processedWord);
        });
        return String.join(" ", result);
    }

    public String conductWordTranslation(String word){
        if(vowels.stream().anyMatch(v-> word.substring(0, v.length()).equals(v))){
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

