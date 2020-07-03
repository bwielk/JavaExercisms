import java.util.*;

class Matrix {

    private List<List<Integer>> rows;
    private List<List<Integer>> columns = new ArrayList<>();

    Matrix(List<List<Integer>> values) {
        this.rows = values;
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
        if(this.rows.isEmpty()){
            return Collections.emptySet();
        }
        List<Integer> columnIndexes = new ArrayList<>();
        Integer numberToCompareRows;
        for(int rowIndex = 0; rowIndex<rows.size(); rowIndex++){
            numberToCompareRows = Integer.MIN_VALUE;
            columnIndexes.clear();
            //find the greater or equal number
            for(int i=0; i<rows.get(rowIndex).size(); i++){
                if(numberToCompareRows <= rows.get(rowIndex).get(i)){
                    numberToCompareRows = rows.get(rowIndex).get(i);
                }
            }
            //find indexes of the greater or equal number in a row. The indexes essentially become
            //the indexes of columns that will be checked if the numberToCompareRows is actually lesser or equal
            //that others in the column
            for(int i=0; i<rows.get(rowIndex).size(); i++){
                if(rows.get(rowIndex).get(i) == numberToCompareRows){
                    columnIndexes.add(i);
                }
            }
            boolean isLesserOrEqual = true;
            for(Integer columnIndex : columnIndexes){
                //check is the lesser or egual to the rest of nums in the column
                for(int numInColumn=0; numInColumn<columns.get(columnIndex).size(); numInColumn++){
                    if(numberToCompareRows > columns.get(columnIndex).get(numInColumn)){
                        isLesserOrEqual=false;
                        break;
                    }
                }
                if(isLesserOrEqual){
                    coordinates.add(new MatrixCoordinate(rowIndex+1, columnIndex+1));
                }
            }
        }
        return coordinates;
    }
}
