import java.util.ArrayList;
import java.util.List;

class Flattener{

    List<Object> flattenedList = new ArrayList<>();

    public List<Object> flatten(List<Object> listToFlatten){
        flattenedList.clear();
        extractItems(listToFlatten);
        return flattenedList;
    }

    private void extractItems(List<Object> listToFlatten){
        for(Object o : listToFlatten) {
            if (o instanceof List) {
                extractItems((List<Object>) o);
            } else {
                if(o != null){
                    flattenedList.add(o);
                }
            }
        }
    }
}