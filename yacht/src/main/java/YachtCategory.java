enum YachtCategory {

    YACHT(50),
    ONES(1);
//    TWOS,
//    THREES,
//    FOURS,
//    FIVES,
//    SIXES,
//    FULL_HOUSE,
//    FOUR_OF_A_KIND,
//    LITTLE_STRAIGHT,
//    BIG_STRAIGHT,
//    CHOICE

    private Integer points;

    YachtCategory(Integer points){
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }
}
