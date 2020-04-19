import java.util.Arrays;
import java.util.List;

class FoodChain {

    private List<String> foodList;

    public FoodChain(){
        foodList = Arrays.asList("fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse");
    }

    public String verse(Integer verse){
        String result = "";
        result += String.format("I know an old lady who swallowed a %s.\n", foodList.get(verse-1));
        if(verse == 8) {
            result += "She's dead, of course!";
            return result;
        }
        for(int i=verse-1; i>-1; i--){
            if(i == verse-1 && verse == 7){
                result += String.format("I don't know how she swallowed a %s!\n", foodList.get(i));
            }
            if(i == verse-1 && verse == 6){
                result += String.format("Just opened her throat and swallowed a %s!\n", foodList.get(i));
            }
            if(i == verse-1 && verse == 5){
                result += String.format("What a hog, to swallow a %s!\n", foodList.get(i));
            }
            if(i == verse-1 && verse == 4){
                result += String.format("Imagine that, to swallow a %s!\n", foodList.get(i));
            }
            if(i == verse-1 && verse == 3) {
                result += String.format("How absurd to swallow a %s!\n", foodList.get(i));
            }
            if(verse > 3 && i>2){
                result += String.format("She swallowed the %s to catch the %s.\n", foodList.get(i), foodList.get(i-1));
            }
            if(i == 2 && verse > 2) {
                result += String.format("She swallowed the %s to catch the %s that wriggled and jiggled and tickled inside her.\n" +
                                "She swallowed the %s to catch the %s.\n",
                        foodList.get(i), foodList.get(i-1), foodList.get(i-1), foodList.get(0));
            }
            if(i==1 && verse==2){
                result += String.format("It wriggled and jiggled and tickled inside her.\n" +
                        "She swallowed the %s to catch the %s.\n", foodList.get(i), foodList.get(0));
            }
        }
        result += String.format("I don't know why she swallowed the %s. Perhaps she'll die.",  foodList.get(0));
        return  result;
    }

    public String verses(Integer start, Integer end){
        return "";
    }
}
