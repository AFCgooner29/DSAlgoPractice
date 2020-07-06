package dynamic_prg1;

import java.util.Scanner;

public class Maximum_Sum_Rectangle {
	public static void finder(long[][] board,long[][] store,long[][] store_down,int n,int m) {
		long max_sum = Long.MIN_VALUE;
		for (int j = 0; j < n; j++) {
			for (int i = m-2; i >=0; i--) {
				store[j][i] = store[j][i]+store[j][i+1];
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = n-2; i >=0; i--) {
				store_down[i][j] = store_down[i][j]+store_down[i+1][j];
			}
		}
		long bottom_right = board[n-1][m-1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				long top_n_left = store[i][j]+store_down[i][j]-board[i][j];
				long btm_n_right = store[n-1][j]+store_down[i][m-1] - board[n-1][j]-board[n-1][m-1] - board[i][m-1];
				board[i][j] = top_n_left+btm_n_right;
			}
		}
		board[n-1][m-1]= bottom_right;
		
		/*
		 * for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) {
		 * System.out.print(board[i][j]+" "); } System.out.println(); }
		 */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					for (int k = 0; k < m; k++) {
						if(j2!=i && k!=j) {
							long upper = board[i][j]- board[i][k+1] - board[j2+1][j]+board[j2+1][k+1];
							max_sum = Math.max(max_sum, upper);
							
 						}
					}
				}
			}
		}
		System.out.println(max_sum);
	}
	public static void finder2(long[][] board,int n,int m) {
		/*
		 * we are fixing L and R 
		 * and for that L and R we are finding sum of every row and storing in sum
		 * array
		 * then we apply kadnes algo to find max sum subarray
		 * that will be the max rectange with max sum for that L and R
		 * we will find for all L and R
		 * max will be printed
		 * not Kadnes algo used is special impleentation when we have all negative numbers
		 */
		long max_sum = Long.MIN_VALUE;
		long[] sum = new long[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum[j] = board[j][i];
			}
			for (int j = i; j < m; j++) {
				if(j!=i) {
					sum[0]+= board[0][j];
					long max_so_far = sum[0];
					long max_ending_here = sum[0];
					for (int k = 1; k < n; k++) {
						sum[k]+= board[k][j];
						max_ending_here = Math.max(sum[k], max_ending_here+sum[k]); 
				        max_so_far = Math.max(max_so_far, max_ending_here); 
					}
					//apply kadanes algo now
					max_sum = Math.max(max_sum, max_so_far);
				}
				else {
					long max_so_far = sum[0];
					long max_ending_here = sum[0];
					for (int k = 1; k < n; k++) {
						max_ending_here = Math.max(sum[k], max_ending_here+sum[k]); 
				        max_so_far = Math.max(max_so_far, max_ending_here); 
					}
					max_sum = Math.max(max_sum, max_so_far);
				}
				
			}
		}
		System.out.println(max_sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf  = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		long[][] board = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sf.nextLong();
			}
		}
		finder2(board, n, m);
		sf.close();
	}

}
