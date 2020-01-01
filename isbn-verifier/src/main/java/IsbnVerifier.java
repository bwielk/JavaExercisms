import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        List<String> numbersInStringToVerify = Arrays.asList(stringToVerify.toUpperCase().replace("-", "").split(""));
        if(numbersInStringToVerify.get(numbersInStringToVerify.size()-1).equals("X")){
            numbersInStringToVerify.set(numbersInStringToVerify.size()-1, "10");
        }

        if(numbersInStringToVerify.size() != 10){
            return false;
        }

        List<Integer> numberInStringToVerify;
        try{
            numberInStringToVerify = numbersInStringToVerify.stream()
                            .map(x -> Integer.parseInt(x))
                            .collect(Collectors.toList());
        }catch(NumberFormatException e){
            return false;
        }

        List<Integer> multipliers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Collections.reverse(multipliers);

        Integer totalSumOfISBNDigitsToCheck = 0;
        for(int i=0; i<multipliers.size(); i++){
            totalSumOfISBNDigitsToCheck += numberInStringToVerify.get(i)*multipliers.get(i);
        }
        return totalSumOfISBNDigitsToCheck%11 == 0;
    }

}