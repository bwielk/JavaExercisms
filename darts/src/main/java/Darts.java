class Darts {

    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double score = 0;
        double result = Math.sqrt((x*x) + (y*y));
        if(result>10){
            score = 0;
        }else if(result<=10 && result>5){
            score = 1;
        }else if(result<=5 && result >1){
            score = 5;
        }else if(result<=1){
            score = 10;
        }
        return (int) score;
    }
}
