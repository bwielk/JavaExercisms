import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int result = IntStream.range(0, input+1).sum();
        return result*result;
    }

    int computeSumOfSquaresTo(int input) {
        int result = IntStream.range(0, input+1).map(x -> x*x).sum();
        return result;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
