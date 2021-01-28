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
        List<T> tempList;
        if(relationship==null){
            if(comparedList.isEmpty() && !comparingList.isEmpty()){
                relationship = Relationship.SUBLIST;
            }else{
                int sizeOfComparedList = comparedList.size();
                try{
                    for(int i=0; i<comparingList.size(); i++){
                        tempList = comparingList.subList(i, i+sizeOfComparedList);
                        if(tempList.equals(comparedList)){
                            relationship=Relationship.SUBLIST;
                            break;
                        }
                    }
                }catch (IndexOutOfBoundsException e){
                    e.getMessage();
                }
            }
        }
    }

    private void isSuperlist(){
        List<T> tempList;
        if(relationship==null){
            if(!comparedList.isEmpty() && comparingList.isEmpty()) {
                relationship = Relationship.SUPERLIST;
            }else{
                int sizeOfComparedList = comparingList.size();
                try{
                    for(int i=0; i<comparedList.size(); i++){
                        tempList = comparedList.subList(i, i+sizeOfComparedList);
                        if(tempList.equals(comparingList)){
                            relationship=Relationship.SUPERLIST;
                            break;
                        }
                    }
                }catch (IndexOutOfBoundsException e){
                    e.getMessage();
                }
            }
        }
    }

    private void isNotEqual() {
        if(!comparingList.equals(comparedList) && relationship==null){
            relationship = Relationship.UNEQUAL;
        }
    }
}
