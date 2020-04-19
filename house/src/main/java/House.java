import java.util.*;

class House{

    private List<String> items;
    private Map<Integer, String> verses;

    public House(){
        items = Arrays.asList("", "malt", "rat");
        verses = new HashMap<>();
        verses.put(1, " is the %s ");
        verses.put(2, " ate the %s ");
    }

    public String verse(Integer verse){
        String result = "";
        if(verse <= 1){
            return "This is the house that Jack built.";
        }else{
            result+= "This";
        }
        int verseToAdd = 1;
        for(int i=verse-1; i!=0; i--, verseToAdd++){
            if(i <= verse-2){
                result+= "that";
            }
            result+=String.format(verses.get(verseToAdd), items.get(i));
        }
        result += "that lay in the house that Jack built.";
        return result;
    }

    public String verses(Integer start, Integer end){
        return "";
    }

    public String sing(){
        return "";
    }
}