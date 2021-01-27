import java.util.List;

class BinarySearch {

    private List<Integer> list;

    public BinarySearch(List<Integer> list){
        this.list = list;
    }

    public int indexOf(int numberToSearch) throws ValueNotFoundException {
        int foundNumber;
        int index = -1;
        int start = 0;
        int end = list.size()-1;
        int midPoint = end/2;
        // searchableIntervalLength - defines the possible searchable span; if the span is 0, it means that
        // the program has run out of the potential width of the search scope
        int searchableIntervalLength = list.size();
        while(index==-1 && searchableIntervalLength > 0){
            foundNumber = this.list.get(midPoint);
            if(foundNumber == numberToSearch){
                index = midPoint;
            }else{
                try{
                    if(numberToSearch >= list.get(midPoint+1)){
                        start = midPoint+1;
                        midPoint = (end+start)/2;
                    }else{
                        end = midPoint-1;
                        midPoint = end/2;
                    }
                }catch (IndexOutOfBoundsException e){
                    //given there is an attempt to search for a number out of the potential boundary,
                    //if that happens, we define the searchableIntervalLength variable to 0 which automatically
                    //breaks the while loop
                    searchableIntervalLength=0;
                }
            }
            //after every run of the code above, the search scope is halved
            searchableIntervalLength=searchableIntervalLength/2;
        }
        if(index<0){
            throw new ValueNotFoundException("Value not in array");
        }else{
            return index;
        }
    }
}
