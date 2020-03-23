import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> results = new ArrayList<>();
        Integer binaryValue = Integer.parseInt(Integer.toBinaryString(number));
        //create a list of values assigned to gestures
        List<Integer> values = Arrays.asList(Signal.values()).stream().map(x -> x.getValue()).collect(Collectors.toList());
        Collections.sort(values);
        Collections.reverse(values);
        //determine if the order of the results has to be reversed in the end
        boolean toBeReversed = binaryValue >= 10000;
        if(toBeReversed){
            binaryValue -=10000;
        }
        for(Integer num : values){
            if(binaryValue >= num){
                results.add(Arrays.asList(Signal.values()).stream().filter(x -> x.getValue() == num).collect(Collectors.toList()).get(0));
                binaryValue -= num;
            }
        }
        //if no need to reverse, then retain the standard logic.
        if(!toBeReversed){
            Collections.reverse(results);
        }
        return results;
    }
}
