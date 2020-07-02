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
                                    new Pair(column +1, startChar+word.length()),
                                    new Pair(column+1, startChar+1)));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }
                    currentVerticalWord = "";
                }
                //diagonal
                for(int charIndex=0; charIndex<currentMatrixLine.length; charIndex++){
                    //check if such coords exist at all
                    int columnNumber = charIndex+1;
                    int rowNumber  = line+1;
                    //top left to bottom right
                    try{
                        String topLeftToBottomRight = "";
                        Pair startCoords = new Pair(charIndex+1, line+1);
                        //iterate to define the diagonal coords - here we care about the length of the search word
                        //rather than its contents
                        for(int wordChar=0; wordChar<word.length(); wordChar++){
                            topLeftToBottomRight += charMatrix[line+wordChar][charIndex+wordChar];
                        }
                        if(topLeftToBottomRight.length() >= word.length() && topLeftToBottomRight.contains(word)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    startCoords,
                                    new Pair(charIndex+word.length(), line+word.length())));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                    }
                    //bottom right to top left
                    try{
                        String bottomRightToTopLeft = "";
                        Pair startCoords = new Pair(columnNumber, rowNumber);
                        //iterate to define the diagonal coords - here we care about the length of the search word
                        //rather than its contents
                        for(int wordChar=0; wordChar<word.length(); wordChar++){
                            bottomRightToTopLeft += charMatrix[line-wordChar][charIndex-wordChar];
                        }
                        if(bottomRightToTopLeft.length() >= word.length() && bottomRightToTopLeft.contains(word)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    startCoords,
                                    new Pair(columnNumber-(word.length()-1), rowNumber-(word.length()-1))));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                    }
                    //bottom left to top right
                    try{
                        String bottomLeftToTopRight = "";
                        Pair startCoords = new Pair(columnNumber, rowNumber);
                        //iterate to define the diagonal coords - here we care about the length of the search word
                        //rather than its contents
                        for(int wordChar=0; wordChar<word.length(); wordChar++){
                            bottomLeftToTopRight += charMatrix[line-wordChar][charIndex+wordChar];
                        }
                        if(bottomLeftToTopRight.length() >= word.length() && bottomLeftToTopRight.contains(word)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    startCoords,
                                    new Pair(columnNumber+(word.length()-1), rowNumber-(word.length()-1))));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                    }
                    //check if such coords exist at all
                    //top right to bottom left
                    try{
                        String topRightToBottomLeft = "";
                        Pair startCoords = new Pair(columnNumber, rowNumber);
                        //iterate to define the diagonal coords - here we care about the length of the search word
                        //rather than its contents
                        for(int wordChar=0; wordChar<word.length(); wordChar++){
                            topRightToBottomLeft += charMatrix[line+wordChar][charIndex-wordChar];
                        }
                        if(topRightToBottomLeft.length() >= word.length() && topRightToBottomLeft.contains(word)){
                            Optional<WordLocation> wordLocationToInsert = Optional.of(new WordLocation(
                                    startCoords,
                                    new Pair(columnNumber-(word.length()-1), rowNumber+(word.length()-1))));
                            System.out.println(wordLocationToInsert.get().toString());
                            resultMap.put(word, wordLocationToInsert);
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                    }
                }
            }
        }
        return resultMap;
    }
}