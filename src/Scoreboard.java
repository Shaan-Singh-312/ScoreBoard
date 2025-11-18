public class Scoreboard {
    private String team1;
    private String team2;
    private String activeTeam;
    private int team1Score;
    private int team2Score;
    private boolean isTeam1 = true;


    public Scoreboard(String team1, String team2){
        this.team1 = team1;
        this.team2 = team2;
        activeTeam = this.team1;
    }

    public void recordPlay(int points){
        if(points == 0) isTeam1 = !isTeam1;
        if(isTeam1) team1Score += points;
        else team2Score += points;
    }

    public String getScore(){
        if (isTeam1) return team1Score + "-" + team2Score + "-" + team1;
        else return team1Score + "-" + team2Score + "-" + team2;
    }
}
