import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class BowlingGame {

    private List<Frame> frames = new ArrayList<>();
    private List<Integer> twoExtraThrows = new ArrayList<>();

    public void roll(int roll){
        Frame frameToProcess;
        if(roll < 0) {
            throw new IllegalStateException(ErrorMessages.NEGATIVE_ROLL_VALUE);
        }
        if(roll > 10){
            throw new IllegalStateException(ErrorMessages.TOO_MANY_PINS);
        }
        if((frames.size()>=1 && frames.size() <=10) || !frames.stream().allMatch(Frame::isCompleted)){
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
        }else if(frames.size()==0){
            frameToProcess = new Frame();
            frameToProcess.setFirstRoll(roll);
            frames.add(frameToProcess);
        }else{
            twoExtraThrows.add(roll);
        }
    }

    public int score(){
        int result = 0;

        for(int frame = 0; frame<frames.size(); frame++){
            if(frame<10) {
                try {
                    Frame currentFrame = frames.get(frame);
                    /**
                     * STRIKE
                     */
                    if (currentFrame.isStrike()) {
                        result += 10;
                        List<Integer> upcomingThrows = new ArrayList<>();
                        for (int nextFrame = frame + 1; nextFrame <= frame + 2; nextFrame++) {
                            try {
                                if (frames.get(nextFrame).isStrike()) {
                                    upcomingThrows.add(10);
                                } else {
                                    upcomingThrows.add(frames.get(nextFrame).getFirstRoll());
                                    upcomingThrows.add(frames.get(nextFrame).getSecondRoll());
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        result += upcomingThrows.get(0) + upcomingThrows.get(1);
                    } else {
                        if (currentFrame.getTotalRolls() == 10) {
                            /**
                             * SPARE
                             */
                            result += 10 + frames.get(frame + 1).getFirstRoll();
                        } else if (currentFrame.getTotalRolls() < 10) {
                            /**
                             * OPEN
                             */
                            result += currentFrame.getTotalRolls();
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Number of frames " + frames.size());
        if(frames.size() < 10){
            throw new IllegalStateException(ErrorMessages.TOO_EARLY_SCORING);
        }
        System.out.println(result);
        try{
            result += twoExtraThrows.stream().reduce(Integer::sum).get();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}