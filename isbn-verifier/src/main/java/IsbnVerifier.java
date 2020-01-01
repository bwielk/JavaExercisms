import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        List<Integer> numberInStringToVerify = Arrays.stream(stringToVerify.replace("-", "")
                .split(""))
                .map(x ->Integer.parseInt(x)).collect(Collectors.toList());
        List<Integer> multipliers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Collections.reverse(multipliers);

        Integer totalResultOfCalculationsToCheck = 0;
        for(int i=0; i<multipliers.size(); i++){
            totalResultOfCalculationsToCheck += numberInStringToVerify.get(i)*multipliers.get(i);
        }
        return totalResultOfCalculationsToCheck%11 == 0;
    }

}