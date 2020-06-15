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
                    //calculate new coords
                    newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                    newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                    //if a field is already populated, we need to change direction of the spiral
                    if(matrix[newCoords.getY()][newCoords.getX()]!=0){
                        changeDirection();
                        newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                        newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                        matrix[newCoords.getY()][newCoords.getX()]=i;
                    }else{
                        //if a field is not populated and is still within the matrix, populate the field
                        matrix[newCoords.getY()][newCoords.getX()]=i;
                    }
                //exception will occur if coords exceed the remit of the matrix
                }catch (IndexOutOfBoundsException e){
                    changeDirection();
                    newCoords.setX(startingCoords.getX()+direction.getCoords().getX());
                    newCoords.setY(startingCoords.getY()+direction.getCoords().getY());
                    matrix[newCoords.getY()][newCoords.getX()]=i;
                }
                startingCoords=newCoords;
            }
        }
        reset();
        printMatrix();
        return matrix;
    }

    private void changeDirection(){
        final int newDirectionKey = direction.getDirectionKey()+1>4 ? 1 : direction.getDirectionKey()+1;
        direction = Arrays.stream(CoordsDirection.values()).filter(x -> x.getDirectionKey()==newDirectionKey).findFirst().get();
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

    private void reset(){
        startingCoords = new Coords(0, 0);
        direction = CoordsDirection.RIGHT;
    }
}
