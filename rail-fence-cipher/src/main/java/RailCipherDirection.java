public enum RailCipherDirection {

    UP(1, new RailCipherCoords(1, -1)),
    DOWN(0, new RailCipherCoords(1,1));

    private int value;
    private RailCipherCoords coords;

    RailCipherDirection(int value, RailCipherCoords railCipherCoords){
        this.value = value;
        this.coords = railCipherCoords;
    }

    public int getValue() {
        return value;
    }

    public RailCipherCoords getCoords() {
        return coords;
    }
}


