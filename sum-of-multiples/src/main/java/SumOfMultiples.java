import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {

    private List<Integer> setOfNumbers;
    private Integer numbertoCheck;

    SumOfMultiples(int number, int[] set) {
        this.setOfNumbers = IntStream.of(set).boxed().collect(Collectors.toList());
        this.numbertoCheck = number;
        //get rid of the 0s
        this.setOfNumbers.removeIf(x -> x == 0);
    }

    int getSum() {
        List<Integer> alreadyAddedMultiples =  new ArrayList<>();

        int valueToReturn = 0;
        if(this.setOfNumbers.stream().allMatch(x -> x > this.numbertoCheck)){
            return valueToReturn;
        }else{
            for(Integer factorFromSet : setOfNumbers) {
                for (int presumableMultiple = 0; presumableMultiple < numbertoCheck; presumableMultiple++) {
                    if (presumableMultiple % factorFromSet == 0 && !alreadyAddedMultiples.contains(presumableMultiple)) {
                        alreadyAddedMultiples.add(presumableMultiple);
                        valueToReturn += presumableMultiple;
                    }
                }
            }
        }
        return valueToReturn;
    }
}
