class CollatzCalculator {

    int computeStepCount(int start) {
        if(start <= 0){
            throw new IllegalArgumentException("Only natural numbers are allowed");
        }
        int numberOfSteps = 0;
        int currentResult = start;
        while(currentResult != 1){
            currentResult = calculate(currentResult);
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    private int calculate(int start){
        return start%2 == 0 ? start/2 : (start*3)+1;
    }

}
