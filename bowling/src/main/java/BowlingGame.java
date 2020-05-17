import java.util.ArrayList;
import java.util.List;

class BowlingGame {

    private List<Integer> rolls = new ArrayList<>();
    private List<Frame> frames = new ArrayList<>();

    public void roll(int roll){
        Frame frameToProcess;
        if(roll < 0) {
            throw new IllegalStateException(ErrorMessages.NEGATIVE_ROLL_VALUE);
        }
        if(roll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        if(frames.size()>=1){
            if(roll == 10) {
                frameToProcess = new Frame();
                frameToProcess.setFirstRoll(roll);
                frames.add(frameToProcess);
            }else {
                frameToProcess = frames.get(frames.size() - 1);
                if(!frameToProcess.isCompleted()) {
                    if (frameToProcess.getFirstRoll() > -1 && frameToProcess.getFirstRoll() < 10) {
                        if (roll + frameToProcess.getFirstRoll() > 10) {
                            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
                        } else if (roll + frameToProcess.getFirstRoll() <= 10) {
                            frameToProcess.setSecondRoll(roll);
                        }
                    }
                }else{
                    frameToProcess = new Frame();
                    frameToProcess.setFirstRoll(roll);
                    frames.add(frameToProcess);
                }
            }
        }else{
            frameToProcess = new Frame();
            frameToProcess.setFirstRoll(roll);
            frames.add(frameToProcess);
        }
    }

    public int score(){
        int result = 0;

        for(int ballThrow = 0; ballThrow<rolls.size(); ballThrow++){
            try{
                if( rolls.get(ballThrow) == 10){
                    result += 10 + rolls.get(ballThrow+1) + rolls.get(ballThrow+2);
                }else{
                    if( rolls.get(ballThrow) + rolls.get(ballThrow+1) == 10){
                        result += 10 + rolls.get(ballThrow+2);
                        ballThrow++;
                    }else if( rolls.get(ballThrow) + rolls.get(ballThrow+1) < 10) {
                        result += rolls.get(ballThrow) + rolls.get(ballThrow + 1);
                        ballThrow++;
                    }
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(frames);
        if(frames.size() < 10){
            throw new IllegalStateException(ErrorMessages.TOO_EARLY_SCORING);
        }
        System.out.println(result);
        return result;
    }
}