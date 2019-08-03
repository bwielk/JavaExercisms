import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum FactorsResponses{

    FACTOR_3(3, "Pling"),
    FACTOR_5(5, "Plang"),
    FACTOR_7(7, "Plong");

    Integer factor;
    String response;

    FactorsResponses(Integer factor, String response){
        this.factor = factor;
        this.response = response;
    }

    String getResponse(){
        return this.response;
    }

    Integer getFactor(){
        return this.factor;
    }
}

class RaindropConverter {

    String convert(int number) {
        List<Integer> factors = new ArrayList<>();
        String result = "";
        for(int factor=1; factor<=number; factor++){
            if(number%factor == 0){
                factors.add(factor);
            }
        }
        HashMap<Integer, String> consideredFactors = new HashMap<>();
        for(FactorsResponses response : FactorsResponses.values()){
            consideredFactors.put(response.getFactor(), response.getResponse());
        }

        for(Integer factor : consideredFactors.keySet()){
            if(factors.contains(factor)){
                result += consideredFactors.get(factor);
            }
        }
        if(result.equals("")){
            result += String.valueOf(number);
        }
        return result;
    }
}
