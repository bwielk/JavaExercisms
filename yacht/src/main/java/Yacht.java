import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Yacht {

    private List<Integer> dice;
    private YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.stream(dice).boxed().collect(Collectors.toList());
        this.yachtCategory = yachtCategory;
    }

    public int score() {
        Integer score = 0;
        switch (this.yachtCategory){
            case YACHT:
                score = checkYacht();
                break;
        }
       return score;
    }

    private Integer checkYacht(){
        Integer result = 0;
        if(this.dice.stream().distinct().count()==1) {
            result = yachtCategory.getPoints();
        }
        return result;
    }
}
