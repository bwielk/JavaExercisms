import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

class Tournament {

    private String tableHeader = "Team                           | MP |  W |  D |  L |  P\n";
    private String tableContent = "";
    private Map<String, Integer> pointsTable = new HashMap<>();
    private Map<String, Team> teams = new HashMap<>();

    public Tournament(){
        pointsTable.put("win", 3);
        pointsTable.put("draw", 1);
        pointsTable.put("loss", 0);
    }

    public String printTable(){
        for(String name : teams.keySet()){
            String teamName = StringUtils.capitalize(name.toLowerCase()) +
                    String.join("", Collections.nCopies(31-name.length(), " "));
            String matchesPlayed = String.valueOf(teams.get(name).getPlayedGames());
            String wins = String.valueOf(teams.get(name).getWins());
            String draws = String.valueOf(teams.get(name).getDraw());
            String losses = String.valueOf(teams.get(name).getLosses());
            String points = String.valueOf(
                    teams.get(name).getWins()*pointsTable.get("win")+
                    teams.get(name).getDraw()*pointsTable.get("draw")+
                    teams.get(name).getLosses()*pointsTable.get("loss")
            );
            tableContent += String.format("%s|  %s |  $s |  $s |  $s\n");
        }
        return tableHeader;
    }

    public void applyResults(String gamesPlayed){
        String[] splitGamesPlayed = gamesPlayed.split("\n");
        for(int game=0; game<splitGamesPlayed.length; game++){
            String[] splitGameData = splitGamesPlayed[game].split(";");
            if(splitGameData.length == 3){//check the amount of data is adequate
                String team1Name = splitGameData[0].toUpperCase();
                String team2Name = splitGameData[1].toUpperCase();
                String gameResult = splitGameData[2].toLowerCase();

                Team teamToUpdate1 = getTeam(team1Name);
                Team teamToUpdate2 = getTeam(team2Name);

                teamToUpdate1.setPlayedGames(teamToUpdate1.getPlayedGames()+1);
                teamToUpdate2.setPlayedGames(teamToUpdate2.getPlayedGames()+1);
                switch (gameResult) {
                    case "win":
                        teamToUpdate1.setWins(teamToUpdate1.getWins() + 1);
                        teamToUpdate2.setLosses(teamToUpdate2.getLosses() + 1);
                        break;
                    case "draw":
                        teamToUpdate1.setWins(teamToUpdate1.getDraw() + 1);
                        teamToUpdate2.setLosses(teamToUpdate2.getDraw() + 1);
                        break;
                    case "loss":
                        teamToUpdate1.setLosses(teamToUpdate1.getLosses() + 1);
                        teamToUpdate2.setWins(teamToUpdate2.getWins() + 1);
                        break;
                }
                teams.put(team1Name, teamToUpdate1);
                teams.put(team2Name, teamToUpdate2);
            }
        }
        StringUtils.capitalize("");
        System.out.println("");
    }

    private Team getTeam(String name){
        Team team;
        if(teams.keySet().contains(name.toUpperCase())){
            team = teams.get(name.toUpperCase());
        }else{
            team = new Team(name.toUpperCase());
        }
        return team;
    }
}
