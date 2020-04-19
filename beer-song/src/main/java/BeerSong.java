class BeerSong{

    public String sing(Integer startingLine, Integer numberOfLinesToDisplay){
        String result = "";
        String basicLine = "%s bottles of beer on the wall, %s bottles of beer.\n" +
                "Take one down and pass it around, %s bottles of beer on the wall.\n\n";
        for(int i=startingLine; i>startingLine-numberOfLinesToDisplay; i--){
            if(i-1 > 1){
                result += String.format(basicLine, i, i, i-1);
            }else if(i-1==1){
                result += String.format("%s bottles of beer on the wall, %s bottles of beer.\n" +
                        "Take one down and pass it around, %s bottle of beer on the wall.\n\n", i, i, i-1);
            }else if(i-1==0){
                result += String.format("%s bottle of beer on the wall, %s bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n\n", i, i);
            }else{
                result += "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
            }
        }
        return result;
    }

    public String singSong(){
        return sing(99, 100);
    }
}