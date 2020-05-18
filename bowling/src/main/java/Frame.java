public class Frame {

    private int firstRoll = -1;
    private int secondRoll = -1;
    private boolean isCompleted = false;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private boolean isFirstRollThrown = false;

    public void setFirstRoll(int firstRoll) {
        if(!isFirstRollThrown){
            if(firstRoll==10){
                isCompleted=true;
                isStrike=true;
                secondRoll = 0;
            }
            this.firstRoll = firstRoll;
            isFirstRollThrown=true;
        }
    }

    public void setSecondRoll(int secondRoll) {
        if(!isCompleted && isFirstRollThrown){
            this.secondRoll = secondRoll;
            if(firstRoll+secondRoll == 10){
                isSpare = true;
            }
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
        return firstRoll + secondRoll;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }
}
