import java.util.*;
import java.util.stream.Collectors;

class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits > inputNumber.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if(Arrays.asList(inputNumber.split(""))
                .stream()
                .anyMatch(x -> Character.isAlphabetic(x.charAt(0)))){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        return conductCalculations(numberOfDigits);
    }

    long conductCalculations(int numberOfDigits){
        Map<String, Integer> results = new HashMap<>();
        for(int index=0; index<=inputNumber.length()-numberOfDigits; index++){
            String seriesOfNumbers = inputNumber.substring(index, index+numberOfDigits);
            List<Integer> sequenceOfInts = Arrays.asList(seriesOfNumbers.split(""))
                    .stream().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
            Integer productOfMultiplying =  sequenceOfInts.stream()
                    .reduce(1, (x, y) -> x*y);
            results.put(seriesOfNumbers, productOfMultiplying);
        }
        return (long) Collections.max(results.values());
    }
}
