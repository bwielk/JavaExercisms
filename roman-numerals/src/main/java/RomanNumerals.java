class RomanNumeral {

    int[]numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[]romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int number;

    public RomanNumeral(int number){
        this.number = number;
    }

    public String getRomanNumeral(){
        String result = "";
        while(this.number != 0){
            for(int i = 0; i<numbers.length; i++){
                int unitOccurence = this.number/numbers[i];
                if(numbers[i]<=this.number){
                    for(int x = 0; x<unitOccurence; x++){
                        result = result + romanNumerals[i];
                    }
                    this.number -= (numbers[i]*unitOccurence);
                }
            }
        }
        return result;
    }
}
