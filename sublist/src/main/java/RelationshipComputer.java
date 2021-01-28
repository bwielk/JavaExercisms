import java.util.List;

class RelationshipComputer<T> {

    private List<T> comparedList = null;
    private List<T> comparingList = null;

    public Relationship computeRelationship(List<T> comparedList, List<T> comparingList){
        this.comparedList = comparedList;
        this.comparingList = comparingList;
        return Relationship.EQUAL;
    }

    private Relationship isEqual(){
        return Relationship.EQUAL;
    }

    private Relationship isSublist(){
        return Relationship.SUBLIST;
    }

    private Relationship isSuperlist(){
        return Relationship.SUPERLIST;
    }

    private Relationship isNotEqual() {
        return Relationship.UNEQUAL;
    }
}
