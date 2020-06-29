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
            int aSide = (int) Math.round(Math.sqrt(textToProcess.length()));
            for(int c=0; c<textToProcess.length(); c+=aSide){
                try{
                    matrixSplit.add(textToProcess.substring(c, c+aSide));
                }catch(IndexOutOfBoundsException e){
                    String stringToAppend = textToProcess.substring(c);
                    if(stringToAppend.length() < aSide){
                        stringToAppend += String.join("", Collections.nCopies(aSide-stringToAppend.length(), " "));
                        matrixSplit.add(stringToAppend);
                    }
                }

            }
            for(int charIndex = 0; charIndex<aSide; charIndex++){
                String newWord = "";
                for(String word : matrixSplit){
                    newWord += word.charAt(charIndex);
                }
                result += newWord;
                if(charIndex+1 != aSide){
                    result += " ";
                }
            }
            return result;
        }
        return textToProcess;
    }
}