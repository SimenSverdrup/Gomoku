import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AI extends Board {
    HashMap<Integer, Character> map = new HashMap<Integer, Character>();
    private String alphabet = "ABCDEFGHIJKLMNO";

    public AI(char[][] board) {
        this.board = board;
        for (int c=0; c<15; c++) { //mapping between characters and index
            map.put(c, alphabet.charAt(c));
        }
    }

    public String AIMove() {
        return "F5";
        /*
        Move move = new Move(board);
        String AImove;
        for (int i=0; i<15; i++) {
            for (int j=0; j<15; j++) {
                if(board[i][j] == 'x') {

                    if (move.legalMove(AImove)) {
                        return AImove;
                    }
                }
            }
        }
        while (!move.legalMove(AImove)) {
            Random rand = new Random();
            int r1 = rand.nextInt(15);
            int r2 = rand.nextInt(16);
            AImove = map.get(r1).toString() + r2;
        }
        return AImove;*/
    }
}