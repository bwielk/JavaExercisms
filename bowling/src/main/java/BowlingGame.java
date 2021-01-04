import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();
    boolean openFrame = false;
    boolean spare = false;
    boolean strike = false;
    boolean doubleStrike = false;


    public void roll(int roll){
        rolls.add(roll);
    }

    public int score(){
        int result = 0;
        for(int roll=0; roll<rolls.size(); roll++){
            try{if(rolls.get(roll) == 10){
                    result+= rolls.get(roll) + 2*(rolls.get(roll+1) + rolls.get(roll+2));
                    roll+=2;
                }else if(rolls.get(roll) + rolls.get(roll+1) < 10){
                    result+= rolls.get(roll)+rolls.get(roll+1);
                    roll++;
                }else if(rolls.get(roll) + rolls.get(roll+1) == 10){
                    result+= rolls.get(roll) + rolls.get(roll+1)+(rolls.get(roll+2));
                    roll++;
                }
            }catch (IndexOutOfBoundsException e){
                e.getMessage();
            }

        }
        return result;
    }
}