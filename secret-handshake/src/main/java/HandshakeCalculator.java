import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> results = new ArrayList<>();
        Integer binaryValue = Integer.parseInt(Integer.toBinaryString(number));
        List<Integer> values = Arrays.asList(Signal.values()).stream().map(x -> x.getValue()).collect(Collectors.toList());
        boolean toBeReversed = binaryValue > 10000;
        if(binaryValue == 10000){
            return results;
        }
        Collections.reverse(values);
        binaryValue = toBeReversed ? binaryValue - 10000 : binaryValue;
        for(Integer num : values){
            if(binaryValue >= num){
                for(Signal signal : Signal.values()){
                    if(num == signal.getValue()) results.add(signal);
                }
                binaryValue -= num;
            }
        }
        return results;
    }

}
