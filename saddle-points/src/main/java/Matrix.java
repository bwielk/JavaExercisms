import java.util.*;

class Matrix {

    private List<List<Integer>> values;
    private List<List<Integer>> columns = new ArrayList<>();

    Matrix(List<List<Integer>> values) {
        this.values = values;
        if(!values.isEmpty()){
            for(int col=0; col<values.get(0).size(); col++){
                List<Integer> columnValues = new ArrayList<>();
                for(List<Integer> row : values){
                    columnValues.add(row.get(col));
                }
                this.columns.add(columnValues);
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> coordinates = new HashSet<>();
        if(this.values.isEmpty()){
            return Collections.emptySet();
        }
        Integer rowIndex = 0;
        for(List<Integer> row: values){
            HashMap<Integer, Integer> rowAnalysisResult = findGreaterOrEqualNumberInARow(row);
            for(Integer number : rowAnalysisResult.keySet()){
                Integer columnIndex = number;
                Integer numberToCompare = rowAnalysisResult.get(columnIndex);
                if(isSaddleNumber(columnIndex, numberToCompare)){
                    MatrixCoordinate coord = new MatrixCoordinate(rowIndex+1, columnIndex+1);
                    coordinates.add(coord);
                }
            }
            rowIndex++;
        }
        return coordinates;
    }

    private HashMap<Integer, Integer> findGreaterOrEqualNumberInARow(List<Integer> numbers){
        Integer indexOfTheGreaterOrEqualNumber = 0;
        Integer numberToCompare = Integer.MIN_VALUE;
        for(int i=0; i<numbers.size(); i++){
            if(numberToCompare <= numbers.get(i)){
                numberToCompare = numbers.get(i);
                indexOfTheGreaterOrEqualNumber = i;
            }
        }
        HashMap<Integer, Integer> results = new HashMap<>();
        results.put(indexOfTheGreaterOrEqualNumber, numberToCompare);
        return results;
    }

    private boolean isSaddleNumber(int columnIndex, int numberToCompare){
        int numberToCheck = numberToCompare;
        List<Integer> columnToCheck= this.columns.get(columnIndex);
        for(Integer number : columnToCheck){
            if(numberToCheck > number){
                return false;
            }
        }
        return true;
    }
}
