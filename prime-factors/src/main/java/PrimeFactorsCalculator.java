import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator{

    public List<Long> calculatePrimeFactorsOf(Long number){
        Long numberToProcess = number;
        List<Long> results = new ArrayList<>();
        for(long i=2; i<number; i++){
            if(isPrimary(i) && numberToProcess%i==0){
                while(numberToProcess%i==0){
                    results.add(i);
                    numberToProcess/=i;
                }
            }
        }
        return results;
    }

    private boolean isPrimary(Long number){
        for(long i=2; i<number; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
