import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int roll){
        rolls.add(roll);
    }

    public int score(){
        int result = 0;
        for(int ballThrow = 0; ballThrow<rolls.size(); ballThrow+=2){
            try{
                if( rolls.get(ballThrow) + rolls.get(ballThrow+1) == 10){
                    result += 10 + rolls.get(ballThrow+2);
                }
                if( rolls.get(ballThrow) + rolls.get(ballThrow+1) < 10){
                    result += rolls.get(ballThrow) + rolls.get(ballThrow+1);
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
