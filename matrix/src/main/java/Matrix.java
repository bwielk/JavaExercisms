import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    private String matrixAtString;
    private List<List<String>> matrixes = new ArrayList<>();

    Matrix(String matrixAsString) {
        this.matrixAtString = matrixAsString;
        List<String> splitMatrixStrings = Arrays.asList(matrixAsString.split("\n"));
        for(String row : splitMatrixStrings){
            matrixes.add(Arrays.asList(row.split(" ")));
        }
        System.out.println("HellO");
    }

    int[] getRow(int rowNumber) {
        return matrixes.get(rowNumber-1).stream().mapToInt(Integer::parseInt).toArray();
    }

    int[] getColumn(int columnNumber) {
        int[] ints = new int[]{1};
        return ints;
    }
}
