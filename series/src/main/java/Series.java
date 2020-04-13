import java.util.ArrayList;
import java.util.List;

class Series {

    private String wordToSlice;

    public Series(String wordtoSlice){
        this.wordToSlice = wordtoSlice;
    }

    public List<String> slices(Integer sliceLength){
        if(sliceLength <= 0){
            throw new IllegalArgumentException("Slice size is too small.");
        }
        if(sliceLength > wordToSlice.length()){
            throw new IllegalArgumentException("Slice size is too big.");
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i<wordToSlice.length(); i++){
            if(i+sliceLength<= wordToSlice.length()){
                result.add(wordToSlice.substring(i, i+sliceLength));
            }
        }
        return result;
    }
}
