import java.util.*;
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
            case FULL_HOUSE:
                checkFullHouse();
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

    private void checkFullHouse(){
        Map<Integer, Integer> mapOfints = mapNumberOfInts();
        //get keys by their values to check if there are 3 elements of the same number and 2 elements of the same number
        if(mapOfints.size() == 2){
            try{
                int threeNumbersOfOneValue = mapOfints.entrySet().stream().filter(x -> x.getValue() == 3).findFirst().get().getKey()*3;
                int twoNumbersOfOneValue = mapOfints.entrySet().stream().filter(x -> x.getValue() == 2).findFirst().get().getKey()*2;
                result = threeNumbersOfOneValue + twoNumbersOfOneValue;
            }catch (NoSuchElementException e) {
                result = 0;
            }
        }
    }

    private Integer conductFilteringDesiredNumbers(YachtCategory yachtCategory){
        return this.dice.stream().filter(x -> x == yachtCategory.getPoints()).collect(Collectors.toList()).size()*yachtCategory.getPoints();
    }

    private Map<Integer, Integer> mapNumberOfInts(){
        Map<Integer, Integer> mapOfInts = new HashMap<>();
        this.dice.forEach(number -> {
            if(!mapOfInts.keySet().contains(number)){
                mapOfInts.put(number, 1);
            }else{
                mapOfInts.put(number, mapOfInts.get(number)+1);
            }
        });
        return mapOfInts;
    }
}
