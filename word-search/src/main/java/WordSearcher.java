import java.util.*;

class WordSearcher {

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] charMatrix){
        Map<String, Optional<WordLocation>> resultMap = new HashMap<>();
        for(String word : searchWords){
            resultMap.put(word, Optional.empty());
            for(int line=0; line<charMatrix.length; line++){
                char[] currentMatrixLine = charMatrix[line];
                //left to right
                for(int charIndex=0; charIndex<currentMatrixLine.length; charIndex++){
                    char[] temptArrayForChecks = Arrays.copyOfRange(currentMatrixLine, charIndex, currentMatrixLine.length);
                    if(String.valueOf(temptArrayForChecks).contains(word)){
                        Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                new Pair(charIndex+1, line+1 ),
                                new Pair(charIndex+word.length(), line +1)));
                        resultMap.put(word, wordLocationToInsert);
                    }
                }
                //right to left
                for(int charIndex=0; charIndex<currentMatrixLine.length; charIndex++){
                    String reverseWordToSearch = new StringBuffer(word).reverse().toString();
                    char[] temptArrayForChecks = Arrays.copyOfRange(currentMatrixLine, charIndex, currentMatrixLine.length);
                    if(String.valueOf(temptArrayForChecks).contains(reverseWordToSearch)){
                        Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                new Pair(charIndex+word.length(),line +1),
                                new Pair(charIndex+1, line+1 )));
                        System.out.println(wordLocationToInsert.get().toString());
                        resultMap.put(word, wordLocationToInsert);
                    }
                }
            }
        }
        return resultMap;
    }
}