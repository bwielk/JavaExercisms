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
        StringBuilder result = new StringBuilder();
        char[] splitWord = word.toCharArray();
        for(int c=0; c<splitWord.length; c++){
            result.append(atbashAlphabetMapping.get(c));
        }
        return result.toString();
    }

    public String decode(String word){
        StringBuilder result = new StringBuilder();
        char[] splitWord = word.toCharArray();
        for(int c=0; c<splitWord.length; c++){
            result.append(atbashAlphabetMapping.get(c));
        }
        return result.toString();
    }
}