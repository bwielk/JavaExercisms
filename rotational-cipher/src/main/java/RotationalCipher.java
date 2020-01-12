import java.util.Arrays;
import java.util.List;

class RotationalCipher {

    private int shiftKey;
    private char[] alphabet;

    RotationalCipher(int shiftKey) {
       this.shiftKey = shiftKey;
       alphabet = new char[26];
       for(int i = 0; i<26;i++) {
           alphabet[i] = (char)('a'+i);
       }
    }

    String rotate(String data) {
        String result = "";
        for(int index=0; index<data.length(); index++){
            int indexOfTheCharacterInAlphabet = findIndexOfACharInString(data.charAt(index));
            result += alphabet[indexOfTheCharacterInAlphabet];
        }
        return result;
    }

    int findIndexOfACharInString(Character c){
        int indexToReturn = 0;
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i] == c){
                indexToReturn = i;
            }
        }
        return indexToReturn;
    }
}
