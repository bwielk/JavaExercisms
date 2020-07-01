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
                //top to bottom
                for(int column=0; column<currentMatrixLine.length; column++){
                    String currentVerticalWord = "";
                    for(int lineMatrix=0; lineMatrix<charMatrix.length; lineMatrix++){
                        currentVerticalWord += charMatrix[lineMatrix][column];
                    }
                    char[] currentVerticalWordAsCharArr = currentVerticalWord.toCharArray();
                    for(int startChar=0; startChar<currentVerticalWord.length(); startChar++){
                        char[] temptArrayForChecks = Arrays.copyOfRange(currentVerticalWordAsCharArr, startChar, currentVerticalWordAsCharArr.length);
                        if(String.valueOf(temptArrayForChecks).contains(word)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    new Pair(column +1, startChar+1),
                                    new Pair(column +1, startChar+word.length())));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }
                    currentVerticalWord = "";
                }
                //bottom to top
                for(int column=0; column<currentMatrixLine.length; column++){
                    String revertedWordToSearchFor = new StringBuffer(word).reverse().toString();
                    String currentVerticalWord = "";
                    for(int lineMatrix=0; lineMatrix<charMatrix.length; lineMatrix++){
                        currentVerticalWord += charMatrix[lineMatrix][column];
                    }
                    char[] currentVerticalWordAsCharArr = currentVerticalWord.toCharArray();
                    for(int startChar=0; startChar<currentVerticalWord.length(); startChar++){
                        char[] temptArrayForChecks = Arrays.copyOfRange(currentVerticalWordAsCharArr, startChar, currentVerticalWordAsCharArr.length);
                        if(String.valueOf(temptArrayForChecks).contains(revertedWordToSearchFor)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    new Pair(column +1, word.length()+1),
                                    new Pair(line, startChar+1)));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }
                    currentVerticalWord = "";
                }
            }
        }
        return resultMap;
    }
}