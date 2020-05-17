public class Frame {

    private int firstRoll = -1;
    private int secondRoll = -1;
    private boolean isCompleted = false;
    private boolean isStrike = false;

    public void setFirstRoll(int firstRoll) {
        if(firstRoll==10){
            isCompleted=true;
            isStrike=true;
            this.secondRoll = 0;
        }
        this.firstRoll = firstRoll;
    }

    public void setSecondRoll(int secondRoll) {
        if(!isCompleted){
            this.secondRoll = secondRoll;
            isCompleted=true;
        }
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public int getTotalRolls(){
        return this.firstRoll + this.secondRoll;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public boolean isStrike() {
        return isStrike;
    }
}
