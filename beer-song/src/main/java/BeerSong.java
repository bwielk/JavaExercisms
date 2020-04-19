class BeerSong{

    public String sing(Integer startingLine, Integer numberOfLinesToDisplay){
        String result = "";
        String basicLine = "%s bottles of beer on the wall, %s bottles of beer.\n" +
                "Take one down and pass it around, %s bottles of beer on the wall.\n\n";
        for(int i=startingLine; i>startingLine-numberOfLinesToDisplay; i--){
            result += String.format(basicLine, i, i, i-1);
        }
        return result;
    }

    public String singSong(){
        return "";
    }
}