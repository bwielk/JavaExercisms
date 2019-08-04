class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int result = 0;
        for(int i=0; i<=input; i++){
            result += i;
        }
        return (int) Math.pow(result, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int result = 0;
        for(int i=0; i<=input; i++){
            result += (int) Math.pow(i, 2);
        }
        return result;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
