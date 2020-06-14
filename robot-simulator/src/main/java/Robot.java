import java.util.Arrays;
import java.util.stream.Collector;

class Robot {

    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition gridPosition, Orientation orientation){
        this.gridPosition = gridPosition;
        this.orientation = orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnLeft(){
        final int result = this.orientation.getValue()-1<1 ? 4 : this.orientation.getValue()-1;
        this.orientation = Arrays.stream(Orientation.values()).filter(x->x.getValue()==result).findFirst().get();
    }

    public void turnRight(){
        final int result = this.orientation.getValue()+1>4 ? 1 : this.orientation.getValue()+1;
        this.orientation = Arrays.stream(Orientation.values()).filter(x->x.getValue()==result).findFirst().get();
    }

    public void advance(){
        GridPosition expectedGridManipulationChange = this.orientation.getGridPosition();
        int newX = this.gridPosition.getX()+expectedGridManipulationChange.getX();
        int newY = this.gridPosition.getY()+expectedGridManipulationChange.getY();
        this.gridPosition =  new GridPosition(newX, newY);
    }

    public void simulate(String directions){

    }
}