public enum Points {

    WIN(3),
    DRAW(1),
    LOSS(0);

    private Integer points;

    Points(Integer points){
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }
}
