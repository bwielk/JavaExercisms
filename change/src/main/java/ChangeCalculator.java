import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ChangeCalculator {

    private List<Integer> availableChangeCoins;

    public ChangeCalculator(List<Integer> availableChangeValues){
        this.availableChangeCoins = availableChangeValues;
        Collections.sort(availableChangeValues); // sorts the list of available values in increasing order
    }

    public List<Integer> computeMostEfficientChange(int valueToCompute){
        int processedValue = valueToCompute;
        List<Integer> result = new ArrayList<>();
        for(int i=availableChangeCoins.size(); i>0; i--){
            int currentCoinValue = availableChangeCoins.get(i-1);
            if(currentCoinValue <= processedValue){
                int numberOfOccurencesInValue = processedValue/currentCoinValue;
                for(int occ=0; occ<numberOfOccurencesInValue; occ++){
                    result.add(currentCoinValue);
                    processedValue-=currentCoinValue;
                }
                if(processedValue == 0){
                    break;
                }
            }
        }
        return result;
    }
}