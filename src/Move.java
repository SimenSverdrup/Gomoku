import static java.lang.Character.toUpperCase;

public class Move extends Board {

    public boolean checkEmpty(Character A, int b) {
        int a = map.get(toUpperCase(A)); //map from Board.class
        if(board[a][b]=='o'|| board[a][b]=='x') {
            System.out.printf("\nThis place is not empty. Please put the stone in other place\n");
            return false; //not empty
        }
        return true; //empty
    }

    public boolean withinBoard(Character A, int b) {
        int a = map.get(toUpperCase(A));
        if(a<1||a>15) {
            System.out.printf("\nThis place is not in the board input other place\n");
            return false;
        }
        else if(b<1||b>15) {
            System.out.printf("\nThis place is not in the board input other place\n");
            return false;
        }
        return true; //position is within board
    }

    public boolean legalMove(String position) {
        Character A;
        int b = 0;
        if (position.length() > 3 || position.length() < 2) {
            return false;
        }
        A = toUpperCase(position.charAt(0));
        switch (position.length()) {
            case 2:
                b = Character.getNumericValue(position.charAt(1));
            case 3:
                b = Integer.parseInt(position.substring(1));
        }
        if ((withinBoard(A, b) && checkEmpty(A, b))) {
            return true;
        }
        return false;
    }

    public boolean gameFinished(String position) {
        int b = 0;
        char a = toUpperCase(position.charAt(0));
        switch (position.length()) {
            case 2:
                b = Character.getNumericValue(position.charAt(1));
            case 3:
                b = Integer.parseInt(position.substring(1));
        }
        int num1=0;//세로 vertical
        int num2=0;//가로 horizontal
        int num3=0;//오른대각선 right
        int num4=0;//왼쪽대각선 left

        for(int i=1;i<5;i++) {
            if(board[a+i][b]!='o') {
                break;
            }
            else {
                num1++;
            }
        }
        for(int i=1;i<5;i++) {
            if(board[a-i][b]!='o') {
                break;
            }
            else {
                num1++;
            }
        } //num1 5개인지 검사
        for(int i=1;i<5;i++) {
            if(board[a][b+1]!='o') {
                break;
            }
            else {
                num2++;
            }
        }
        for(int i=1;i<5;i++) {
            if(board[a][b-i]!='o') {
                break;
            }
            else {
                num2++;
            }
        } //num2 5개인지 검사
        for(int i=1;i<5;i++) {
            if(board[a-i][b+i]!='o') {
                break;
            }
            else {
                num3++;
            }
        }
        for(int i=1;i<5;i++) {
            if(board[a+i][b-i]!='o') {
                break;
            }
            else {
                num3++;
            }
        } //num3 5개인지 검사
        for(int i=1;i<5;i++) {
            if(board[a-i][b-i]!='o') {
                break;
            }
            else {
                num4++;
            }
        }
        for(int i=1;i<5;i++) {
            if(board[a+i][b+i]!='o') {
                break;
            }
            else {
                num4++;
            }
        } //num4 5개인지 검사

        if(num1==4||num2==4||num3==4||num4==4) {
            System.out.printf("\nThe game is finished\n");
            return true;
        }
        else
            return false; //the game is not finished

    }

    /*public boolean threeAndThreeRule(Character A,int b) {
        int a = map.get(A);

    }*/
}
