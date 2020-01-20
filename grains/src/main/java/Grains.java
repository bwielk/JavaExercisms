import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Grains {

    private List<Integer> grainsOnBoard;

    BigInteger grainsOnSquare(final int square) {
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(1);
        for(int i=0; i<square; i++){
            grainsOnBoard.add(grainsOnBoard.get(i)*2);
        }
        return BigInteger.valueOf(grainsOnBoard.get(square-1));
    }

    BigInteger grainsOnBoard() {
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(1);
        grainsOnSquare(64);
        return BigInteger.valueOf(grainsOnBoard.stream().reduce(Integer::sum).get());
    }
}
