import java.util.HashMap;
import java.util.Random;

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

    public String AIMove() {
        int max;
        int Ypos;
        int Xpos;

        for (int a=0; a<15; a++) {
            for (int b=0; b<15; b++) {
                if(board[a][b] == ' ') {
                    int num = 0;
                    int numcon = 1;
                    int numrock1=0;
                    int numrock2=0;
                    int numspace1=0;
                    int numspace2=0;
                    int value=0;
                    int row=1;

                    board[a][b]='o';//////////////////////////////////////////////////
                    if(row==1) {
                        for(int i=1; i<Math.min(15-a,5); i++) {
                            if(board[a+i-1][b]=='o') {
                                if(board[a+i][b]=='o') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b]=='x') {
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a+i][b]=='o') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b]=='x') {
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        /////////////////////////part1 for row1

                        for(int i=1; i<Math.min(a+1, 5); i++) {
                            if(board[a-i+1][b]=='o') {
                                if(board[a-i][b]=='o') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b]=='x') {
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;

                                }
                            }
                            else {
                                if(board[a-i][b]=='o') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b]=='x') {
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;

                    num = 0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ////////////////////////////////row1 finished///////////////////////////////////////

                    if(row==2) {
                        for(int i=1; i<Math.min(15-b,5); i++) {
                            if(board[a][b+i-1]=='o') {
                                if(board[a][b+i] == 'o') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a][b+i]=='x'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a][b+i] == 'o') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a][b+i]=='x'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        ///////////////part1 row2

                        for(int i=1; i<Math.min(b+1,5); i++) {
                            if(board[a][b-i+1]=='o') {
                                if(board[a][b-i] =='o') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a][b-i]=='x'){
                                    if(numspace2==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                            else {
                                if(board[a][b-i] =='o') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a][b-i]=='x'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }

                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;
                    num = 0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ////////////////////////////row2/////////////////////////////////////////////

                    if(row==3) {
                        for(int i=1; i<Math.min(Math.min(a+1, 5), 15-b); i++) {
                            if(board[a-i+1][b+i-1]=='o') {
                                if(board[a-i][b+i] == 'o') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b+i]=='x'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a-i][b+i] == 'o') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b+i]=='x'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;

                        /////////////////////row3 part1/////////////////////////////////

                        for(int i=1; i<Math.min(Math.min(5, b+1), 15-a) ;i++) {
                            if(board[a+i-1][b-i+1]=='o') {
                                if(board[a+i][b-i] == 'o') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b-i] == 'x'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;
                                }
                            }
                            else {
                                if(board[a+i][b-i] == 'o') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b-i] == 'x'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;
                    num=0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ///////////////////////////row3////////////////////////////////////////

                    if(row==4){
                        for(int i=1; i<Math.min(Math.min(5, a+1), b+1); i++) {
                            if(board[a-i+1][b-i+1]=='o') {
                                if(board[a-i][b-i] == 'o') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b-i] == 'x'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a-i][b-i] == 'o') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b-i] == 'x'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        ///////////////////////row4 part1/////////////////////////////

                        for(int i=1;i<Math.min(Math.min(5, 15-a), 15-b);i++) {
                            if(board[a+i-1][b+i-1]=='o') {
                                if(board[a+i][b+i]=='o') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b+i]=='x'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;
                                }
                            }
                            else {
                                if(board[a+i][b+i]=='o') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b+i]=='x'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;
                    num=0;
                    row=1;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ////////////////row4 finished///////////////////////////////////

                    board[a][b]='x';
                    if(row==1) {
                        for(int i=1; i<Math.min(15-a,5); i++) {
                            if(board[a+i-1][b]=='x') {
                                if(board[a+i][b]=='x') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b]=='o') {
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a+i][b]=='x') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b]=='o') {
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        /////////////////////////part1 for row1///////////////////////

                        for(int i=1; i<Math.min(a+1, 5); i++) {
                            if(board[a-i+1][b]=='x') {
                                if(board[a-i][b]=='x') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b]=='o') {
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;

                                }
                            }
                            else {
                                if(board[a-i][b]=='x') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b]=='o') {
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;

                    num = 0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ////////////////////////////////row1 finished///////////////////////////////////////

                    if(row==2) {
                        for(int i=1; i<Math.min(15-b,5); i++) {
                            if(board[a][b+i-1]=='x') {
                                if(board[a][b+i] == 'x') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a][b+i]=='o'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a][b+i] == 'x') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a][b+i]=='o'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        ///////////////part1 row2

                        for(int i=1; i<Math.min(b+1,5); i++) {
                            if(board[a][b-i+1]=='x') {
                                if(board[a][b-i] =='x') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a][b-i]=='o'){
                                    if(numspace2==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                            else {
                                if(board[a][b-i] =='x') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a][b-i]=='o'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }

                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;
                    num = 0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ////////////////////////////row2/////////////////////////////////////////////

                    if(row==3) {
                        for(int i=1; i<Math.min(Math.min(a+1, 5), 15-b); i++) {
                            if(board[a-i+1][b+i-1]=='x') {
                                if(board[a-i][b+i] == 'x') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b+i]=='o'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a-i][b+i] == 'x') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b+i]=='o'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;

                        /////////////////////row3 part1/////////////////////////////////

                        for(int i=1; i<Math.min(Math.min(5, b+1), 15-a) ;i++) {
                            if(board[a+i-1][b-i+1]=='x') {
                                if(board[a+i][b-i] == 'x') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b-i] == 'o'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;
                                }
                            }
                            else {
                                if(board[a+i][b-i] == 'x') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b-i] == 'o'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }
                    if(numcon==5) {
                        row=5;
                    }
                    else {
                        row++;
                    }
                    value+=num;
                    num=0;
                    numcon = 1;
                    numrock1=0;
                    numrock2=0;
                    numspace1=0;
                    numspace2=0;
                    ///////////////////////////row3////////////////////////////////////////

                    if(row==4){
                        for(int i=1; i<Math.min(Math.min(5, a+1), b+1); i++) {
                            if(board[a-i+1][b-i+1]=='x') {
                                if(board[a-i][b-i] == 'x') {
                                    numcon++;
                                    numrock1++;
                                    num+=2*(5-i);
                                }
                                else if(board[a-i][b-i] == 'o'){
                                    if(numspace1==0) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                            else {
                                if(board[a-i][b-i] == 'x') {
                                    numrock1++;
                                    num+=(5-i);
                                }
                                else if(board[a-i][b-i] == 'o'){
                                    break;
                                }
                                else {
                                    num++;
                                    numspace1++;
                                }
                            }
                        }
                        value+=num;
                        num=0;
                        ///////////////////////row4 part1/////////////////////////////

                        for(int i=1;i<Math.min(Math.min(5, 15-a), 15-b);i++) {
                            if(board[a+i-1][b+i-1]=='x') {
                                if(board[a+i][b+i]=='x') {
                                    numcon++;
                                    numrock2++;
                                    num+=2*(5-i);
                                }
                                else if(board[a+i][b+i]=='o'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    numspace2++;
                                    num++;
                                }
                            }
                            else {
                                if(board[a+i][b+i]=='x') {
                                    numrock2++;
                                    num+=(5-i);
                                }
                                else if(board[a+i][b+i]=='o'){
                                    if(numspace1+numspace2+numrock1+numrock2<5) {
                                        num=0;
                                    }
                                    break;
                                }
                                else {
                                    num++;
                                    numspace2++;
                                }
                            }
                        }
                    }


                    if(numcon==5) {
                        row=5;
                        value=1000;
                    }

                    board[a][b]=' ';
                    valueBoard[a][b] = value; //num1 + num2 + num3 + num4;
                }
                else {
                    valueBoard[a][b] = 0;
                }
                System.out.printf("\nValue at %d, %d: %d", a, b, valueBoard[a][b]);
            }
        }
        max = -1;
        Ypos = 0;
        Xpos = 0;
        Random random = new Random();
        for (int i=0; i<15; i++) {
            for (int j = 0; j<15; j++) {
                if ((valueBoard[i][j] >= max) && (board[i][j] == ' ')) {
                    max = valueBoard[i][j];
                    if(random.nextBoolean()) {
                        Ypos = j + 1;
                        Xpos = i;
                    }
                }
            }
        }
        System.out.printf("\nmax: %d\nYpos: %d\nXpos: %d\n", max, Ypos, Xpos);
        return map.get(Xpos).toString() + Integer.toString(Ypos);
    }
}
