import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PigLatinTranslator{

    private List<String> vowels;
    private List<String> consonantClusters;

    public static final String CONSONANTS_CLUSTERS = "[^aeiou\\s]";
    public static final String CONSONANTS_PROCEEDED_BY_Y = CONSONANTS_CLUSTERS + "+y";
    public static final String CONSONANTS_PROCEEDED_B_Y_AND_CHARS = CONSONANTS_PROCEEDED_BY_Y +"+\\w+";

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
        //If a word contains a "y" after a consonant cluster
        if(word.matches(CONSONANTS_PROCEEDED_B_Y_AND_CHARS) && word.length()>2){
            //only the consonant cluster at the beginning of the word we're interested in, hence adding ^
            Pattern p = Pattern.compile(CONSONANTS_PROCEEDED_BY_Y);
            Matcher m = p.matcher(word);
            if(m.find()){
                //m.end - 1 -> reason: to exclude the "y" found by Pattern p
                return word.substring(m.end()-1) + word.substring(m.start(), m.end()-1) + "ay";
            }
        }
        //If a word begins with a vowel sound, add an "ay" sound to the end of the word.
        //Please note that "xr" and "yt" at the beginning of a word make vowel sounds
        if(vowels.stream().anyMatch(v-> word.substring(0, v.length()).equals(v))){
            return word + "ay";
        }else{
            //If a word starts with a consonant sound followed by "qu", move it to the end of the word, and then add an "ay"
            // If a word begins with a consonant sound,
            // move it to the end of the word and then add an "ay" sound to the end of the word.
            for(String cluster : consonantClusters) {
                try{
                    if(cluster.equals(word.substring(0, cluster.length()))) {
                        return word.substring(cluster.length()) + cluster + "ay";
                    }
                }catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }
            return word.substring(1) + word.charAt(0) + "ay";
        }
    }
}

