import java.util.List;

class RelationshipComputer<T> {

    private List<T> comparedList = null;
    private List<T> comparingList = null;
    private Relationship relationship;

    public Relationship computeRelationship(List<T> comparedList, List<T> comparingList){
        this.comparedList = comparedList;
        this.comparingList = comparingList;
        isEqual();
        isSublist();
        isSuperlist();
        isNotEqual();
        return relationship;
    }

    private void isEqual(){
        if(this.comparedList.equals(this.comparingList) && relationship==null){
            relationship = Relationship.EQUAL;
        }
    }

    private void isSublist(){
        if(relationship==null){
            if((comparedList.isEmpty() && !comparingList.isEmpty()) ||
                    compareSublistWithList(comparedList, comparingList)){
                relationship = Relationship.SUBLIST;
            }
        }
    }

    private void isSuperlist(){
        if(relationship==null){
            if((!comparedList.isEmpty() && comparingList.isEmpty()) ||
                    compareSublistWithList(comparingList, comparedList)) {
                relationship = Relationship.SUPERLIST;
            }
        }
    }

    private void isNotEqual() {
        if(!comparingList.equals(comparedList) && relationship==null){
            relationship = Relationship.UNEQUAL;
        }
    }

    private boolean compareSublistWithList(List<T> listBeingCompared, List<T> listToBeComparedWith){
        List<T> tempList;
        int sizeOfComparedList = listBeingCompared.size();
        try{
            for(int i=0; i<listToBeComparedWith.size(); i++){
                tempList = listToBeComparedWith.subList(i, i+sizeOfComparedList);
                if(tempList.equals(listBeingCompared)){
                    return true;
                }
            }
        }catch (IndexOutOfBoundsException e){
            e.getMessage();
        }
        return false;
    }
}
