import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Allergies {

    private Integer allergyScore;
    private List<Integer> allergyValues;
    private List<Allergen> allergies;

    public Allergies(Integer allergyScore){
        this.allergyScore = allergyScore;
        this.allergyValues = Arrays.stream(Allergen.values()).map(Allergen::getScore).collect(Collectors.toList());
        Collections.reverse(allergyValues);
        this.allergies = new ArrayList<>();
        for(Integer value : allergyValues){
            if(allergyScore >= value){
                allergyScore-= value;
                allergies.add(Arrays.stream(Allergen.values()).filter(x -> x.getScore() == value).collect(Collectors.toList()).get(0));
            }
        }
        Collections.reverse(allergies);
    }

    public boolean isAllergicTo(Allergen allergen){
        return allergies.contains(allergen);
    }

    public List<Allergen> getList(){
        return this.allergies;
    }
}
