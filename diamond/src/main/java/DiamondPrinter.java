import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {

    private char[] alphabet;

    public DiamondPrinter(){
        alphabet = new char[26];
        for(int i = 0; i<26;i++) {
            alphabet[i] = (char)('a'+i);
        }
    }

    List<String> printToList(char a) {
        if(a == 'A'){
            return Collections.singletonList("A");
        }else{
            String[] results;
            char charToSearch = Character.toLowerCase(a);
            //find index of the character
            int indexOfChar = 0;
            for(int i=0; i<alphabet.length; i++){
                if(alphabet[i] == charToSearch){
                    indexOfChar = i;
                }
            }
            //calculate the diamond width and height
            int width = indexOfChar > 0 ? 2*indexOfChar+1 : indexOfChar;
            int height = (indexOfChar+1)*2-1;
            System.out.println(String.format("width: %s, height: %s", width, height));
            //instantiate the results array that will hold strings
            results = new String[height];
            //build the parts of the diamond
            String middleLine = a + String.join("", Collections.nCopies(width-2, " ")) + a;
            results[height/2] = middleLine;
            //build consecutive lines
            int lowerPositionOfALineInTheDiamond = height-1;
            //charPositionLeft and charPositionRight - given we've already created one line, we needed to adjust
            //these values as we no longer care about the char that has already been processed
            for(int i=indexOfChar-1, charPositionLeft=1, charPositionRight=width-2; i>-1; i--, charPositionLeft++, charPositionRight--){
                char[] lineToManipulate = createArrayForString(width);
                char currentCharToInsert = alphabet[i];
                //insert chars into correctly mirrored indexes of a line(string)
                lineToManipulate[charPositionLeft]=currentCharToInsert;
                lineToManipulate[charPositionRight]=currentCharToInsert;
                String stringToInsert = String.valueOf(lineToManipulate).toUpperCase();
                //insert lines(strings) into the correctly mirrored rows
                results[i]=stringToInsert;
                results[lowerPositionOfALineInTheDiamond-i]=stringToInsert;
            }
            return Arrays.asList(results);
        }
    }

    private char[] createArrayForString(int width){
        char[] array = new char[width];
        for(int i=0; i<array.length; i++){
            array[i] = ' ';
        }
        return array;
    }
}
