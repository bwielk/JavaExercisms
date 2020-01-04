enum YachtCategory {

    YACHT(50),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6);
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
