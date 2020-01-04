import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Proverb {

    private List<String> words;

    Proverb(String[] words) {
        this.words = Arrays.asList(words).stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public String recite() {
        String result = this.words.size() > 0 ? buildProverb() : "";
        return result;
    }

    public String buildProverb(){
        String concatinatedResults = "";
        for(int wordIndex = 0; wordIndex< this.words.size(); wordIndex++){
            if(wordIndex < this.words.size()-1){
                concatinatedResults += String.format(ProverbCore.LINE, words.get(wordIndex), words.get(wordIndex+1));
            }
        }
        concatinatedResults += String.format(ProverbCore.CLOSING, words.get(0));
        return concatinatedResults;
    }
}

class ProverbCore {
    public static final String CLOSING = "And all for the want of a %s.";
    public static final String LINE = "For want of a %s the %s was lost.\n";
}