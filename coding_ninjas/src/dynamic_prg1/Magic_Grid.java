package dynamic_prg1;

import java.util.Scanner;
/*
 * here we want that harry shouldnt die in the way,
      so we start from the destination and keep traversing 
      the path backwards, and calculating the minimum required
      power, if the power falls below or equal to zero, we
      reset the power. 
      Note that the reverse traversal means traversal along
      opposite direction of what is mentioned in the problem.
      
      
      We are resettin as the required health is negative we can work there with even minimum which is 1
 */
public class Magic_Grid {
	public static int finder(int[][] board,int x,int y,int desx,int desy,int power_left) {
		if(x == desx && y == desy) {
			return 1;//minumum strength req 
		}
		int fir  = 1000000;
		int sec  = 1000000;
		if(x!=board.length-1) {
			fir = finder(board, x+1, y, desx, desy, power_left-board[x][y]) -board[x+1][y];
		}
		else if(y!=board[x].length-1) {
			sec = finder(board, x, y+1, desx, desy, power_left-board[x][y]) -board[x][y+1];
		}
		
		if(fir<1) {
			fir = 1;
		}
		if(sec<1) {
			sec = 1;
		}
		return Math.min(fir,sec);
		
		
	}
	public static int finder1(int[][] board,int x,int y) {
		int R = board.length;
		int C = board[x].length;
		int[][] store = new int[R][C];
		store[R-1][C-1]=1;
		for (int i = R-2; i >=0; i--) {
			store[i][C-1] = store[i+1][C-1] - board[i][C-1];
			if(store[i][C-1]<1) {
				store[i][C-1] = 1;
			}
		}
		for (int i = C-2; i >=0; i--) {
			store[R-1][i] = store[R-1][i+1] - board[R-1][i];
			if(store[R-1][i]<1) {
				store[R-1][i] = 1;
			}
		}

		for (int i = R-2; i >= 0; i--) {
			for (int j = C-2; j >=0; j--) {
				store[i][j] = Math.min(store[i+1][j], store[i][j+1]) - board[i][j];
				if(store[i][j]<1) {
					store[i][j] = 1;
				}
			}
		}
		return store[0][0]; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		for (int k = 0; k < tot; k++) {
			int R = sf.nextInt();
			int C = sf.nextInt();
			int[][] board = new int[R][C];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j] = sf.nextInt();
				}
			}
			/*
			 * int res = finder(board, 0, 0, R-1, C-1, 1); if(res<1) {
			 * System.out.println(1); } else { System.out.println(res); }
			 */
			System.out.println(finder1(board, 0, 0));
		}
		sf.close();
	}

}
