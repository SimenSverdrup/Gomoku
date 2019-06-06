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

    public Singleplayer() { //constructor
        board = new Board();
        ranking = new Ranking();
        isGameFinished = false;
        counter = 1;
    }

    public void play() {
        String position;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your name: ");
        String playerName = input.nextLine();
        board.displayBoard();

        while (!isGameFinished) {
            move = new Move(board.board);
            System.out.println("\nChoose your move (e.g. 'B6'): "); //user starts
            position = input.nextLine();
            legalMove = move.legalMove(position);

            while (!legalMove) {
                System.out.println("Illegal move. Choose your move (e.g. 'B6'): "); //user starts
                position = input.nextLine();
                legalMove = move.legalMove(position);
            }
            board.insertRock(position, 'o');
            board.displayBoard();
            move = new Move(board.board);
            isGameFinished = move.gameFinished(position);
            if (isGameFinished) {
                System.out.printf("\n%s won!\n\n", playerName);
                ranking.appendScore(playerName, "AI", counter);
            }
            else {
                System.out.println("AI is thinking...\nAI plays:");
                try {TimeUnit.SECONDS.sleep(1);}
                catch (InterruptedException e){System.out.println("Sleeping error!"); }
                AI ai = new AI(board.board);
                position = ai.AIMove();
                board.insertRock(ai.AIMove(), 'x');
                board.displayBoard();
                isGameFinished = move.gameFinished(position);
                if (isGameFinished) {
                    System.out.printf("\nAI won!\n\n");
                    ranking.appendScore("AI", playerName, counter);
                }
            }
            counter++;
        }
    }
}
