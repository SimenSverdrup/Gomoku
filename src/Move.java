public class Move extends Board {

    public boolean checkEmpty(Character A, int b) {
        int a = map.get(A); //map from Board.class
        if(board[a][b]=='o'|| board[a][b]=='x') {
            System.out.printf("\nThis place is not empty. Please put the stone in other place\n");
            return false; //not empty
        }
        return true; //empty
    }

    public boolean withinBoard(Character A, int b) {
        int a = map.get(A);
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

    public boolean gameFinished(Character A, int b) {

        int a = map.get(A);
        int num1=0;//세로 vertical
        int num2=0;//가로 horizontal
        int num3=0;//오른대각선 right
        int num4=0;//왼쪽대각선 left

        for(int i=1;i<6;i++) {
            if(board[a+i][b]!='o') {
                break;
            }
            else {
                num1++;
            }
        }
        for(int i=1;i<6;i++) {
            if(board[a-i][b]!='o') {
                break;
            }
            else {
                num1++;
            }
        } //num1 5개인지 검사
        for(int i=1;i<6;i++) {
            if(board[a][b+1]!='o') {
                break;
            }
            else {
                num2++;
            }
        }
        for(int i=1;i<6;i++) {
            if(board[a][b-i]!='o') {
                break;
            }
            else {
                num2++;
            }
        } //num2 5개인지 검사
        for(int i=1;i<6;i++) {
            if(board[a-i][b+i]!='o') {
                break;
            }
            else {
                num3++;
            }
        }
        for(int i=1;i<6;i++) {
            if(board[a+i][b-i]!='o') {
                break;
            }
            else {
                num3++;
            }
        } //num3 5개인지 검사
        for(int i=1;i<6;i++) {
            if(board[a-i][b-i]!='o') {
                break;
            }
            else {
                num4++;
            }
        }
        for(int i=1;i<6;i++) {
            if(board[a+i][b+i]!='o') {
                break;
            }
            else {
                num4++;
            }
        } //num4 5개인지 검사

        if(num1==5||num2==5||num3==5||num4==5) {
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
