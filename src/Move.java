import static java.lang.Character.toUpperCase;

public class Move extends Board{

    public Move(char[][] board) {
        this.board = board;
    }

    public boolean checkEmpty(int a, int b) {
        b--;  //zero-indexing
        if((board[a][b] == 'o') || (board[a][b] == 'x')) {
            System.out.println("This place is not empty. Please put the stone in other place\n");
            return false; //not empty
        }
        return true; //empty
    }

    public boolean withinBoard(int a, int b) {
        b--; //zero-indexing
        if(a<0||a>15) {
            System.out.println("This place is not in the board input other place\n");
            return false;
        }
        else if(b<0||b>15) {
            System.out.printf("\nThis place is not in the board input other place\n");
            return false;
        }
        return true; //position is within board
    }

    public boolean legalMove(String position) {
        int a = map.get(toUpperCase(position.charAt(0)));
        int b = 0;
        if (position.length() > 3 || position.length() < 2) {
            return false;
        }
        switch (position.length()) {
            case 2:
                b = Character.getNumericValue(position.charAt(1));
            case 3:
                b = Integer.parseInt(position.substring(1));
        }
        if ((withinBoard(a, b) && checkEmpty(a, b))) {
            return true;
        }
        return false;
    }

    public boolean gameFinished(String position) {
        int b = 0;
        int a = map.get(toUpperCase(position.charAt(0)));
        switch (position.length()) {
            case 2:
                b = Character.getNumericValue(position.charAt(1));
            case 3:
                b = Integer.parseInt(position.substring(1));
        }
        b--; //because of 0-indexing

        int num1=0;//세로 vertical
        int num2=0;//가로 horizontal
        int num3=0;//오른대각선 diagonal1
        int num4=0;//왼쪽대각선 diagonal2

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

        if (num1==4||num2==4||num3==4||num4==4) {
            System.out.printf("\nThe game is finished\n");
            return true;
        }
        else
            return false; //the game is not finished

    }

