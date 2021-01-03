class Say {

    private String[] numberUnits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] numberTeens = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"};
    private String[] numberTens = new String[]{"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public String say(long number){
        StringBuffer sb = new StringBuffer();
        if(number < 10){
            sb.append(numberUnits[(int)number]);
        }
        return sb.toString();
    }

}