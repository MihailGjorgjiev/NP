package VtorKolokviumVezbi.FootballTable_29;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FootballTable {
    private Map<String,Team> teams;

    public FootballTable() {
        this.teams=new HashMap<>();
    }

    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals){
        teams.putIfAbsent(homeTeam,new Team(homeTeam));
        teams.putIfAbsent(awayTeam,new Team(awayTeam));

        int score = Integer.compare(homeGoals,awayGoals);
        teams.get(homeTeam).addGame(homeGoals,awayGoals,score);
        teams.get(awayTeam).addGame(awayGoals,homeGoals,-score);
    }

    public void printTable(){
        List<Team> orderedTeams = teams.values().stream()
                .sorted(Comparator.comparing(Team::getPoints, Comparator.reverseOrder())
                        .thenComparing(team -> team.getShotsGiven() - team.getShotsTaken(), Comparator.reverseOrder())
                        .thenComparing(Team::getName))
                .collect(Collectors.toList());

        IntStream.range(0,orderedTeams.size())
                .forEach(i->{
                    System.out.printf("%2d. " + orderedTeams.get(i) + "%n",i+1);
                });
    }
}
