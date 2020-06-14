enum Orientation {

    NORTH(1, new GridPosition(0, 1)),
    EAST(2, new GridPosition(1, 0)),
    SOUTH(3, new GridPosition(0, -1)),
    WEST(4, new GridPosition(-1, 0));

    private int value;
    private GridPosition gridPosition;

    Orientation(int value, GridPosition gridPosition){
        this.value = value;
        this.gridPosition = gridPosition;
    }

    public int getValue() {
        return value;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }
}