   public boolean ThreeThreerule(String position){
    	 int b = 0;
         int a = map.get(toUpperCase(position.charAt(0)));
         switch (position.length()) {
             case 2:
                 b = Character.getNumericValue(position.charAt(1));
             case 3:
                 b = Integer.parseInt(position.substring(1));
         }
         b--; //because of 0-indexing
         
		int num1=1;
		int num2=1;
		int[] check= new int[4];
		check[0]=0;check[1]=0;check[2]=0;check[3]=0;
		
			for(int i=1;i<Math.min(15-a,3);i++) {
				if(board[a+i][b]==board[a][b]) {
					num1++;
					for(int j=1; j<Math.min(15-b,3); j++) {
			            if(board[a+i][b+j] != board[a][b]) {
			                break ;
			            }
			            else {
			            	num2++;
			            }
			        }
			        for(int j=1; j<Math.min(b+1,3); i++) {
			            if(board[a+i][b-j] != board[a][b]) {
			                break;
			            }
			            else {
			                num2++;
			            }
			        }//
			        if(num2==3) {
			        	check[0]=1;
			        }
			        num2=1;
				}
				else {
					break;
				}
			}
			for(int i=1;i<Math.min(a+1, 3);i++) {
				if(board[a-i][b]==board[a][b]) {
					num1++;
					for(int j=1; j<Math.min(15-b,3); j++) {
			            if(board[a-i][b+j] != board[a][b]) {
			                break ;
			            }
			            else {
			            	num2++;
			            }
			        }
			        for(int j=1; j<Math.min(b+1,3); i++) {
			            if(board[a-i][b-j] != board[a][b]) {
			                break;
			            }
			            else {
			                num2++;
			            }
			           
			        }
			        if(num2==3) {
			        	check[0]=1;
			        }
			        num2=1;
				}
				else {
					break;
				}
			}//vertical////////////////////////////////////////////////////////////////
		num1=1;
		num2=1;
				
		 	for(int i=1; i<Math.min(15-b,3); i++) {
	            if(board[a][b+i] != board[a][b]) {
	                break ;
	            }
	            else {
	            	num2++;
	            	for(int j=1; j<Math.min(15-a,3); j++) {
	                    if(board[a+j][b+i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num1++;
	                    }
	                }
	                for(int j=1; j<Math.min(a+1, 3); j++) {
	                    if(board[a-j][b+i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num1++;
	                    }
	                }
	                if(num1==3) {
	                	check[1]=1;
	                }
	                num1=1;
	            }
	        }
	        for(int i=1; i<Math.min(b+1,3); i++) {
	            if(board[a][b-i] != board[a][b]) {
	                break;
	            }
	            else {
	                num2++;
	                for(int j=1; j<Math.min(15-a,3); j++) {
	                    if(board[a+j][b-i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num1++;
	                    }
	                }
	                for(int j=1; j<Math.min(a+1, 3); j++) {
	                    if(board[a-j][b-i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num1++;
	                    }
	                }
	                if(num1==3) {
	                	check[1]=1;
	                }
	                num1=1;
	            }
	        } //horizontal////////////////////////////////////////////////////
	        int num3=1;
	        int num4=1;
	        
	        for(int i=1; i<Math.min(Math.min(a+1, 3), 15-b); i++) {
	            if(board[a-i][b+i] != board[a][b]) {
	                break ;
	            }
	            else {
	                num3++;
	                for(int j=1; j<Math.min(Math.min(3, a+1), b+1); j++) {
	    	            if(board[a-j-i][b-j+i] != board[a][b]) {
	    	                break ;
	    	            }
	    	            else {
	    	                num4++;
	    	            }
	    	        }
	    	        for(int j=1;j<Math.min(Math.min(3, 15-a), 15-b);j++) {
	    	            if(board[a+j-i][b+j+i]!=board[a][b]) {
	    	                break;
	    	            }
	    	            else {
	    	                num4++;
	    	            }
	    	        }
	    	        if(num4==3) {
	    	        	check[2]=1;
	    	        }
	    	        num4=1;
	            }
	        }
	        for(int i=1; i<Math.min(Math.min(3, b+1), 15-a) ;i++) {
	            if(board[a+i][b-i] != board[a][b]) {
	                break;
	            }
	            else {
	                num3++;
	                for(int j=1; j<Math.min(Math.min(3, a+1), b+1); j++) {
	    	            if(board[a-j+i][b-j-i] != board[a][b]) {
	    	                break ;
	    	            }
	    	            else {
	    	                num4++;
	    	            }
	    	        }
	    	        for(int j=1;j<Math.min(Math.min(3, 15-a), 15-b);j++) {
	    	            if(board[a+j+i][b+j-i]!=board[a][b]) {
	    	                break;
	    	            }
	    	            else {
	    	                num4++;
	    	            }
	    	        }
	    	        if(num4==3) {
	    	        	check[2]=1;
	    	        }
	    	        num4=1;
	            }
	        } //diagonal1/////////////////////////////////////////////////////////////
	        num3=1;
	        num4=1;
	        
	        for(int i=1; i<Math.min(Math.min(3, a+1), b+1); i++) {
	            if(board[a-i][b-i] != board[a][b]) {
	                break ;
	            }
	            else {
	                num4++;
	                for(int j=1; j<Math.min(Math.min(a+1, 3), 15-b); j++) {
	                    if(board[a-j-i][b+j-i] != board[a][b]) {
	                        break ;
	                    }
	                    else {
	                        num3++;
	                    }
	                }
	                for(int j=1; j<Math.min(Math.min(3, b+1), 15-a) ;j++) {
	                    if(board[a+j-i][b-j-i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num3++;
	                    }
	                }
	                if(num3==3) {
	                	check[3]=1;
	                }
	                num3=1;
	                
	            }
	        }
	        for(int i=1;i<Math.min(Math.min(3, 15-a), 15-b);i++) {
	            if(board[a+i][b+i]!=board[a][b]) {
	                break;
	            }
	            else {
	                num4++;
	                for(int j=1; j<Math.min(Math.min(a+1, 3), 15-b); j++) {
	                    if(board[a-j+i][b+j+i] != board[a][b]) {
	                        break ;
	                    }
	                    else {
	                        num3++;
	                    }
	                }
	                for(int j=1; j<Math.min(Math.min(3, b+1), 15-a) ;j++) {
	                    if(board[a+j+i][b-j+i] != board[a][b]) {
	                        break;
	                    }
	                    else {
	                        num3++;
	                    }
	                } 
	                if(num3==3) {
	                	check[3]=1;
	                }
	                num3=1;
	            }
	        } //diagonal2
	        
		
		
		
		if((num1==3&&check[0]==1)||(num2==3&&check[1]==1)||(num3==3&&check[2]==1)||(num4==3&&check[3]==1)) {
			return true; //obeyed 3and3rule
		}
		else
			return false;
	}
}
