class ResistorColor {

    String[] colors = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        Integer result = null;
        for(int c=0; c<colors.length; c++){
            if(colors[c].equals(color.toLowerCase())){
                result = c;
            }
        }
        return result;
    }

    String[] colors() {
        return colors;
    }
}
