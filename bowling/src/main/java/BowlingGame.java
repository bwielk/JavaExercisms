import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();
    private List<Frame> frames = new ArrayList<>();
    private int startOfNewFrame = 0;


    public void roll(int roll){
        if(roll < 0){
            throw new IllegalStateException(ErrorMessages.NEGATIVE_ROLL_VALUE);
        }else if(roll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        if(roll < 10){
            if(frames.isEmpty()){
                Frame frame = new Frame(roll);
                frames.add(frame);
            }else{
                Frame previousFrame = frames.get(frames.size()-1);
                if(!previousFrame.isFull()){
                    previousFrame.setSecondRoll(roll);
                }else{
                    if(previousFrame.getFirstRoll() + previousFrame.getSecondRoll() == 10){
                        previousFrame.setBonusPoint(roll);
                    }
                    Frame frame = new Frame(roll);
                    frames.add(frame);
                }
            }
        }
        rolls.add(roll);
    }

    public int score(){
        int result = 0;
        for(int roll=0; roll<rolls.size(); roll++){
            try{if(rolls.get(roll) == 10){
                    if(roll == rolls.size()-3){
                        result+= rolls.get(roll) + rolls.get(roll+1) + rolls.get(roll+2);
                        roll+=2;
                    }else if(rolls.get(roll+1) + rolls.get(roll+2) < 10){
                        result+= rolls.get(roll) + 2*(rolls.get(roll+1) + rolls.get(roll+2));
                        roll+=2;
                    }else if(rolls.get(roll+1) == 10){
                        result+= rolls.get(roll) + rolls.get(roll+1) + rolls.get(roll+2);
                    }
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