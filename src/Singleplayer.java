import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Character.toUpperCase;

public class Singleplayer {
    private Board board;
    private Move move;
    private Ranking ranking;
    private boolean isGameFinished;
    private boolean legalMove;
    private int counter;

    public Singleplayer() {
        board = new Board();
        move = new Move();
        ranking = new Ranking();
        isGameFinished = false;
        counter = 0;
    }

    public String AIMove() {
        //TO-DO
        String move = "F5";//something;
        return move;
    }

    public void play() {
        String position;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your name: ");
        String playerName = input.nextLine();
        board.displayBoard();

        while (!isGameFinished) {
            System.out.println("\nChoose your move: "); //user starts
            position = input.nextLine();
            legalMove = move.legalMove(position);

            while (!legalMove) {
                System.out.println("Illegal move. Choose your move: "); //user starts
                position = input.nextLine();
                legalMove = move.legalMove(position);
            }
            board.insertRock(position, 'o');
            board.displayBoard();
            isGameFinished = move.gameFinished(A, b);
            if (isGameFinished) {
                System.out.printf("\n%s won!\n", playerName);
                ranking.appendScore(playerName, "AI", counter);
            }
            else {
                System.out.println("AI is thinking...\nAI plays:");
                try {TimeUnit.SECONDS.sleep(1);}
                catch (InterruptedException e){System.out.println("Sleeping error!"); }
                board.insertRock(AIMove(), 'x');
                board.displayBoard();
                isGameFinished = move.gameFinished(A, b);
                if (isGameFinished) {
                    System.out.printf("\nAI won!\n");
                    ranking.appendScore("AI", playerName, counter);
                }
            }
            counter++;
        //TODO: initialize A and b
        }
    }
}
