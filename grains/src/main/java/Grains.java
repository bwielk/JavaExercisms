import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Grains {

    private List<BigInteger> grainsOnBoard;

    BigInteger grainsOnSquare(final int square) {
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(new BigInteger(String.valueOf(1)));
        for(int i=0; i<square; i++){
            grainsOnBoard.add(new BigInteger(String.valueOf(grainsOnBoard.get(i))).multiply(new BigInteger(String.valueOf(2))));
        }
        return grainsOnBoard.get(square-1);
    }

    BigInteger grainsOnBoard() {
        BigInteger result = new BigInteger(String.valueOf(0));
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(new BigInteger(String.valueOf(1)));
        grainsOnSquare(63);
        return grainsOnBoard.stream().reduce(BigInteger.ZERO, (x, y) -> x.add(y));
    }
}
