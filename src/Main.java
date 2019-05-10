import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        while (!userChoice.equals("q")) {
            System.out.println("*******************\nWelcome to GOMOKU!\n*******************");
            while (!(userChoice.equals("s") || userChoice.equals("m") || userChoice.equals("r") || userChoice.equals("q"))) {
                System.out.println("Please choose Singleplayer (s), Multiplayer (m), Ranking (r) or Quit (q): ");
                userChoice = input.nextLine();
            }

            switch (userChoice) {
                case "s":
                    Singleplayer single = new Singleplayer();
                    single.play();
                case "m":
                    Multiplayer multi = new Multiplayer();
                    multi.play();
                case "r":
                    Ranking ranking = new Ranking();
                    ranking.seeRanking();
                case "q":
                    continue;
            }
        }
    }
}
