import com.sun.deploy.util.StringUtils;

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
            int lineLength = Math.round(Math.sqrt(textToProcess.length())) == Math.sqrt(textToProcess.length()) ?
                    (int) Math.sqrt(textToProcess.length()) : (int) Math.sqrt(textToProcess.length())+1;
            for(int c=0; c<textToProcess.length(); c+=lineLength){
                try{
                    matrixSplit.add(textToProcess.substring(c, c+lineLength));
                }catch(IndexOutOfBoundsException e){
                    String stringToAppend = textToProcess.substring(c);
                    if(stringToAppend.length() < lineLength){
                        stringToAppend += String.join("", Collections.nCopies(lineLength-stringToAppend.length(), " "));
                        matrixSplit.add(stringToAppend);
                    }
                }

            }
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