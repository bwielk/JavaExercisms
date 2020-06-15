import java.util.Arrays;

class SpiralMatrixBuilder {

    private Coords startingCoords = new Coords(0, 0);
    private Coords currentCoords = new Coords(0, 0);
    private CoordsDirection direction = CoordsDirection.RIGHT;

    public int[][] buildMatrixOfSize(int size){
        int[][] matrix =  new int[size][size];
        int maxValue=size*size;
        //populating the very first cell
        if(size > 0){
            matrix[startingCoords.getX()][startingCoords.getY()]=1;
            //traversing through for populating matrix cells
            for(int i=2; i<=maxValue; i++){
                currentCoords.setX(currentCoords.getX()+direction.getCoords().getX());
                currentCoords.setY(currentCoords.getY()+direction.getCoords().getY());
                try{
                    matrix[currentCoords.getX()][currentCoords.getY()]=i;
                }catch (IndexOutOfBoundsException e){
                    final int newDirectionKey = direction.getDirectionKey()+1>4 ? 1 : direction.getDirectionKey()+1;
                    direction = Arrays.stream(CoordsDirection.values()).filter(x -> x.getDirectionKey()==newDirectionKey).findFirst().get();
                    currentCoords.setX(currentCoords.getX()+direction.getCoords().getX());
                    currentCoords.setY(currentCoords.getY()+direction.getCoords().getY());
                    matrix[currentCoords.getX()][currentCoords.getY()]=i;
                }
            }
        }
        return matrix;
    }
}
