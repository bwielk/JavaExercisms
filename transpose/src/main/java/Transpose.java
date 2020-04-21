import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Transpose{

    public String transpose(String input){
        String result = "";
        if(!input.contains("\n")){
            char[] splitInput = input.toCharArray();
            for(int c=0; c<input.length();c++){
                result+=splitInput[c];
                if(c<input.length()-1){
                    result+="\n";
                }
            }
        }else{
            List<String> splitString = Arrays.asList(input.split("\n"));
            Integer lengthOfTheLongestString = Collections.max(splitString.stream().map(String::length).collect(Collectors.toList()));
            for(int i=0; i<lengthOfTheLongestString; i++){
                String transposedWord = "";
                for(String word: splitString){
                    try{
                        if(!transposedWord.isEmpty()
                                && transposedWord.charAt(transposedWord.length()-1) == ' '
                                && word.charAt(i)!=' '){
                            char[] transposedWordToReplace = transposedWord.toCharArray();
                            transposedWordToReplace[transposedWord.length()-1] = ' ';
                            transposedWord=String.valueOf(transposedWordToReplace);
                        }
                        transposedWord+=word.charAt(i);
                    }catch (StringIndexOutOfBoundsException e){
                        transposedWord+=" ";
                    }
                }
                result+=transposedWord;
                if(i<lengthOfTheLongestString-1){
                    result+="\n";
                }
            }
        }
        return result;
    }
}
