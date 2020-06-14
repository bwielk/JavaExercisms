enum Orientation {

    NORTH(1), EAST(2), SOUTH(3), WEST(4);

    private int value;

    Orientation(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
