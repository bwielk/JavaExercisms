import java.util.List;

class BinarySearch {

    private List<Integer> list;

    public BinarySearch(List<Integer> list){
        this.list = list;
    }

    public int indexOf(int numberToSearch){
        int foundNumber;
        int index = -1;
        int start = 0;
        int end = list.size()-1;
        int interval = end/2;
        while(index==-1){
            foundNumber = this.list.get(interval);
            if(foundNumber == numberToSearch){
                index = interval;
            }else{
                int value = list.get(interval);
                if(numberToSearch >= list.get(interval+1)){
                    start = interval+1;
                }else{
                    end = interval-1;
                }
            }
            interval=interval/2;
        }
        return index;
    }
}
