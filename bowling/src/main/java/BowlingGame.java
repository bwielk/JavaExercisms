import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int roll){
        rolls.add(roll);
    }

    public int score(){
        int result = 0;
        int increment = 0;
        for(int ballThrow = 0; ballThrow<rolls.size(); ballThrow+=increment){
            try{
                if( rolls.get(ballThrow) == 10){
                    result += 10 + rolls.get(ballThrow+1) + rolls.get(ballThrow+2);
                    increment=1;
                }else{
                    if( rolls.get(ballThrow) + rolls.get(ballThrow+1) == 10){
                        result += 10 + rolls.get(ballThrow+2);
                        increment=2;
                    }
                    if( rolls.get(ballThrow) + rolls.get(ballThrow+1) < 10){
                        result += rolls.get(ballThrow) + rolls.get(ballThrow+1);
                        increment=2;
                    }
                }

            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
}
