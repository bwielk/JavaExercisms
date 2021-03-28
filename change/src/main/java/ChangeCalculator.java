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
        List<List<Integer>> possibleResults = new ArrayList<>();
        for(int coinValueIndex=availableChangeCoins.size()-1; coinValueIndex>-1; coinValueIndex--){
            int processedValue = valueToCompute;
            int currentCoinIndex = coinValueIndex;
            List<Integer> result = new ArrayList<>();
            for(int i=currentCoinIndex; i>-1; i--){
                int currentCoinValue = availableChangeCoins.get(i);
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
            Collections.sort(result);
            if(result.stream().mapToInt(Integer::intValue).sum() == valueToCompute){
                possibleResults.add(result);
            }
        }
        return findTheMostEfficientList(possibleResults);
    }

    public List<Integer> findTheMostEfficientList(List<List<Integer>> lists){
        if(lists.size() > 1){
            List<Integer> smallest = lists.get(0);
            for (int i = 1; i < lists.size(); i++) {
                if (lists.get(i).size() < smallest.size()) {
                    smallest = lists.get(i);
                }
            }
            return smallest;
        }
        if(lists.size() == 1){
            return lists.get(0);
        }
        return null;
    }
}