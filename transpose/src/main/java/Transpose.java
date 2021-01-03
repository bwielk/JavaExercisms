import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Transpose{

    private String delimeter = "\n";
    private String emptyValue = "\u0000";

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
            //transposition array creation
            char[][] transpositionArray = new char[lengthOfTheLongestString][rowsOfText.size()];
            System.out.println(Arrays.deepToString(transpositionArray));
            for(int arr=0; arr<rowsOfText.size(); arr++){
                for(int i=0; i<lengthOfTheLongestString; i++){
                    try{
                        transpositionArray[i][arr] = charGrid[arr][i];
                    }catch (IndexOutOfBoundsException e){
                        if(arr<rowsOfText.size()-1){
                            transpositionArray[i][arr] = ' ';
                        }
                    }
                }
            }
            //create transpose elements clear of null-terminators
            String[] joinedTransposeStrings = new String[lengthOfTheLongestString];
            for(int j=0; j<lengthOfTheLongestString; j++) {
                String line = new String(transpositionArray[j]);
                line = line.replace(emptyValue, "");
                joinedTransposeStrings[j] = line;
            }

            //clear unnecessary trailing spaces
            for(int lineIndex=lengthOfTheLongestString-1; lineIndex >= 0; lineIndex--){
                String joinedLine = joinedTransposeStrings[lineIndex];
                try{
                    if(joinedLine.matches(".*\\s++$") && joinedLine.length() == joinedTransposeStrings[lineIndex-1].length() &&
                            joinedTransposeStrings[lineIndex-1].matches(".*\\s++$")){
                        joinedLine = joinedLine.replaceFirst("\\s++$", "");
                    }
                    joinedTransposeStrings[lineIndex] = joinedLine;
                }catch (IndexOutOfBoundsException e){
                    e.getMessage();
                }
            }
            //buffer elements of the transpose
            for(int x=0; x<lengthOfTheLongestString; x++){
                String line = joinedTransposeStrings[x];
                cumulativeSb.append(line);
                if(x<lengthOfTheLongestString-1){
                    cumulativeSb.append(delimeter);
                }
            }
            String result = cumulativeSb.toString();
            return result;
        }
    }
}
