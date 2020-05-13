import java.util.ArrayList;
import java.util.List;

class WordProblemSolver {

    public int solve(String sentence){
        String foundNumberAsChars = "";
        List<Integer> foundNumbers = new ArrayList<>();
        for(int c=0; c<sentence.length(); c++){
            if(Character.isDigit(sentence.charAt(c))){
                try{
                    if(sentence.charAt(c-1)=='-'){
                        foundNumberAsChars+=sentence.charAt(c-1);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }

                int startingCharForIntSearch = c;
                while(Character.isDigit(sentence.charAt(startingCharForIntSearch))){
                    foundNumberAsChars+=sentence.charAt(startingCharForIntSearch);
                    startingCharForIntSearch +=1;
                }
                c=startingCharForIntSearch;
                foundNumbers.add(Integer.parseInt(foundNumberAsChars));
                foundNumberAsChars = "";
            }
        }
        if(foundNumbers.size() == 1){
            return foundNumbers.get(0);
        }else{
            if(sentence.contains("plus")){
                return foundNumbers.stream().reduce(0, Integer::sum);
            }
            if(sentence.contains("minus")){
                return foundNumbers.get(0)-foundNumbers.get(1);
            }
            if(sentence.contains("multipl")){
                return  foundNumbers.get(0)*foundNumbers.get(1);
            }
            if(sentence.contains("divide")){
                return  foundNumbers.get(0)/foundNumbers.get(1);
            }
        }
        return 0;
    }
}
