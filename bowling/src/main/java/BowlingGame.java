import java.util.ArrayList;
import java.util.List;

class BowlingGame {

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

        for(int frame = 0; frame<frames.size(); frame++){
            try{
                if(frames.get(frame).isStrike()){
                    result += 10 + frames.get(frame+1).getTotalRolls();
                }else{
                    if( frames.get(frame).getTotalRolls() == 10){
                        result += 10 + frames.get(frame+1).getFirstRoll();
                    }else if( frames.get(frame).getTotalRolls()< 10) {
                        result += frames.get(frame).getTotalRolls();
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