import java.util.List;

class QueenAttackCalculator {

    private Queen queen1;
    private Queen queen2;

    public QueenAttackCalculator(Queen queen1, Queen queen2){
        if(queen1==null || queen2==null){
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if(queen1.getY()==queen2.getY() && queen1.getX()==queen2.getX()){
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.queen1 = queen1;
        this.queen2 = queen2;
    }

    public boolean canQueensAttackOneAnother(){
        return queen1.getX() == queen2.getX() ||
            queen1.getY() == queen2.getY() ||
            Math.abs(queen1.getX()-queen2.getX()) == Math.abs(queen1.getY()-queen2.getY());
    }
}