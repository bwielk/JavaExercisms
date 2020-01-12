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
        boolean isUpperCase = false;
        for(int index=0; index<data.length(); index++){
            if(Character.isAlphabetic(data.charAt(index))){
                Character character = data.charAt(index);
                isUpperCase = Character.isUpperCase(character);
                int indexOfTheCharacterInAlphabet = findIndexOfACharInString(character);
                int rotationalIndex = 0;
                if(indexOfTheCharacterInAlphabet+shiftKey >= 26){
                    rotationalIndex = (indexOfTheCharacterInAlphabet+shiftKey%alphabet.length);
                }else{
                    rotationalIndex = indexOfTheCharacterInAlphabet+shiftKey;
                }
                Character charToAdd = alphabet[rotationalIndex];
                result += isUpperCase ? charToAdd.toString().toUpperCase() : charToAdd.toString().toLowerCase();
            }else{
                result += data.charAt(index);
            }
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
