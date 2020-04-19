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
        for(int i=1; i<verse; i++){
            result+=String.format(verses.get(i), items.get(i));
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