package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01 {
	public static int finder_iter(int[] W,int[] V,int w) {
		int[][] dp = new int[2][w+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= w; j++) {
			dp[0][j] = 0;
		}
		for (int i = 1; i < W.length+1; i++) {
			for (int j = 1; j <= w; j++) {
				dp[1][j] = dp[0][j];
				if(W[i-1]<=j) {
					dp[1][j] = Math.max(dp[0][j], V[i-1]+dp[0][j - W[i-1]]);
				}
			}
			for (int j = 0; j < w+1; j++) {
				dp[0][j] = dp[1][j];
			}
		}
		return dp[dp.length-1][w];
	}
	public static int finder(int[] W,int[] V,int i,int w,int[][] dp) {
		if(i==W.length || w == 0) {
			return 0;
		}
		
		int output_1= 0;
		if(dp[i][w]>-1) {
			return dp[i][w]; 
		}
		if(W[i]<=w) {
			output_1 = V[i]+finder(W, V, i+1, w-W[i],dp);
		}
		int output_2 = finder(W, V, i+1, w,dp);
		dp[i][w] = Math.max(output_1, output_2);
		return dp[i][w];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] W = new int[n];
		int[] V = new int[n];
		for (int i = 0; i < W.length; i++) {
			W[i] = sf.nextInt();
		}
		for (int i = 0; i < V.length; i++) {
			V[i] = sf.nextInt();
		}
		int w = sf.nextInt();
		int[][] dp = new int[n][w+1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(finder(W, V, 0, w,dp));
		System.out.println(finder_iter(W, V, w));
		sf.close();
	}

}
