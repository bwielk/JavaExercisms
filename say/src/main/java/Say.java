class Say {

    private String[] numberUnits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] numberTeens = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"};
    private String[] numberTens = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String say(long number){
        StringBuffer sb = new StringBuffer();
        if(number == 0){
            return "zero";
        }
        if(number < 100 && number >= 20){
            sb.append(numberTens[(int)number/10]);
            number -= number/10*10;
            if(number%10 != 0){
                sb.append("-");
            }
        }
        if(number < 20 && number > 10){
            sb.append(numberTeens[(int)number-10]);
            number -= number;
        }
        if(number < 10 && number > 0){
            sb.append(numberUnits[(int)number]);
        }
        return sb.toString();
    }

}