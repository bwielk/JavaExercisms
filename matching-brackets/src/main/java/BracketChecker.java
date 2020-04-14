import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BracketChecker {

    private String brackets;
    List<String> acceptedBracketPairs = Arrays.asList("[]", "{}", "()");

    public BracketChecker(String bracketsString){
        this.brackets = bracketsString.replace(" ", "").replaceAll("[a-zA-Z0-9!\\\\\"#$%&'*+,-.\\/:;<=>?@^_`|~]", "");
    }

    public boolean areBracketsMatchedAndNestedCorrectly(){
        String bracketsCopy = this.brackets;
        List<String> reorderedBrackets = new ArrayList<>();
        Integer attemptsToFindAnExistingPairOfBrackets = 0;
        while(attemptsToFindAnExistingPairOfBrackets<=3){
            for(String acceptedBracket : acceptedBracketPairs){
                if(bracketsCopy.contains(acceptedBracket)){
                    int beginningIndex = bracketsCopy.indexOf(acceptedBracket);
                    char[] brokenBrackets = bracketsCopy.toCharArray();
                    brokenBrackets[beginningIndex] = ' ';
                    brokenBrackets[beginningIndex+1] = ' ';
                    bracketsCopy = String.valueOf(brokenBrackets).replaceAll(" " , "");
                    attemptsToFindAnExistingPairOfBrackets=0;
                    this.brackets += acceptedBracket;
                }else{
                    attemptsToFindAnExistingPairOfBrackets++;
                    if(attemptsToFindAnExistingPairOfBrackets == 3){
                        break;
                    }
                }
            }
        }
        if(brackets.length()%2!=0){
            return false;
        }

        for(int i=0; i<brackets.length(); i+=2){
            String pair = new StringBuffer().append(brackets.charAt(i)).append(brackets.charAt(i+1)).toString();
                if(!acceptedBracketPairs.contains(pair)) {
                    return false;
                }
            }
        return true;
    }
}