import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Transpose{

    private String delimeter = "\n";

    public String transpose(String input){
        if(input.isEmpty()){
            return input;
        }else{
            List<String> rowsOfText = Arrays.asList(input.split(delimeter));
            Integer lengthOfTheLongestString = Collections.max(rowsOfText.stream().map(String::length).collect(Collectors.toList()));
            StringBuffer cumulativeSb = new StringBuffer();
            //turns rows of strings into array or arrays
            char[][] charGrid = new char[rowsOfText.size()][lengthOfTheLongestString];
            for(int wordIndex=0; wordIndex<rowsOfText.size(); wordIndex++){
                String word = rowsOfText.get(wordIndex);
                charGrid[wordIndex] = word.toCharArray();
            }

            //transposition array creation
            char[][] transpositionArray = new char[lengthOfTheLongestString][rowsOfText.size()];
            System.out.println(Arrays.deepToString(transpositionArray));
            for(int arr=0; arr<rowsOfText.size(); arr++) {
                for (int i = 0; i < lengthOfTheLongestString; i++) {
                    try {
                        transpositionArray[i][arr] = charGrid[arr][i];
                    } catch (IndexOutOfBoundsException e) {
                        e.getMessage();
                    }
                }
            }

            // deal with the missing transpose spaces - especially important in the mixed line length use case
            for(int indexTranspositionArray = 0; indexTranspositionArray<transpositionArray.length;
                indexTranspositionArray++){
                int lastCharInRow = 0;
                char[] currentArray = transpositionArray[indexTranspositionArray];
                //find index of the last char in the current array so we can fill the gaps of missing spaces where they should be
                for(int indexChar = currentArray.length-1; indexChar>=0; indexChar--){
                    if(currentArray[indexChar] != '\u0000'){
                        lastCharInRow = indexChar;
                        break;
                    }
                }
                //fill missing spaces
                for(int indexChar = 0; indexChar<currentArray.length; indexChar++){
                    if(indexChar < lastCharInRow && currentArray[indexChar] == '\u0000'){
                        currentArray[indexChar] = ' ';
                    }
                }
            }

            //create transpose elements clear of null-terminators
            String[] joinedTransposeStrings = new String[lengthOfTheLongestString];
            for(int j=0; j<lengthOfTheLongestString; j++) {
                String line = new String(transpositionArray[j]);
                line = line.replace("\u0000", "");
                joinedTransposeStrings[j] = line;
            }

            //buffer all the elements
            for(int x=0; x<lengthOfTheLongestString; x++){
                String line = joinedTransposeStrings[x];
                cumulativeSb.append(line);
                if(x<lengthOfTheLongestString-1){
                    cumulativeSb.append(delimeter);
                }
            }
            String result = cumulativeSb.toString();
            return result;
        }
    }
}
