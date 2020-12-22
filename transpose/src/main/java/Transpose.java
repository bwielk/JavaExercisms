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
            for(int i=0; i<lengthOfTheLongestString; i++){
                StringBuffer sb = new StringBuffer();
                for(int wordIndex=0; wordIndex<rowsOfText.size(); wordIndex++){
                    if(i>0 && wordIndex==0){
                        sb.append(delimeter);
                    }
                    sb.append(rowsOfText.get(wordIndex).charAt(i));
                }
                cumulativeSb.append(sb.toString());
            }
            return cumulativeSb.toString();
        }
    }
}
