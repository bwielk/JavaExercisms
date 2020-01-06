import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {

    private int maxPrime;

    Sieve(int maxPrime) {
       this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> numbers = IntStream.range(2, maxPrime+1).boxed().collect(Collectors.toList());
        for(int index = 0; index<numbers.size(); index++){
            if(numbers.get(index) != 0){
                //given the primary number should remain in place, we're looking for an index of a number that is divisible by 2
                int startingIndex = index + numbers.get(index);
                for(int i = startingIndex; i<=maxPrime; i+=numbers.get(index)){
                    try{
                        //every flagged number in the list is replaced with 0
                        numbers.set(i, 0);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println(e);
                    }
                }
            }
        }
        //we're getting rid of all the 0s that replaced actual numbers
        numbers.removeIf(x -> x == 0);
        return numbers;
    }
}
