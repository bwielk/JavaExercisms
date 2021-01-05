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
        //essentially creates the first frame
        if(frames.isEmpty()){
            Frame newFrame = new Frame(roll);
            frames.add(newFrame);
        }else{
            Frame alreadyExistingFrame = frames.get(frames.size()-1);
            //already existing frame is not full - set the second roll then
            if(!alreadyExistingFrame.isFull()){
                alreadyExistingFrame.setSecondRoll(roll);
                //check if the frame before the already existing frame is a strike which means it
                //gets a bonus of two next rolls
                if(frames.get(frames.size()-2) != null && frames.get(frames.size()-2).isStrike()){
                    frames.get(frames.size()-2).setBonusPoint(alreadyExistingFrame.getFirstRoll() +
                            alreadyExistingFrame.getSecondRoll());
                }
            //already existing frame is full
            }else{
                //total points is 10 but not strike
                if(alreadyExistingFrame.getFirstRoll() + alreadyExistingFrame.getSecondRoll() == 10 && !alreadyExistingFrame.isStrike()){
                    alreadyExistingFrame.setBonusPoint(roll);
                //total points is 10 and strike
                }else if(alreadyExistingFrame.isStrike()){
                    alreadyExistingFrame.setBonusPoint(alreadyExistingFrame.getBonusPoint()+roll);
                }
                //scenario when we either create a new frame or set the bonus for the already existing frame
                if(frames.size() <=10){
                    Frame newFrame = new Frame(roll);
                    frames.add(newFrame);
                }else{
                    alreadyExistingFrame.setBonusPoint(roll);
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