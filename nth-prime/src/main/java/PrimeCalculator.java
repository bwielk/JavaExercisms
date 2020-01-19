import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {

    int nth(int nth) {
        Integer numberToCheck = 2;
        List<Integer> primeNumbers = new ArrayList<>();

        if(nth <= 0){
            throw new IllegalArgumentException();
        }else{
            while(true){
                if(isPrime(numberToCheck)){
                    primeNumbers.add(numberToCheck);
                }
                numberToCheck++;
            if(primeNumbers.size() >= nth){
                    break;
                }
            }
        }
        return primeNumbers.get(nth-1);
    }

    private boolean isPrime(int numberToCheck){
        for(int i=2; i<numberToCheck; i++){
            if(numberToCheck%i == 0){
                return false;
            }
        }
        return true;
    }

}
