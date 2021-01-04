public class Frame {

    private int firstRoll;
    private int secondRoll;
    private boolean full = false;
    private int bonusPoint;

    public Frame(int firstRoll) {
        if(firstRoll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        this.firstRoll = firstRoll;
        if(firstRoll == 10){
            full = true;
        }
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        if(!full && firstRoll > -1){
            if(this.firstRoll + secondRoll > 10){
                throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
            }
            this.secondRoll = secondRoll;
            this.full = true;
        }
    }

    public boolean isFull() {
        return full;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        if(full){
            this.bonusPoint = bonusPoint;
        }
    }
}
