import java.util.*;
import java.util.stream.Collectors;

class Tournament {

    private String tableContent = "";
    private Map<String, Team> teams = new HashMap<>();

    public String printTable(){
        List<Team> teamsInformation = new ArrayList<>(teams.values());
        /**
         * Sort by points and then by name (alphabetically) - order:DESC
         */
        Collections.sort(teamsInformation, (t1, t2) ->
                (t1.getTotalPoints() != t2.getTotalPoints()) ? Integer.compare(t2.getTotalPoints(), t1.getTotalPoints())
                : t1.getTeamName().compareTo(t2.getTeamName()));

        /**
         * Iterate through the ordered list of teams and print the values
         */
        for(Team team : teamsInformation){
            /**
             * Capitalise every word in the list after having it entirely converted to lower case
             */
            String teamName = Arrays.stream(team.getTeamName()
                    .toLowerCase()
                    .split("\\s+"))
                    .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                    .collect(Collectors.joining(" ")) +
                    String.join("", Collections.nCopies(31-team.getTeamName().length(), " "));
            /**
             * Get values required for the table
             */
            String matchesPlayed = String.valueOf(team.getPlayedGames());
            String wins = String.valueOf(team.getWins());
            String draws = String.valueOf(team.getDraw());
            String losses = String.valueOf(team.getLosses());
            String points = String.valueOf(team.getTotalPoints());

            tableContent += String.format(TableFormatting.TABLE_ROW,
                    teamName, matchesPlayed, wins, draws, losses, points);
        }
        return TableFormatting.TABLE_HEADER + tableContent;
    }

    public void applyResults(String gamesPlayed){
        String[] splitGamesPlayed = gamesPlayed.split(ExpectedCSVFormatting.LINE_SPLIT);

        for(int game=0; game<splitGamesPlayed.length; game++){
            String[] splitGameData = splitGamesPlayed[game].split(ExpectedCSVFormatting.DELIMETER);
            if(splitGameData.length == 3){//check the amount of data is adequate
                String team1Name = splitGameData[0].toUpperCase();
                String team2Name = splitGameData[1].toUpperCase();
                String gameResult = splitGameData[2].toLowerCase();

                Team teamToUpdate1 = getTeam(team1Name);
                Team teamToUpdate2 = getTeam(team2Name);

                teamToUpdate1.setPlayedGames(teamToUpdate1.getPlayedGames()+1);
                teamToUpdate2.setPlayedGames(teamToUpdate2.getPlayedGames()+1);
                switch (gameResult) {
                    case GameStatuses.WIN:
                        teamToUpdate1.setWins(teamToUpdate1.getWins() + 1);
                        teamToUpdate1.setTotalPoints(teamToUpdate1.getTotalPoints() +
                                Points.WIN.getPoints());
                        teamToUpdate2.setLosses(teamToUpdate2.getLosses() + 1);
                        break;
                    case GameStatuses.DRAW:
                        teamToUpdate1.setDraw(teamToUpdate1.getDraw() + 1);
                        teamToUpdate1.setTotalPoints(teamToUpdate1.getTotalPoints() +
                                Points.DRAW.getPoints());
                        teamToUpdate2.setDraw(teamToUpdate2.getDraw() + 1);
                        teamToUpdate2.setTotalPoints(teamToUpdate2.getTotalPoints() +
                                Points.DRAW.getPoints());
                        break;
                    case GameStatuses.LOSS:
                        teamToUpdate1.setLosses(teamToUpdate1.getLosses() + 1);
                        teamToUpdate2.setWins(teamToUpdate2.getWins() + 1);
                        teamToUpdate2.setTotalPoints(teamToUpdate2.getTotalPoints() +
                                Points.WIN.getPoints());
                        break;
                }
                teams.put(team1Name, teamToUpdate1);
                teams.put(team2Name, teamToUpdate2);
            }
        }
    }

    private Team getTeam(String name){
        /**
         * To avoid case-sensitivity, all new Teams are created with upper-cased names
         */
        Team team;
        if(teams.keySet().contains(name.toUpperCase())){
            team = teams.get(name.toUpperCase());
        }else{
            team = new Team(name.toUpperCase());
        }
        return team;
    }
}
