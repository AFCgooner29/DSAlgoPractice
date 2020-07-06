package backtracking;

import java.util.Scanner;

/*N-Queen Problem

You are given N, and for a given N x N chessboard, find a way to place N queens such that 
no queen can attack any other queen on the chess board. 
A queen can be killed when it lies in the same row, or same column, 
or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 
*/
public class N_queens {
	public static void placeNQueens(int n){
		
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		placer(board, 0, 0, n);
		
		
		}
	public static void placer(int[][] board,int row,int col,int n) {
		if(row>=n/* && board[0][n]==1*/) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println("");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(checker(board, row, i, n)) {
				board[row][i] = 1;
				placer(board, row+1, 0, n);
				board[row][i] = 0;
			}
		}
		return;
		
	}
	public static boolean checker(int[][] board,int row,int col,int n) {
		for (int i = 0; i < n; i++) {
			if(board[i][col]==1) {
				return false;
			}
			if(board[row][i]==1) {
				return false;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]==1) {
					if(Math.abs(i-row)==Math.abs(j-col)) {
						return false;
					}
				}
			}
		}
		
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf =new Scanner(System.in);
		int n = sf.nextInt();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		placer(board, 0, 0, n);
		sf.close();

	}

}
