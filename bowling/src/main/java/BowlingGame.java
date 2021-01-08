import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();
    private List<Frame> frames = new ArrayList<>();
    private int startOfNewFrame = 0;


    public void roll(int roll){
        rolls.add(roll);
        int indexOfCurrentRoll = rolls.size()-1;
        if(roll < 0){
            throw new IllegalStateException(ErrorMessages.NEGATIVE_ROLL_VALUE);
        }else if(roll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        //essentially creates the first frame
        if(frames.isEmpty()){
            Frame newFrame = new Frame(roll, indexOfCurrentRoll);
            frames.add(newFrame);
        }else{
            Frame alreadyExistingFrame = frames.get(frames.size()-1);
            //already existing frame is not full - set the second roll then
            if(!alreadyExistingFrame.isFull()){
                alreadyExistingFrame.setSecondRoll(roll, indexOfCurrentRoll);
            //already existing frame is full
            }else{
                if(frames.size() <=10) {
                    Frame newFrame = new Frame(roll, indexOfCurrentRoll);
                    frames.add(newFrame);
                }
            }
        }
        //deal with bonuses across all previous frames
        for(Frame f : frames){
            if(f.isStrike() && IntStream.of(f.getIndexeOfStrikeBonusRolls()).anyMatch(x -> x == indexOfCurrentRoll)){
                List<Integer> list = Arrays.stream(f.getIndexeOfStrikeBonusRolls()).boxed().collect(Collectors.toList());
                if(list.indexOf(indexOfCurrentRoll) == 0){
                    f.setStrikeBonusFirstRoll(roll);
                }else{
                    f.setStrikeBonusSecondRoll(roll);
                }
            }else if(f.isSpare() && f.getIndexOfSpareBonusRoll() == indexOfCurrentRoll){
                f.setBonusSparePoint(roll);
            }
        }
    }

    public int score(){
        int result=0;
        for(Frame f : frames){
            result += f.getFirstRoll();
            result += f.getSecondRoll();
            result += f.getStrikeBonusFirstRoll();
            result += f.getStrikeBonusSecondRoll();
            result += f.getBonusSparePoint();
        }
        return result;
    }
}