enum Signal {

    WINK(1),
    DOUBLE_BLINK(10),
    CLOSE_YOUR_EYES(100),
    JUMP(1000);

    private int value;

    Signal(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
