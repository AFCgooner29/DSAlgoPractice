package dynamic_prg1;
/*
 * We have to find minimum cost to move from 0,0 to 2,2 in a 3x3 grid 
 */
public class Minimum_Cost {
	public static int finder(int[][] board,int x,int y,int desx,int desy,int[][] store) {
		if(x == desx && y == desy) {
			return board[desx][desy];
		}
		else if(x>=board.length ||y>=board.length) {
			return 1000000;
		}
		
		else if(store[x][y]>0) {
			return store[x][y];
		}
		int one = finder(board, x+1, y, desx, desy,store);
		int two = finder(board, x, y+1, desx, desy,store);
		int three = finder(board, x+1, y+1, desx, desy,store);
		store[x][y] = board[x][y]+Math.min(one, Math.min(two, three));
		return store[x][y];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[3][3];
		int[][] store = new int[3][3];
		board[0][0] = 4;
		board[0][1] = 3;
		board[0][2] = 2;
		board[1][0] = 1;
		board[1][1] = 8;
		board[1][2] = 3;
		board[2][0] = 1;
		board[2][1] = 1;
		board[2][2] = 8;
		System.out.println(finder(board, 0, 0, 2, 2,store));
	}

}
