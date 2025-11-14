import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String teams = "";
        Team[] teams_lst = new Team[7];
        int index = 0;
        while (s.hasNextLine()) {
            for (int i = 0; i < 2; i++) {
                String x = s.next();
                if (!teams.contains(x)) {
                    teams_lst[index] = new Team(x);
                    teams += x;
                    index++;
                }
            }
            s.nextLine();
        }
        //System.out.println(teams_lst[6]);
        s.close();
        s = new Scanner(f);

        while (s.hasNext()){
            Team a = findTeam(s.next(), teams_lst);
            Team b = findTeam(s.next(), teams_lst);
            a.setPoints(0);
            b.setPoints(0);
            int active_choice = 0;

            Team active = a;
            for (int i = 0; i< 1000; i++){
                if (!active.play(s.nextInt())){
                    active_choice ++;
                    if (active_choice %2 ==0) active = a;
                    else active = b;
                }
            }
            if (a.getPoints() > b.getPoints()) {
                a.addWins();
            }
            if (b.getPoints() > a.getPoints()) {
                b.addWins();
            }
        }
        for (Team team : teams_lst) {
            System.out.println(team);
        }

    }

    public static Team findTeam(String name, Team[] lst){
        for (Team team : lst) {
            if (team.getName().equals(name)) return team;
        }
        return null;
    }
}