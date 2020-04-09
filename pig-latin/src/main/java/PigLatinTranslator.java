import java.util.Arrays;
import java.util.List;

class PigLatinTranslator{

    private List<String> vowels;

    public PigLatinTranslator(){
        vowels = Arrays.asList("aeiou".split(""));
    }

    public String translate(String word) {
        String transformedWord = null;
        if(vowels.contains(String.valueOf(word.charAt(0)))){
            transformedWord = word + "ay";
        }else{
            transformedWord = word.substring(1) + word.charAt(0) + "ay";
        }
        return transformedWord;
    }
}

