public class Queen {

    private int x;
    private int y;

    public Queen(int x, int y){
        if(x<0){
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
        else if(y<0){
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
        else if(x>7){
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }
        else if(y>7){
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }else{
            this.x=x;
            this.y=y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
