import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        if(phrase.isEmpty()){
            return true;
        }
        String clearedPhrase = phrase.replaceAll("\\p{Punct}", "")
                .toUpperCase()
                .replaceAll(" ", "");
        Set<String> clearedPhraseAsSet = new HashSet<>(Arrays.asList(clearedPhrase.split("")));
        return clearedPhrase.length() == clearedPhraseAsSet.size();
    }
}
