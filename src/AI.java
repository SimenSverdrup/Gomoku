import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Character.toUpperCase;

public class AI extends Board {
    HashMap<Integer, Character> map = new HashMap<Integer, Character>();
    private String alphabet = "ABCDEFGHIJKLMNO";
    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

    int[][] valueBoard;

    public AI(char[][] board) {
        valueBoard = new int[15][15];
        this.board = board;
        for (int c=0; c<15; c++) { //mapping between characters and index
            map.put(c, alphabet.charAt(c));
        }
        for (int c=0; c<15; c++) { //mapping between characters and index
            map2.put(alphabet.charAt(c), c);
        }
    }

    public String AIMove(String position) {
        int num1;//세로 vertical
        int num2;//가로 horizontal
        int num3;//오른대각선 diagonal1
        int num4;//왼쪽대각선 diagonal2
        int b = 0;
        int a = map2.get(toUpperCase(position.charAt(0)));
        switch (position.length()) {
            case 2:
                b = Character.getNumericValue(position.charAt(1));
            case 3:
                b = Integer.parseInt(position.substring(1));
        }
        b--; //because of 0-indexing

        for (int index1=0; index1<15; index1++) {
            for (int j=0; j<15; j++) {
                if(board[index1][j] == ' ') {
                    num1 = 0;//세로 vertical
                    num2 = 0;//가로 horizontal
                    num3 = 0;//오른대각선 diagonal1
                    num4 = 0;//왼쪽대각선 diagonal2

                    for(int i=1; i<Math.min(15-a,5); i++) {
                        if(board[a+i][b] != board[a][b]) {
                            break;
                        }
                        else {
                            num1++;
                        }
                    }
                    for(int i=1; i<Math.min(a+1, 5); i++) {
                        if(board[a-i][b] != board[a][b]) {
                            break;
                        }
                        else {
                            num1++;
                        }
                    } //num1 5개인지 검사
                    for(int i=1; i<Math.min(15-b,5); i++) {
                        if(board[a][b+i] != board[a][b]) {
                            break;
                        }
                        else {
                            num2++;
                        }
                    }
                    for(int i=1; i<Math.min(b+1,5); i++) {
                        if(board[a][b-i] != board[a][b]) {
                            break;
                        }
                        else {
                            num2++;
                        }
                    } //num2 5개인지 검사
                    for(int i=1; i<Math.min(Math.min(a+1, 5), 15-b); i++) {
                        if(board[a-i][b+i] != board[a][b]) {
                            break;
                        }
                        else {
                            num3++;
                        }
                    }
                    for(int i=1; i<Math.min(Math.min(5, b+1), 15-a) ;i++) {
                        if(board[a+i][b-i] != board[a][b]) {
                            break;
                        }
                        else {
                            num3++;
                        }
                    } //num3 5개인지 검사
                    for(int i=1; i<Math.min(Math.min(5, a+1), b+1); i++) {
                        if(board[a-i][b-i] != board[a][b]) {
                            break;
                        }
                        else {
                            num4++;
                        }
                    }
                    for(int i=1;i<Math.min(Math.min(5, 15-a), 15-b);i++) {
                        if(board[a+i][b+i]!=board[a][b]) {
                            break;
                        }
                        else {
                            num4++;
                        }
                    } //num4 5개인지 검사


                }
                else {
                    valueBoard[index1][j] = 0;
                }
            }
        }


/*
        Move move = new Move(board);
        Random rand = new Random();
        String AImove = "";

        while (!move.legalMove(AImove)) {
            int r1 = rand.nextInt(15);
            int r2 = rand.nextInt(16);
            AImove = map.get(r1).toString() + r2;
        }
        return AImove;*/
    }
}