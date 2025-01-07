package VtorKolokviumVezbi.FootballTable_29;

public class Team {
    private String name;
    private int numCompetitions;
    private int wins;
    private int ties;
    private int losses;
    private int shotsGiven;
    private int shotsTaken;

    public Team(String name) {
        this.name = name;

        this.numCompetitions = 0;
        this.wins = 0;
        this.ties = 0;
        this.losses = 0;
        this.shotsGiven = 0;
        this.shotsTaken=0;
    }

    public void addGame(int goodPoints,int badPoints , int result) {
        this.numCompetitions++;
        this.shotsGiven += goodPoints;
        this.shotsTaken+=badPoints;

        if (result == -1) {
            this.losses++;
        } else if (result == 0) {
            this.ties++;
        } else {
            this.wins++;
        }
    }

    public String getName() {
        return name;
    }

    public int getShotsTaken() {
        return shotsTaken;
    }

    public int getNumCompetitions() {
        return numCompetitions;
    }

    public int getWins() {
        return wins;
    }

    public int getTies() {
        return ties;
    }

    public int getLosses() {
        return losses;
    }

    public int getShotsGiven() {
        return shotsGiven;
    }
    public int getPoints(){
        return wins*3+ties;
    }

    @Override
    public String toString() {
        return String.format("%-15s%5d%5d%5d%5d%5d",name,numCompetitions,wins,ties,losses,getPoints());
    }
}
