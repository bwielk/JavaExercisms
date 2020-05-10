import java.util.*;

class Knapsack {

    private Map<Integer, Item> mapOfItems = new HashMap<>();
    private List<Item> collectedItems = new ArrayList<>();
    Integer maxValue = 0;

    public int maximumValue(int weightLimit, List<Item> items){
        collectedItems.clear();
        items.forEach(x -> mapOfItems.put(x.getValue(), x));
        try{
            maxValue = Collections.max(mapOfItems.keySet());
            Item foundItem = mapOfItems.get(maxValue);
            if(foundItem.getWeight() <= weightLimit){
                collectedItems.add(foundItem);
            }
        }catch(NoSuchElementException e){}
        mapOfItems.clear();
        return collectedItems.size();
    }
}
