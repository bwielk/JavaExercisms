import java.util.stream.IntStream;

class NaturalNumber {

    private int number;

    public NaturalNumber(int number){
        if(number <=0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }else {
            this.number = number;
        }
    }

    public Classification getClassification(){
        Classification classification = null;
            int result = IntStream.range(1, number).filter(x -> number%x == 0).sum();
            if(result == this.number){
                classification = Classification.PERFECT;
            }else if(result > this.number){
                classification = Classification.ABUNDANT;
            }else if(result < this.number){
                classification = Classification.DEFICIENT;
            }
        return classification;
    }
}
