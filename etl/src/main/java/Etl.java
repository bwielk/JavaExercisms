import java.util.*;

class Etl {

    private Map<String, Integer> newMapToPopulate;

    public Etl(){
        newMapToPopulate = new HashMap<>();
    }

    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        for(Integer k : old.keySet()){
            for(String el : old.get(k)){
                newMapToPopulate.put(el.toLowerCase(), k);
            }
        }
        return newMapToPopulate;
    }
}
