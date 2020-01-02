import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.replace(" ", "").length() < 2) {
            return false;
        }else{
            //turns chars into integers. Returns false if it comes across a non digit value that in fact should not be there
            List<Integer> candidateAsList;
            try{
                 candidateAsList = Arrays.asList(candidate.split(""))
                        .stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
            }catch(NumberFormatException e){
                return false;
            }
            //conducts required calculations and replacements from right to left of the list of digits
            for(int i = candidateAsList.size()-2; i>=0; i-=2){
                int numberToDouble = candidateAsList.get(i)*2;
                int replacingValue = numberToDouble>9 ? numberToDouble-9 : numberToDouble;
                candidateAsList.set(i, replacingValue);
            }
            //summing up all the values from the list of digits after calculations
            Integer totalOfNewlyCalculatedLuhn = candidateAsList.stream().mapToInt(Integer::intValue).sum();
            return totalOfNewlyCalculatedLuhn%10 ==0;
        }
    }
}
