import java.util.*;
import java.util.stream.Collectors;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        Map<String, Integer> results = new HashMap<>();
        for(int index=0; index<=inputNumber.length()-numberOfDigits; index++){
            String seriesOfNumbers = inputNumber.substring(index, index+numberOfDigits);
            List<Integer> sequenceOfInts = Arrays.asList(inputNumber.split(""))
                    .stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
            Integer productOfMultiplying =  sequenceOfInts.stream()
                    .reduce(1, (x, y) -> x*y);
            results.put(seriesOfNumbers, productOfMultiplying);
        }
        return (long) Collections.max(results.values());
    }
}
