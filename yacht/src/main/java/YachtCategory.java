enum YachtCategory {

    YACHT(50),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    FULL_HOUSE(null),
    FOUR_OF_A_KIND(null),
    LITTLE_STRAIGHT(30),
    BIG_STRAIGHT(30),
    CHOICE(null);

    private Integer points;

    YachtCategory(Integer points){
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }
}
