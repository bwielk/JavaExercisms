import java.util.Arrays;
import java.util.List;

class BracketChecker {

    private String brackets;
    List<String> acceptedBracketPairs = Arrays.asList("[]", "{}", "()");

    public BracketChecker(String bracketsString){
        this.brackets = bracketsString;
    }

    public boolean areBracketsMatchedAndNestedCorrectly(){
        for(int i=0; i<brackets.length(); i+=2){
            String pair = new StringBuffer().append(brackets.charAt(i)).append(brackets.charAt(i+1)).toString();
                if(!acceptedBracketPairs.contains(pair)) {
                    return false;
                }
            }
        return true;
    }
}