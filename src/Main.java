import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";

        while (!userChoice.equals("q")) {
            userChoice = "";
            System.out.println("********************\n Welcome to GOMOKU!\n********************");
            while (!(userChoice.equals("s") || userChoice.equals("m") || userChoice.equals("r") || userChoice.equals("q"))) {
                System.out.println("\nPlease choose Singleplayer (s), Multiplayer (m), Ranking (r) or Quit (q): ");
                userChoice = input.nextLine().toLowerCase();
            }

            switch (userChoice) {
                case "s":
                    Singleplayer single = new Singleplayer();
                    //single.play();
                    break;
                case "m":
                    Multiplayer multi = new Multiplayer();
                    //multi.play();
                    break;
                case "r":
                    Ranking ranking = new Ranking();
                    ranking.displayScore();
                    String rankingChoice = "";
                    while (!rankingChoice.equals("m")) {
                        System.out.println("Reset score (r) or return to main menu (m): ");
                        rankingChoice = input.nextLine().toLowerCase();
                        if (rankingChoice.equals("r")) { ranking.resetScore(); }
                    }
                    break;
            }
        }
    }
}
