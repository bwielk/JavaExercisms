public class Frame {

    private int firstRoll;
    private int secondRoll;
    private boolean isFull = false;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private int indexOfFirstRoll;
    private int[] indexeOfStrikeBonusRolls = new int[2];
    private int indexOfSpareBonusRoll;
    private int strikeBonusFirstRoll;
    private int strikeBonusSecondRoll;
    private int bonusSparePoint;
    private boolean frameLocked = false;

    public Frame(int firstRoll, int indexOfFirstRoll) {
        this.indexOfFirstRoll = indexOfFirstRoll;
        if(firstRoll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        this.firstRoll = firstRoll;
        if(firstRoll == 10){
            this.isFull = true;
            this.isStrike = true;
            for(int i=0; i<this.indexeOfStrikeBonusRolls.length; i++){
                this.indexeOfStrikeBonusRolls[i] = indexOfFirstRoll+(i+1);
            }
        }
    }

    public boolean isStrike() {
        return this.isStrike;
    }

    public boolean isFrameLocked() {
        return this.frameLocked;
    }

    public void lockFrame() {
        this.frameLocked = true;
    }

    public int getFirstRoll() {
        return this.firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return this.secondRoll;
    }

    public void setSecondRoll(int secondRoll, int indexOfSecondRoll) {
        if(!this.isFull && this.firstRoll > -1){
            if(this.firstRoll + secondRoll > 10){
                throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
            }
            this.secondRoll = secondRoll;
            if(this.firstRoll + secondRoll == 10){
                this.isSpare = true;
                this.indexOfSpareBonusRoll = indexOfSecondRoll+1;
            }
            this.isFull = true;
        }
    }

    public boolean isFull() {
        return this.isFull;
    }

    public int getBonusSparePoint() {
        return this.bonusSparePoint;
    }

    public void setBonusSparePoint(int bonusSparePoint) {
        if(this.isFull){
            this.bonusSparePoint = bonusSparePoint;
        }
    }

    public int getStrikeBonusFirstRoll() {
        return this.strikeBonusFirstRoll;
    }

    public void setStrikeBonusFirstRoll(int strikeBonusFirstRoll) {
        this.strikeBonusFirstRoll = strikeBonusFirstRoll;
    }

    public int getStrikeBonusSecondRoll() {
        return this.strikeBonusSecondRoll;
    }

    public void setStrikeBonusSecondRoll(int strikeBonusSecondRoll) {
        this.strikeBonusSecondRoll = strikeBonusSecondRoll;
    }

    public boolean isSpare() {
        return this.isSpare;
    }

    public int getIndexOfFirstRoll() {
        return this.indexOfFirstRoll;
    }

    public int[] getIndexeOfStrikeBonusRolls() {
        return this.indexeOfStrikeBonusRolls;
    }

    public int getIndexOfSpareBonusRoll() {
        return this.indexOfSpareBonusRoll;
    }
}
