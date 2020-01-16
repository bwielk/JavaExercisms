import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Matrix {

    private String matrixAtString;
    private List<List<String>> matrixes = new ArrayList<>();

    Matrix(String matrixAsString) {
        this.matrixAtString = matrixAsString;
        List<String> splitMatrixStrings = Arrays.asList(matrixAsString.split("\n"));
        for(String row : splitMatrixStrings) {
            matrixes.add(Arrays.asList(row.split(" ")));
        }
    }

    int[] getRow(int rowNumber) {
        return matrixes.get(rowNumber-1).stream().mapToInt(Integer::parseInt).toArray();
    }

    int[] getColumn(int columnNumber) {
        return matrixes.stream().map(matrixRow -> matrixRow.get(columnNumber-1)).collect(Collectors.toList())
                .stream().mapToInt(Integer::parseInt).toArray();
    }
}
