import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RailFenceCipher {

    private int numOfRows;
    private String unnecessaryPunctuationRegex = "[\"\\#$%&()*+,\\s\n\r\t\\-./:;<=>@\\[\n\\\\\\]^_‘{|}~]";

    public RailFenceCipher(@NotNull int numOfRows){
        this.numOfRows = numOfRows;
    }

    public String getEncryptedData(@NotNull String stringToConsume){
        char[][] matrix = new char[numOfRows][stringToConsume.length()];
        boolean goDown = true;
        int rowIndex = 0;
        for(int charIndex=0; charIndex<stringToConsume.length(); charIndex++){
            matrix[rowIndex][charIndex] = stringToConsume.charAt(charIndex);
            //deal with traversing through the appropriate rows of the matrix - the up and down logic
            if(goDown){
                if(rowIndex+1>numOfRows-1){
                    goDown = false;
                    rowIndex--;
                }else{
                    rowIndex++;
                }
            }else{
                if(rowIndex-1<0){
                    goDown = true;
                    rowIndex++;
                }else{
                    rowIndex--;
                }
            }
        }
        //read the encoded lines
        StringBuffer sb = new StringBuffer();
        for(int row=0; row<numOfRows; row++){
            sb.append(new String(matrix[row]));
        }
        System.out.println(Arrays.deepToString(matrix));
        String cleanedUpResult = sb.toString().replace("\u0000", "");
        return cleanedUpResult;
    }

    public String getDecryptedData(String stringToConsume){
        char[][] rails = new char[numOfRows][stringToConsume.length()];
        List<String> splitWord = new ArrayList<>(Arrays.asList(stringToConsume.split("")));
        for(int row = 0; row<numOfRows; row++){
            for(int charToInsert=row; charToInsert<stringToConsume.length(); charToInsert+=numOfRows-row+1){
                rails[row][charToInsert]= splitWord.get(0).toCharArray()[0];
                splitWord.remove(0);
                printList(rails);
            }
        }

        String result = "";
        return result;
    }

    private void printList(char[][] list){
        for(int i=0; i<list.length; i++){
            System.out.println(Arrays.toString(list[i])+"\n");
        }
    }
}
