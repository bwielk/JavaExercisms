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
        //to allow looping through until it's clear that there are no extractable pair in the string
        Integer attemptsToFindAnExistingPairOfBrackets = 0;
        //opening and closing brackets should create a string of even length
        if(bracketsCopy.length()%2!=0){
            return false;
        }
        //extract nested braces so it can be checked if the string is correct
        while(attemptsToFindAnExistingPairOfBrackets<=3){
            for(String acceptedBracket : acceptedBracketPairs){
                if(bracketsCopy.contains(acceptedBracket)){
                    int beginningIndex = bracketsCopy.indexOf(acceptedBracket);
                    char[] brokenBrackets = bracketsCopy.toCharArray();
                    brokenBrackets[beginningIndex] = ' ';
                    brokenBrackets[beginningIndex+1] = ' ';
                    bracketsCopy = String.valueOf(brokenBrackets).replaceAll(" " , "");
                    attemptsToFindAnExistingPairOfBrackets=0;
                }else{
                    attemptsToFindAnExistingPairOfBrackets++;
                    if(attemptsToFindAnExistingPairOfBrackets == 3){
                        break;
                    }
                }
            }
        }
        //the copy of the string that is the parameter of the entire method should be empty after clearing and bracket extraction
        if(bracketsCopy.length()!=0){
            return false;
        }
        return true;
    }
}