import java.util.HashMap;

class Atbash {

    private char[] alphabet = new char[26];
    private HashMap<Character, Character> atbashAlphabetMapping = new HashMap<>();

    public Atbash(){
        for(int i = 0; i < 26; i++) {
            alphabet[i] = (char) (97 + i);
        }
        for(int c = 0; c<alphabet.length; c++){
            atbashAlphabetMapping.put(alphabet[c],alphabet[alphabet.length-1-c]);
        }
    }

    public String encode(String word){
        String unnecessaryPunctuationRegex = "[\"\\#$%&()*+,\\s\n\r\t\\-./:;<=>@\\[\n\\\\\\]^_‘{|}~]";
        StringBuilder result = new StringBuilder();
        char[] splitWord = word.toLowerCase().replaceAll(unnecessaryPunctuationRegex, "").toCharArray();
        for(int c=0; c<splitWord.length; c++){
            char currentChar = splitWord[c];
            if(Character.isDigit(currentChar)){
                result.append(currentChar);
            }else{
                result.append(atbashAlphabetMapping.get(currentChar));
            }
            if((c+1)%5==0){
                result.append(" ");
            }
        }
        return result.toString().trim();
    }

    public String decode(String word){
        StringBuilder result = new StringBuilder();
        char[] splitWord = word.toLowerCase().replace(" ", "").toCharArray();
        for(int c=0; c<splitWord.length; c++){
            result.append(atbashAlphabetMapping.get(splitWord[c]));
        }
        return result.toString();
    }
}