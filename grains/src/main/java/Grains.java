import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Grains {

    private List<BigInteger> grainsOnBoard;

    BigInteger grainsOnSquare(final int square) {
        if(square <= 0 || square > 64){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(new BigInteger(String.valueOf(1)));
        for(int i=0; i<square-1; i++){
            grainsOnBoard.add(new BigInteger(String.valueOf(grainsOnBoard.get(i))).multiply(new BigInteger(String.valueOf(2))));
        }
        return grainsOnBoard.get(square-1);
    }

    BigInteger grainsOnBoard() {
        grainsOnBoard = new ArrayList<>();
        grainsOnBoard.add(new BigInteger(String.valueOf(1)));
        grainsOnSquare(64);
        return grainsOnBoard.stream().reduce(BigInteger.ZERO, (x, y) -> x.add(y));
    }
}
