import java.util.HashMap;

import static java.lang.Character.toUpperCase;

public class Board {
    public char[][] board = new char[15][15];
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
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
        System.out.print("\n  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15\n");

        for (int i=0; i<15; i++) {
            System.out.printf("%c ", alphabet.charAt(i));
            for (int j=0; j<15; j++) {
                if (j>9) { System.out.print(' '); }
                System.out.printf("%c ", board[i][j]);
                if (j == 14) { System.out.println(); }
            }
        }
    }

    public void insertRock(String pos, char rock) { //we check if the move is legal in multi/single-player
                                        //(by legalMove() in Move.class), not here
        int YPos, XPos;
        XPos = map.get(toUpperCase(pos.charAt(0)));
        if (pos.length() == 2) {
            YPos = Character.getNumericValue(pos.charAt(1));
        }
        else {//pos.length() == 3, check this in legalMove()
            YPos = Integer.parseInt(pos.substring(1));
        }

        board[XPos][YPos-1] = rock;
    }
}
