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
public class Maximum_Square_Matrix_With_All_Zeros {
	public static void finder(int[][] board,int n,int m) {
		int max_size = 0;
		/*
		 * We will fix L and R
		 * We will create sum arr
		 * For L to R we will store sum of every row in sum arr
		 * then we will check for consecutive zeros in sum arr that are equal to R-L+1
		 */
		int[] sum = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < sum.length; j++) {
				sum[j]= board[j][i];
				if(sum[j]==0) {
					max_size = Math.max(max_size, 1);
				}
			}
			for (int j = i; j < m; j++) {
				if(j!=i) {
					int consecutive_zeros = 0;
					for (int k = 0; k < sum.length; k++) {
						sum[k]+= board[k][j];
						if(k>0) {
							if(sum[k]==0 && sum[k-1]==0) {
								consecutive_zeros++;
							}
							else {
								consecutive_zeros = 0;
							}
							if(consecutive_zeros==j-i) {
								max_size = Math.max(max_size, consecutive_zeros+1);
								consecutive_zeros = 0;
							}
						}
					}
					
				}
			}
		}
		System.out.println(max_size);
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
		finder(board, n, m);
		sf.close();
	}

}
