public class Team {

    private String name =" ";
    private int  points =0;
    private int wins =0;

    public Team(String name){
        this.name = name;
    }

    public boolean play(int points){
        if (points >0) {
            this.points += points;
            return true;
        }
        return false;
    }

    public void addWins(){
        wins++;
    }

    public String getName(){
        return name;
    }

    public int getWins(){
        return wins;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String toString() {
        return "Name: " + name + " | Wins: " + wins;
    }
}
