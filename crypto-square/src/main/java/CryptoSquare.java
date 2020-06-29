import java.util.ArrayList;
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
                matrixSplit.add(textToProcess.substring(c, c+aSide));
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