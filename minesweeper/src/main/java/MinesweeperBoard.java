import java.util.Arrays;
import java.util.List;

class MinesweeperBoard {

    public String[] matrix;
    /**
     * Temporarily held content of a line before updating and final insertion to the matrix
     */
    public String currentLineToCheck = "";

    public MinesweeperBoard(List<String> matrixList){
        String[] listToArray = new String[matrixList.size()];
        listToArray = matrixList.toArray(listToArray);
        this.matrix = listToArray;
    }

    public List<String> withNumbers(){
        /**
         * We are going over each line of the matrix
         */
        for(int line=0; line<matrix.length; line++){
            String currentLine = matrix[line];
            /**
             * Here we're checking if we're coming across a '*' char that will kick off
             * the entire mechanism of updating the chars (named here as SLOTS)
             */
            for(int index=0; index<currentLine.length(); index++){
                if(currentLine.charAt(index) == '*'){
                    try{
                        /**
                         * Here we are looping over the lines of matrix starting from the one
                         * above the current line and ending on the one below it.
                         * If the line indexes are out of boundary, then the exception is caught
                         */
                        for(int lineToCheck=line-1; lineToCheck<=line+1; lineToCheck++){
                            if(lineToCheck >=0){
                                this.currentLineToCheck = matrix[lineToCheck];
                                /**
                                 * Here we are looping over the individual chars of the current line,
                                 * updating their content
                                 */
                                for(int slotToCheck=index-1;slotToCheck<=index+1; slotToCheck++){
                                    if(slotToCheck >=0 && slotToCheck<=this.currentLineToCheck.length()-1){
                                        if(Character.isDigit(this.currentLineToCheck.charAt(slotToCheck))){
                                            updatePopulatedDigits(slotToCheck, lineToCheck);
                                        }
                                        if(this.currentLineToCheck.charAt(slotToCheck) == ' '){
                                            populateEmptySlotWith1(slotToCheck, lineToCheck);
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

    /**
     *
     * @param slotToCheck - index of the referential char around which we check neighbouring chars
     * @param lineToCheck - index of a line currently being checked and populated with 1s
     */
    private void populateEmptySlotWith1(int slotToCheck, int lineToCheck){
        char[] newLine = this.currentLineToCheck.toCharArray();
        newLine[slotToCheck] = '1';
        String newLineJoined = String.valueOf(newLine);
        this.currentLineToCheck = newLineJoined;
        this.matrix[lineToCheck] = newLineJoined;
    }

    /**
     *
     * @param slotToCheck - index of the referential char around which we check neighbouring chars
     * @param lineToCheck - index of a line currently being checked and populated with 1s
     */
    private void updatePopulatedDigits(int slotToCheck, int lineToCheck){
        char[] newLine = this.currentLineToCheck.toCharArray();
        int currentDigitValue = Integer.parseInt(String.valueOf(newLine[slotToCheck]));
        newLine[slotToCheck] = Integer.toString(currentDigitValue+1).charAt(0);
        String newLineJoined = String.valueOf(newLine);
        this.currentLineToCheck = newLineJoined;
        this.matrix[lineToCheck]= newLineJoined;
    }
}