import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Transpose{

    public String transpose(String input){
        String result = "";
        char[][] mappedCharsOfInputLines;
        if(input.length()<2){
            return input;
        }else{
            List<String> splitString = Arrays.asList(input.split("\n"));
            Integer lengthOfTheLongestString = Collections.max(splitString.stream().map(String::length).collect(Collectors.toList()));
            mappedCharsOfInputLines = new char[splitString.size()][lengthOfTheLongestString];
            for(int line=0; line<splitString.size(); line++){
               char[] lineToCharArr = splitString.get(line).toCharArray();
               if(lineToCharArr.length != lengthOfTheLongestString){
                   char[] filling = new char[lengthOfTheLongestString-lineToCharArr.length];
                   Arrays.fill(filling, ' ');
                   char[] currentLine = Arrays.copyOf(lineToCharArr, lineToCharArr.length+filling.length);
                   System.arraycopy(filling, 0, currentLine, lineToCharArr.length, filling.length);
                   mappedCharsOfInputLines[line] = currentLine;
               }else{
                   mappedCharsOfInputLines[line]=lineToCharArr;
               }
            }
            for(int column=0; column<lengthOfTheLongestString; column++){
                StringBuffer sb = new StringBuffer();
                for(int row=0; row<splitString.size(); row++){
                    if(mappedCharsOfInputLines[row][column] == '\0'){
                        sb.append(" ");
                    }else{
                        sb.append(mappedCharsOfInputLines[row][column]);
                    }
                }
                if(column+1<lengthOfTheLongestString){
                    sb.append("\n");
                }
                result+=sb.toString();
            }
        }
        System.out.println(mappedCharsOfInputLines.toString());
        return result;
    }
}
