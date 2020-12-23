import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Transpose{

    private String delimeter = "\n";

    public String transpose(String input){
        if(input.isEmpty()){
            return input;
        }else{
            List<String> rowsOfText = Arrays.asList(input.split(delimeter));
            Integer lengthOfTheLongestString = Collections.max(rowsOfText.stream().map(String::length).collect(Collectors.toList()));
            StringBuffer cumulativeSb = new StringBuffer();
            //turns rows of strings into array or arrays
            char[][] charGrid = new char[rowsOfText.size()][lengthOfTheLongestString];
            for(int wordIndex=0; wordIndex<rowsOfText.size(); wordIndex++){
                String word = rowsOfText.get(wordIndex);
                charGrid[wordIndex] = word.toCharArray();
            }
            //transposition
            char[][] transpositionArray = new char[lengthOfTheLongestString][rowsOfText.size()];
            for(int arr=0; arr<rowsOfText.size(); arr++){
                for(int i=0; i<lengthOfTheLongestString; i++){
                    try{
                        transpositionArray[i][arr] = charGrid[arr][i];
                    }catch (IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                        transpositionArray[i][arr] = ' ';
                    }
                }
            }

            return cumulativeSb.toString();
        }
    }
}
