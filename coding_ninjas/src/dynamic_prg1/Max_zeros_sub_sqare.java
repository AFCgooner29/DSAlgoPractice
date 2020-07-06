package dynamic_prg1;

import java.util.Scanner;

/*
 * Maximum Square Matrix With All Zeros
Send Feedback
Given a n*m matrix which contains only 0s and 1s, find out the size of maximum square sub-matrix with all 0s. You need to return the size of square with all 0s.
Input format :
Line 1 : n and m (space separated positive integers)
Next n lines : m elements of each row (separated by space).
Output Format:
Line 1 : Size of maximum square sub-matrix
Sample Input :
3 3
1 1 0
1 1 1
1 1 1
Sample Output :
1
 */
public class Max_zeros_sub_sqare {
	public static int finder(int[][] board,int n,int m) {
		int max = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j]==0) {//if zero is found
					row++;
					for (int j2 = i; j2 < n; j2++) {
						if(board[j2][j]==0) {
							col++;
						}
						else {
							col = 0;
							break;}
					}
					if(max<Math.min(row, col)) {
						max = Math.min(row, col);
					}
				}
				else {
					row = 0;
					col = 0;
				}
			}
			row = 0;
			col = 0;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sf.nextInt();
			}
		}
		System.out.println(finder(board, n, m));
		sf.close();
	}

}
