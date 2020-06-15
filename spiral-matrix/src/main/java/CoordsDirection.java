public enum CoordsDirection {

    UP(1, new Coords(0, -1)),
    RIGHT(2, new Coords(1, 0)),
    DOWN(3, new Coords(0, 1)),
    LEFT(4, new Coords(-1, 0));

    private int directionKey;
    private Coords coords;

    CoordsDirection(int directionKey, Coords coords){
        this.directionKey=directionKey;
        this.coords=coords;
    }

    public int getDirectionKey() {
        return directionKey;
    }

    public Coords getCoords(){
        return coords;
    }
}
