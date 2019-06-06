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
       for (int a=0; a<15; a++) {
            for (int b=0; b<15; b++) {
                if(board[a][b] == ' ') {
                    int num1 = 0;//세로 vertical
                    int num2 = 0;//가로 horizontal
                    int num3 = 0;//오른대각선 diagonal1
                    int num4 = 0;//왼쪽대각선 diagonal2
                    
                    int numcon =2;
                    board[a][b]='o';
	                    for(int i=1; i<Math.min(15-a,5); i++) {
	                        	if(board[a+i][b]=='o') {
	                        		numcon+=2;
	                        	}
	                        	else if(board[a+i][b]=='x') {
	                        		break;
	                        	}
	                        	else {
	                        		numcon++;
	                        	}
	                    }
	                    for(int i=1; i<Math.min(a+1, 5); i++) {
	                    	if(board[a-i][b]=='o') {
                        		numcon+=2;
                        	}
                        	else if(board[a-i][b]=='x') {
                        		break;
                        	}
                        	else {
                        		numcon++;
                        	}
	                    }
	                    //  switch to value
	                    	switch(numcon) {
	                    	case 2:numcon=0;
	                    		break;
	                    	case 3:numcon=2;
	                    		break;
	                    	case 4:numcon=5;
	                    		break;
	                    	case 5:numcon=10;
	                    		break;
	                    	case 6:numcon=25;
	                    		break;
	                    	case 7:numcon=50;
	                    		break;
	                    	case 8:numcon=100;
	                    		break;
	                    	case 9:numcon=200;
	                    		break;
	                    	case 10:numcon=1000;
	                    		break;
	                    	default: numcon=0;	
	                    	}
	                    num1=numcon;//num1 points
	                    numcon=2;
	                    for(int i=1; i<Math.min(15-b,5); i++) {
	                        if(board[a][b+i] == 'o') {
	                            numcon+=2;
	                        }
	                        else if(board[a][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1; i<Math.min(b+1,5); i++) {
	                        if(board[a][b-i] =='o') {
	                            numcon+=2;
	                        }
	                        else if(board[a][b-i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num2=numcon;//num2 5개인지 검사
	                    numcon=2;
	                    
	                    for(int i=1; i<Math.min(Math.min(a+1, 5), 15-b); i++) {
	                        if(board[a-i][b+i] == 'o') {
	                            numcon+=2;
	                        }
	                        else if(board[a-i][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1; i<Math.min(Math.min(5, b+1), 15-a) ;i++) {
	                        if(board[a+i][b-i] == 'o') {
	                            numcon+=2;
	                        }
	                        else if(board[a+i][b-i] == ' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num3=numcon;//num3 5개인지 검사
	                    numcon=2;
	                    
	                    for(int i=1; i<Math.min(Math.min(5, a+1), b+1); i++) {
	                        if(board[a-i][b-i] == 'o') {
	                            numcon+=2;
	                        }
	                        else if(board[a-i][b-i] == ' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1;i<Math.min(Math.min(5, 15-a), 15-b);i++) {
	                        if(board[a+i][b+i]=='o') {
	                            numcon+=2;
	                        }
	                        else if(board[a+i][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num4=numcon;//num4 5개인지 검사
	                    numcon=2;

                    
                    ///////////////////////////////////////////////////////////
                   board[a][b]='x';
                    	for(int i=1; i<Math.min(15-a,5); i++) {
                        	if(board[a+i][b]=='x') {
                        		numcon+=2;
                        	}
                        	else if(board[a+i][b]=='o') {
                        		break;
                        	}
                        	else {
                        		numcon++;
                        	}
	                    }
	                    for(int i=1; i<Math.min(a+1, 5); i++) {
	                    	if(board[a-i][b]=='x') {
	                    		numcon+=2;
	                    	}
	                    	else if(board[a-i][b]=='o') {
	                    		break;
	                    	}
	                    	else {
	                    		numcon++;
	                    	}
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num1+=numcon;//num1 points
	                    numcon=2;
	                    
	                    for(int i=1; i<Math.min(15-b,5); i++) {
	                        if(board[a][b+i] == 'x') {
	                            numcon+=2;
	                        }
	                        else if(board[a][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1; i<Math.min(b+1,5); i++) {
	                        if(board[a][b-i] =='x') {
	                            numcon+=2;
	                        }
	                        else if(board[a][b-i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num2+=numcon;//num2 5개인지 검사
	                    numcon=2;
	                    
	                    for(int i=1; i<Math.min(Math.min(a+1, 5), 15-b); i++) {
	                        if(board[a-i][b+i] == 'x') {
	                            numcon+=2;
	                        }
	                        else if(board[a-i][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1; i<Math.min(Math.min(5, b+1), 15-a) ;i++) {
	                        if(board[a+i][b-i] == 'x') {
	                            numcon+=2;
	                        }
	                        else if(board[a+i][b-i] == ' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num3+=numcon;//num3 5개인지 검사
	                    numcon=2;
	                    
	                    for(int i=1; i<Math.min(Math.min(5, a+1), b+1); i++) {
	                        if(board[a-i][b-i] == 'x') {
	                            numcon+=2;
	                        }
	                        else if(board[a-i][b-i] == ' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    }
	                    for(int i=1;i<Math.min(Math.min(5, 15-a), 15-b);i++) {
	                        if(board[a+i][b+i]=='x') {
	                            numcon+=2;
	                        }
	                        else if(board[a+i][b+i]==' '){
	                            numcon++;
	                        }
	                        else {
	                        	break;
	                        }
	                    } 
	                    switch(numcon) {
                    	case 2:numcon=0;
                    		break;
                    	case 3:numcon=2;
                    		break;
                    	case 4:numcon=5;
                    		break;
                    	case 5:numcon=10;
                    		break;
                    	case 6:numcon=25;
                    		break;
                    	case 7:numcon=50;
                    		break;
                    	case 8:numcon=100;
                    		break;
                    	case 9:numcon=200;
                    		break;
                    	case 10:numcon=1000;
                    		break;
                    	default: numcon=0;	
                    	}
	                    num4+=numcon;//num4 5개인지 검사
	                   board[a][b]=' ';
             
                }
                else {
                    valueBoard[a][b] = 0;
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
