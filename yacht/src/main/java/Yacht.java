import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Yacht {

    private List<Integer> dice;
    private YachtCategory yachtCategory;
    private Integer result = 0;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = Arrays.stream(dice).boxed().collect(Collectors.toList());
        this.yachtCategory = yachtCategory;
    }

    public int score() {
        switch (this.yachtCategory){
            case YACHT:
                checkYacht();
                break;
            case ONES:
                checkOnes();
                break;
            case TWOS:
                checkTwos();
                break;
            case THREES:
                checkThrees();
                break;
            case FOURS:
                checkFours();
                break;
            case FIVES:
                checkFives();
                break;
            case SIXES:
                checkSixes();
                break;
        }
       return result;
    }

    private void checkYacht(){
        if(this.dice.stream().distinct().count()==1) {
            result = yachtCategory.getPoints();
        }
    }

    private void checkOnes(){
        result = conductFilteringDesiredNumbers(YachtCategory.ONES);
    }

    private void checkTwos(){
        result = conductFilteringDesiredNumbers(YachtCategory.TWOS);
    }

    private void checkThrees(){
        result = conductFilteringDesiredNumbers(YachtCategory.THREES);
    }

    private void checkFours(){
        result = conductFilteringDesiredNumbers(YachtCategory.FOURS);
    }

    private void checkFives(){
        result = conductFilteringDesiredNumbers(YachtCategory.FIVES);
    }

    private void checkSixes(){
        result = conductFilteringDesiredNumbers(YachtCategory.SIXES);
    }

    private Integer conductFilteringDesiredNumbers(YachtCategory yachtCategory){
        return this.dice.stream().filter(x -> x == yachtCategory.getPoints()).collect(Collectors.toList()).size()*yachtCategory.getPoints();
    }
}
