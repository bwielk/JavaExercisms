import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SumOfMultiples {

    private List<Integer> setOfNumbers;
    private Integer numbertoCheck;

    SumOfMultiples(int number, int[] set) {
        this.setOfNumbers = IntStream.of(set).boxed().collect(Collectors.toList());
        this.numbertoCheck = number;
    }

    int getSum() {
        int valueToReturn = 0;
        if(this.setOfNumbers.stream().anyMatch(x -> x > this.numbertoCheck)){
            valueToReturn = 0;
        }
        return valueToReturn;
    }

}
