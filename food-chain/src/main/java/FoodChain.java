import java.util.Arrays;
import java.util.List;

class FoodChain {

    private List<String> foodList;

    public FoodChain(){
        foodList = Arrays.asList("fly", "spider", "bird");
    }

    public String verse(Integer verse){
        String result = "";
        for(int i=verse-1; i>-1; i--){
            if(i == verse-1){
                result += String.format("I know an old lady who swallowed a %s.\n", foodList.get(i));
            }
            if(i==1){
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
