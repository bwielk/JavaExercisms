import java.util.*;

class House{

    private List<String> items;
    private Map<Integer, String> verses;

    public House(){
        items = Arrays.asList("", "malt", "rat", "cat");
        verses = new HashMap<>();
        verses.put(3, " ate the %s ");
        verses.put(4, " killed the %s ");
    }

    public String verse(Integer verse){
        String result = "";
        if(verse <= 1){
            return "This is the house that Jack built.";
        }else{
            result+= String.format("This is the %s ", items.get(verse-1));
        }
        int verseToAdd = verse;
        for(int i=verse-2; i!=0; i--, verseToAdd--){
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