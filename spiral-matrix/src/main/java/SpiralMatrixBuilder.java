import java.util.Arrays;

class SpiralMatrixBuilder {

    private Coords startingCoords = new Coords(0, 0);
    private CoordsDirection direction = CoordsDirection.RIGHT;
    private int[][] matrix;
    private int size;

    public int[][] buildMatrixOfSize(int matrixSize){
        size=matrixSize;
        matrix = new int[size][size];
        int maxValue=size*size;
        //populating the very first cell
        if(size > 0){
            //traversing through for populating matrix cells
            matrix[startingCoords.getX()][startingCoords.getY()]=1;
            for(int i=2; i<=maxValue; i++){
                Coords newCoords = new Coords();
                try{
                    newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                    newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                    if(matrix[newCoords.getY()][newCoords.getX()]!=0){
                        final int newDirectionKey = direction.getDirectionKey()+1>4 ? 1 : direction.getDirectionKey()+1;
                        direction = Arrays.stream(CoordsDirection.values()).filter(x -> x.getDirectionKey()==newDirectionKey).findFirst().get();
                        newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                        newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                        matrix[newCoords.getY()][newCoords.getX()]=i;
                    }else{
                        matrix[newCoords.getY()][newCoords.getX()]=i;
                    }
                }catch (IndexOutOfBoundsException e){
                    final int newDirectionKey = direction.getDirectionKey()+1>4 ? 1 : direction.getDirectionKey()+1;
                    direction = Arrays.stream(CoordsDirection.values()).filter(x -> x.getDirectionKey()==newDirectionKey).findFirst().get();
                    newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                    newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                    matrix[newCoords.getY()][newCoords.getX()]=i;
                }
                startingCoords=newCoords;
            }
        }
        printMatrix();
        return matrix;
    }

    private void printMatrix(){
        String rowString ="";
        for(int row=0; row<size; row++){
            rowString+= Arrays.toString(matrix[row]);
            if(row!=size-1){
                rowString+="\n";
            }
        }
        System.out.println(rowString);
    }
}
