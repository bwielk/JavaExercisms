import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RailFenceCipher {

    private int numOfRows;
    private RailCipherCoords startingPoint;
    private RailCipherDirection currentDirection = RailCipherDirection.DOWN;
    private String unnecessaryPunctuationRegex = "[\"\\#$%&()*+,\\s\n\r\t\\-./:;<=>@\\[\n\\\\\\]^_‘{|}~]";

    public RailFenceCipher(@NotNull int numOfRows){
        this.numOfRows = numOfRows;
        this.startingPoint = new RailCipherCoords(0,0);
    }

    public String getEncryptedData(@NotNull String stringToConsume){
        char[][] rails = new char[numOfRows][stringToConsume.length()];
        char[] splitWord = stringToConsume.toCharArray();
        RailCipherCoords newCoords = new RailCipherCoords();
        for(int c = 0; c<stringToConsume.length(); c++){
            if(c==0){
                rails[startingPoint.getY()][startingPoint.getX()]=splitWord[c];
            }else{
                newCoords = new RailCipherCoords(startingPoint.getX()+currentDirection.getCoords().getX(),
                        startingPoint.getY()+currentDirection.getCoords().getY());
                try{
                    rails[newCoords.getY()][newCoords.getX()]=splitWord[c];
                }catch (IndexOutOfBoundsException e){
                    currentDirection = currentDirection == RailCipherDirection.UP ? RailCipherDirection.DOWN : RailCipherDirection.UP;
                    newCoords = new RailCipherCoords(startingPoint.getX()+currentDirection.getCoords().getX(),
                            startingPoint.getY()+currentDirection.getCoords().getY());
                    rails[newCoords.getY()][newCoords.getX()]=splitWord[c];
                }
            }
            startingPoint=newCoords;
        }
        StringBuilder result = new StringBuilder();
        for(int row=0; row<rails.length; row++){
            result.append(Arrays.toString(rails[row]).replaceAll(unnecessaryPunctuationRegex, ""));
        }
        for(int i=0; i<rails.length; i++){
            System.out.println(Arrays.toString(rails[i])+"\n");
        }
        String resultAsString = result.toString();
        return resultAsString;
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
