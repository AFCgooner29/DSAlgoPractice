package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Subset Sum - Problem
Send Feedback
Given a set of n integers, find if a subset of sum k can be formed from the given set. Print Yes or No.

Input Format
First line contains a single integer n (1<=n<=1000)
Second line contains n space separated integers (1<=a[i]<=1000)
Last line contains a single positive integer k (1<=k<=1000)
Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Sample Input
3
1 2 3
4
Sample Output
YES
 */
/*
 * Approach 
 * In this problem we can use boolean DP array as we do not need to print any values
 * 
 */
public class Subset_sum {
	public static void finder_iter(int[] V,int sum) {
		boolean[][] dp =new boolean[V.length+1][sum+1];
		for (int i = 0; i < sum+1; i++) {
			dp[0][i] = false;//as when no element is there in V then for every sum we cant find sub seq
		}
		dp[0][0] = true;//as when sum req is 0 then for every array theres a possible answer
		dp[1][0] = true;// that is empty set
		for (int i = 1; i < V.length+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				dp[1][j] = dp[0][j];
				if(j-V[i-1]>=0) {
					dp[1][j] = dp[1][j] || dp[0][j-V[i-1]];
				}
			}
			for (int j = 0; j < sum+1; j++) {
				dp[0][j] = dp[1][j];
			}
		}
		if(dp[1][sum]) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	public static int finder_rec(int[] V,int x,int sum,int[][] dp) {
		if(sum==0) {
			return 1;
		}
		if(x==V.length) {
			return 0;
		}
		if(dp[x][sum]!=-1) {
			return dp[x][sum];
		}
		int ans = finder_rec(V, x+1, sum,dp);
		if(sum-V[x]>=0) {
			ans = ans | finder_rec(V, x+1, sum-V[x],dp);
		}
		dp[V.length-x-1][sum] = ans;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] V = new int[n];
		for (int i = 0; i < V.length; i++) {
			V[i] = sf.nextInt();
		}
		int sum = sf.nextInt();
		finder_iter(V, sum);
		int[][] dp = new int[V.length][sum+1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],-1);
		}
		if(finder_rec(V, 0, sum,dp)==1) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		sf.close();
	}

}
