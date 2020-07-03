import java.util.*;

class Matrix {

    private List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> coordinates = new HashSet<>();
        if(this.values.isEmpty()){
            return Collections.emptySet();
        }
        Integer rowIndex = 0;
        for(List<Integer> row: values){
            HashMap<List<Integer>, Integer> rowAnalysisResult = findGreaterOrEqualNumberInARow(row);
            List<Integer> indexesOfGreaterOrEqualNumberInARow = new ArrayList<>(rowAnalysisResult.keySet()).get(0);
            Integer greaterOrEqualNumberInARow = new ArrayList<>(rowAnalysisResult.values()).get(0);
            for(Integer index : indexesOfGreaterOrEqualNumberInARow){
                if(isSaddleNumber(index, greaterOrEqualNumberInARow)){
                    MatrixCoordinate coord = new MatrixCoordinate(rowIndex+1, index+1);
                    coordinates.add(coord);
                }
            }
            rowIndex++;
        }
        return coordinates;
    }

    private HashMap<List<Integer>, Integer> findGreaterOrEqualNumberInARow(List<Integer> numbers){
        Integer numberToCompare = Integer.MIN_VALUE;
        //find the greatest number in the row
        for(int i=0; i<numbers.size(); i++){
            if(numberToCompare <= numbers.get(i)){
                numberToCompare = numbers.get(i);
            }
        }
        HashMap<List<Integer>, Integer> results = new HashMap<>();
        //get indexes of the greater or equal number in the row
        List<Integer> listOfIndexes = new ArrayList<>();
        for(int i=0; i<numbers.size(); i++){
            if(numbers.get(i) == numberToCompare){
                listOfIndexes.add(i);
            }
        }
        results.put(listOfIndexes, numberToCompare);
        return results;
    }

    private boolean isSaddleNumber(int columnIndex, int numberToCompare){
        for(int row = 0; row<values.size(); row++){
            if(numberToCompare >= values.get(0).get(columnIndex)){
                return false;
            }
        }
        return true;
    }
}
