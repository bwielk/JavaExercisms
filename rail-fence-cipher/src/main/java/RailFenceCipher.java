import com.sun.istack.internal.NotNull;

import java.util.Arrays;

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
        return result.toString();
    }

    public String getDecryptedData(String stringToConsume){
        String result = "";
        return result;
    }
}
