public class Frame {

    private int firstRoll = -1;
    private int secondRoll = -1;
    private boolean isCompleted = false;

    public void setFirstRoll(int firstRoll) {
        if(firstRoll==10){
            isCompleted=true;
        }
        this.firstRoll = firstRoll;
    }

    public void setSecondRoll(int secondRoll) {
        if(!isCompleted){
            this.secondRoll = secondRoll;
            isCompleted=true;
        }
    }

    public Integer getFirstRoll() {
        return firstRoll;
    }

    public Integer getSecondRoll() {
        return secondRoll;
    }

    public int getTotalRolls(){
        return this.firstRoll + this.secondRoll;
    }

    public boolean isCompleted(){
        return isCompleted;
    }
}
