import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String[] listOfNumbers = Integer.toString(numberToCheck).split("");
		int numberOfNumbers = listOfNumbers.length;
		List<Double> results = Arrays.asList(listOfNumbers).stream().map(x -> Math.pow(Double.valueOf(x), numberOfNumbers)).collect(Collectors.toList());
		Integer sumOfresults = results.stream().mapToInt(Double::intValue).sum();
		return sumOfresults == numberToCheck;
	}

}
