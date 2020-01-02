import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");
        if (candidate.length() < 2) {
            return false;
        }else{
            List<Integer> candidateAsList;
            try{
                 candidateAsList = Arrays.asList(candidate.split(""))
                        .stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            }catch(NumberFormatException e){
                return false;
            }
            for(int i = candidateAsList.size()-2; i>=0; i-=2){
                int numberToDouble = candidateAsList.get(i)*2;
                if(numberToDouble>9){
                    candidateAsList.set(i, numberToDouble-9);
                }else{
                    candidateAsList.set(i, numberToDouble);
                }
            }
            Integer totalOfNewlyCalculatedLuhn = candidateAsList.stream().mapToInt(Integer::intValue).sum();
            return totalOfNewlyCalculatedLuhn%10 ==0;
        }
    }
}
