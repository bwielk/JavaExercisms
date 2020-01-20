class ResistorColorDuo {
    int value(String[] colors) {
        String result = "";
            for(int i = 0; i<colors.length; i++) {
                if(result.length() < 2){
                    switch (colors[i].toLowerCase()) {
                        case "black":
                            result += String.valueOf(ColorValues.BLACK.getValue());
                            break;
                        case "brown":
                            result += String.valueOf(ColorValues.BROWM.getValue());
                            break;
                        case "red":
                            result += String.valueOf(ColorValues.RED.getValue());
                            break;
                        case "orange":
                            result += String.valueOf(ColorValues.ORANGE.getValue());
                            break;
                        case "yellow":
                            result += String.valueOf(ColorValues.YELLOW.getValue());
                            break;
                        case "green":
                            result += String.valueOf(ColorValues.GREEN.getValue());
                            break;
                        case "blue":
                            result += String.valueOf(ColorValues.BLUE.getValue());
                            break;
                        case "violet":
                            result += String.valueOf(ColorValues.VIOLET.getValue());
                            break;
                        case "grey":
                            result += String.valueOf(ColorValues.GREY.getValue());
                            break;
                        case "white":
                            result += String.valueOf(ColorValues.WHITE.getValue());
                            break;
                    }
                }
            }
        return Integer.parseInt(result);
    }
}

enum ColorValues{

    BLACK(0),
    BROWM(1),
    RED(2),
    ORANGE(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6),
    VIOLET(7),
    GREY(8),
    WHITE(9);

    private int value;

    ColorValues(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
