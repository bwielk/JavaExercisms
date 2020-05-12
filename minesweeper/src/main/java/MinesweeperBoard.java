import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinesweeperBoard {

    public String[] matrix;

    public MinesweeperBoard(List<String> matrixList){
        String[] listToArray = new String[matrixList.size()];
        listToArray = matrixList.toArray(listToArray);
        this.matrix = listToArray;
    }

    public List<String> withNumbers(){
        for(int line=0; line<matrix.length; line++){
            String currentLine = matrix[line];
            for(int index=0; index<currentLine.length(); index++){
                if(currentLine.charAt(index) == '*'){
                    try{
                        for(int lineToCheck=line-1; lineToCheck<=line+1; lineToCheck++){
                            if(lineToCheck >=0){
                                String currentLineToCheck = matrix[lineToCheck];
                                for(int slotToCheck=index-1;slotToCheck<=index+1; slotToCheck++){
                                    if(slotToCheck >=0 && slotToCheck<=currentLineToCheck.length()-1){
                                        if(Character.isDigit(currentLineToCheck.charAt(slotToCheck))){
                                            char[] newLine = currentLineToCheck.toCharArray();
                                            int currentDigitValue = Integer.parseInt(String.valueOf(newLine[slotToCheck]));
                                            newLine[slotToCheck] = Integer.toString(currentDigitValue+1).charAt(0);
                                            String newLineJoined = String.valueOf(newLine);
                                            currentLineToCheck = newLineJoined;
                                            matrix[lineToCheck]= newLineJoined;
                                        }
                                        if(currentLineToCheck.charAt(slotToCheck) == ' '){
                                            char[] newLine = currentLineToCheck.toCharArray();
                                            newLine[slotToCheck] = '1';
                                            String newLineJoined = String.valueOf(newLine);
                                            currentLineToCheck = newLineJoined;
                                            matrix[lineToCheck] = newLineJoined;
                                        }
                                    }
                                }
                            }
                        }
                    }catch(IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return Arrays.asList(matrix);
    }
}