import java.util.HashMap;

public class Board {
    private char[][] board = new char[15][15];
    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    private String alphabet = "ABCDEFGHIJKLMNO";

    public Board() { //constructor
        for (int i=0; i<15; i++) {
            for (int j=0; j<15; j++) {
                board[i][j] = ' ';
            }
        }

        for (int c=0; c<15; c++) { //mapping between characters and index
            map.put(alphabet.charAt(c), c);
        }

    }

    public void displayBoard() {
        System.out.print("\n   A B C D E F G H I J K L M N O\n");
        for (int i=0; i<15; i++) {
            System.out.printf("%d ", i+1);
            if (i<9) {System.out.print(" ");}
            for (int j=0; j<15; j++) {
                System.out.printf("%c ", board[i][j]);
                if (j == 14) { System.out.println(); }
            }
        }
    }

    public void insertRock(String pos) { //we check if the move is legal in multi/single-player
                                        //(by legalMove() in Move.class), not here
        int YPos;
        if (pos.length() == 2) {
            char YPosChar = pos.charAt(1);
            YPos = Character.getNumericValue(YPosChar);
        }
        else {//pos.length() == 3, check this in legalMove()
            String YPosString = pos.substring(1);
            YPos = Integer.parseInt(YPosString);
        }

        char XPosChar = pos.charAt(0);
        int XPos = map.get(XPosChar);

        board[YPos-1][XPos] = 'O';
    }
}
