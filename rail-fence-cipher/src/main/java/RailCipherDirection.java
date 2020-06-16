public enum RailCipherDirection {

    UP(1),
    DOWN(0);

    private int value;

    RailCipherDirection(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


