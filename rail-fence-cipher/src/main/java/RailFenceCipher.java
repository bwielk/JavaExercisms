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
        String cleanedUpResult = sb.toString().replace("\u0000", "");
        return cleanedUpResult;
    }

    public String getDecryptedData(String stringToConsume){
        char[][] matrix = new char[numOfRows][stringToConsume.length()];
        int[] intervals = new int[]{2*numOfRows-2, 2*numOfRows-2};
        int currentIntervalIndex = 0;
        int indexInRailsMatrix = 0;
        int currentRowIndex = 0;
        for(int i=0; i<stringToConsume.length(); i++){
            try{
                matrix[currentRowIndex][indexInRailsMatrix]=stringToConsume.charAt(i);
            }catch (IndexOutOfBoundsException e){
                intervals[0] = intervals[0]-2 == 0 ? 2*numOfRows-2 : intervals[0]-2;
                intervals[1] = intervals[1] == 2*numOfRows-2 ? 2 : intervals[1]+2;
                currentRowIndex++;
                indexInRailsMatrix = currentRowIndex;
                matrix[currentRowIndex][indexInRailsMatrix] = stringToConsume.charAt(i);
            }
            indexInRailsMatrix+=intervals[currentIntervalIndex];
            currentIntervalIndex = currentIntervalIndex == 1 ? 0 : 1;
        }
        //decrypt the word by columns
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<stringToConsume.length(); i++){
            for(int row=0; row<numOfRows; row++){
                if(matrix[row][i] != '\u0000'){
                    sb.append(matrix[row][i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
