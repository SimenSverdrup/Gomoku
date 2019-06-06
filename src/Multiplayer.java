
import java.util.Scanner;

public class Multiplayer {
    private Board board;
    private Move move;
    private Ranking ranking;
    private boolean isGameFinished;
    private boolean legalMove;
    private int counter;

    public Multiplayer() { //constructor
        board = new Board();
        ranking = new Ranking();
        isGameFinished = false;
        counter = 1;
    }


    public void play() {
        String position;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your name(Player1): ");
        String playerName1 = input.nextLine();
        System.out.println("Please input your name(Player2): ");
        String playerName2 = input.nextLine();
        board.displayBoard();

        while (!isGameFinished) {
        	if(counter%2 == 1) {
	            move = new Move(board.board);
	            System.out.printf("\n%s Choose your move (e.g. 'B6'): \n",playerName1); //user starts
	            position = input.nextLine();
	            legalMove = move.legalMove(position);
	
	            while (!legalMove) {
	                System.out.println("Illegal move. Choose your move (e.g. 'B6'): "); //user starts
	                position = input.nextLine();
	                legalMove = move.legalMove(position);
	            }
	            board.insertRock(position, 'o');
	            board.displayBoard();
	            isGameFinished = move.gameFinished(position);
	            if (isGameFinished) {
	                System.out.printf("\n%s won!\n\n", playerName1);
	                ranking.appendScore(playerName1, playerName2, counter);
	            }
        	}
        	else {
        		move = new Move(board.board);
 	            System.out.printf("\n%s Choose your move (e.g. 'B6'): \n",playerName2); //user starts
 	            position = input.nextLine();
 	            legalMove = move.legalMove(position);
 	
 	            while (!legalMove) {
 	                System.out.println("Illegal move. Choose your move (e.g. 'B6'): "); //user starts
 	                position = input.nextLine();
 	                legalMove = move.legalMove(position);
 	            }
 	            board.insertRock(position, 'x');
 	            board.displayBoard();
 	            isGameFinished = move.gameFinished(position);
 	            if (isGameFinished) {
 	                System.out.printf("\n%s won!\n\n", playerName2);
 	                ranking.appendScore(playerName2, playerName1, counter);
 	            }
        	}
            counter++;
        }
    }
}
