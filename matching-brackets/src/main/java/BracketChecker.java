import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BracketChecker {

    private String brackets;
    List<String> acceptedBracketPairs = Arrays.asList("[]", "{}", "()");

    public BracketChecker(String bracketsString){
        this.brackets = bracketsString.replace(" ", "");
    }

    public boolean areBracketsMatchedAndNestedCorrectly(){
        String bracketsCopy = this.brackets;
        List<String> reorderedBrackets = new ArrayList<>();
        while(!bracketsCopy.isEmpty()){
            for(String acceptedBracket : acceptedBracketPairs){
                if(bracketsCopy.contains(acceptedBracket)){
                    reorderedBrackets.add(acceptedBracket);
                    int beginningIndex = bracketsCopy.indexOf(acceptedBracket);
                    char[] brokenBrackets = bracketsCopy.toCharArray();
                    brokenBrackets[beginningIndex] = ' ';
                    brokenBrackets[beginningIndex+1] = ' ';
                    bracketsCopy = String.valueOf(brokenBrackets).replaceAll(" " , "");
                }
            }
        }
        if(brackets.length()%2!=0){
            return false;
        }
        this.brackets = String.join("", reorderedBrackets);
        for(int i=0; i<brackets.length(); i+=2){
            String pair = new StringBuffer().append(brackets.charAt(i)).append(brackets.charAt(i+1)).toString();
                if(!acceptedBracketPairs.contains(pair)) {
                    return false;
                }
            }
        return true;
    }
}