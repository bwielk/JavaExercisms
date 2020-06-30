import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CryptoSquare {

    private String unnecessaryPunctuationRegex = "[\"\\#$%&(!)*+,\\s\n\r\t\\-./:;<=>@\\[\n\\\\\\]^_‘{|}~]";
    private String textToProcess;
    private List<String> matrixSplit = new ArrayList<>();

    public CryptoSquare(String text){
        textToProcess = text.replaceAll(unnecessaryPunctuationRegex, "").toLowerCase();
    }

    public String getCiphertext(){
        String result = "";
        if(textToProcess.length() > 1){
            //calculate line length
            int lineLength = Math.round(Math.sqrt(textToProcess.length())) == Math.sqrt(textToProcess.length()) ?
                    (int) Math.sqrt(textToProcess.length()) : (int) Math.sqrt(textToProcess.length())+1;
            //split text to process into chunks of lineLength length
            for(int c=0; c<textToProcess.length(); c+=lineLength){
                try{
                    matrixSplit.add(textToProcess.substring(c, c+lineLength));
                }catch(IndexOutOfBoundsException e){
                    //add white spaces where the remaining string is shorter than lineLength
                    String stringToAppend = textToProcess.substring(c);
                    if(stringToAppend.length() < lineLength){
                        stringToAppend += String.join("", Collections.nCopies(lineLength-stringToAppend.length(), " "));
                        matrixSplit.add(stringToAppend);
                    }
                }

            }
            //create lines of encrypted text out of the columns of matrixSplit
            for(int charIndex = 0; charIndex<lineLength; charIndex++){
                String newWord = "";
                for(String word : matrixSplit){
                    newWord += word.charAt(charIndex);
                }
                result += newWord;
                if(charIndex+1 != lineLength){
                    result += " ";
                }
            }
            return result;
        }
        return textToProcess;
    }
}