class Say {

    private String[] numberUnits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] numberTeens = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"};
    private String[] numberTens = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String hundred = "hundred";
    private String thousand = "thousand";
    private String million = "million";
    private String billion = "billion";
    private StringBuffer sb = new StringBuffer();

    public String say(long number){
        if(number < 0 || number >= 1_000_000_000_000L){
            throw new IllegalArgumentException();
        }
        if(number == 0){
            return "zero";
        }
        number = defineBillions(number);
        number = defineMillions(number);
        number = defineThouands(number);
        number = defineHundreds(number);
        number = defineTens(number);
        number = defineTeens(number);
        defineUnits(number);

        //clear string buffer pre return
        String returnValue = sb.toString();
        sb.delete(0, sb.length());
        return returnValue;
    }

    private long defineBillions(long number){
        if(number >= 1000000000){
            int amountOfBillions = (int)(number/1000000000);
            long amount = defineHundreds(amountOfBillions);
            amount = defineTens(amount);
            amount = defineTeens(amount);
            defineUnits(amount);
            sb.append(" ").append(billion);
            number -= number/1000000000*1000000000;
            if(number%1000000000 != 0){
                sb.append(" ");
            }
        }
        return number;
    }

    private long defineMillions(long number){
        if(number >= 100000 && number < 1000000000){
            int amountOfMillions = (int)(number/1000000);
            long amount = defineHundreds(amountOfMillions);
            amount = defineTens(amount);
            amount = defineTeens(amount);
            defineUnits(amount);
            sb.append(" ").append(million);
            number -= number/1000000*1000000;
            if(number%1000000 != 0){
                sb.append(" ");
            }
        }
        return number;
    }

    private long defineThouands(long number){
        if(number >= 1000 && number < 1000000){
            int amountOfThousands = (int)(number/1000);
            long amount = defineHundreds(amountOfThousands);
            amount = defineTens(amount);
            amount = defineTeens(amount);
            defineUnits(amount);
            sb.append(" ").append(thousand);
            number -= number/1000*1000;
            if(number%1000 != 0){
                sb.append(" ");
            }
        }
        return number;
    }


    private long defineHundreds(long number){
        if(number >= 100 && number < 1000) {
            sb.append(numberUnits[(int) number / 100] + " " + hundred);
            if (number % 100 != 0) {
                sb.append(" ");
            }
            number -= number/100*100;
        }
        return number;
    }

    private long defineTens(long number){
        if(number >= 20 && number < 100){
            sb.append(numberTens[(int)number/10]);
            if(number%10!=0){
            sb.append("-");
            }
            number-=number/10*10;
        }
        return number;
    }

    private long defineTeens(long number){
        if(number > 10 && number < 20) {
            sb.append(numberTeens[(int) number%10]);
            number -= number;
        }
        return number;
    }

    private long defineUnits(long number){
        if(number > 0 && number < 10) {
            sb.append(numberUnits[(int) number]);
            number -= number;
        }
        return number;
    }
}