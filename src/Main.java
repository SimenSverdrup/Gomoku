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
                    ranking.displayScore();
                    String rankingChoice = "";
                    while ((rankingChoice !="r") || (rankingChoice !="m")) {
                        System.out.println("Reset score (r) or return to main menu (m): ");
                        rankingChoice = input.nextLine();
                    }
                    if (rankingChoice == "r") { ranking.resetScore(); } //we don't need to check for "m"
                case "q":
                    continue;
            }
        }
    }
}
