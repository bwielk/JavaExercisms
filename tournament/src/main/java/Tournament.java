import java.util.HashMap;
import java.util.Map;

class Tournament {

    private String tableHeader = "Team                           | MP |  W |  D |  L |  P\n";
    private String tableContent = "";
    private Map<String, Integer> pointsTable = new HashMap<>();

    public Tournament(){
        pointsTable.put("win", 3);
        pointsTable.put("draw", 1);
        pointsTable.put("loss", 0);
    }

    public String printTable(){
        return tableHeader;
    }

    public String applyResults(String gamesPlayed){
        String[] splitGamesPlayed = gamesPlayed.split("\n");
        for(int game=0; game<splitGamesPlayed.length; game++){

        }
        return "";
    }
}
