import com.sun.istack.internal.NotNull;

public class RailCipherCoords {

    private int x;
    private int y;

    public RailCipherCoords(@NotNull int x, @NotNull int y) {
        this.x = x;
        this.y = y;
    }

    public RailCipherCoords(){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
