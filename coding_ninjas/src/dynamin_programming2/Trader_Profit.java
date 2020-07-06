package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Trader Profit
Send Feedback
Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price and sells it at a higher price to book a profit. He has come to know the stock prices of a particular stock for n upcoming days in future and wants to calculate the maximum profit by doing the right transactions (single transaction = buying + selling). Can you help him maximize his profit?
Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.
The stock prices are given in the form of an array A for n days.
Given the stock prices and a positive integer k, find and print the maximum profit Mike can make in at most k transactions.
Input Format
The first line of input contains an integer q denoting the number of queries.

The first line of each test case contains a positive integer k, denoting the number of transactions. 

The second line of each test case contains a positive integer n, denoting the length of the array A.

The third line of each test case contains n space-separated positive integers, denoting the prices of each day in the array A.
Constraints
1<=q<=100

0<k<10

2<=n<=30

0<=elements of array A<=1000
Output Format
For each query print the maximum profit earned by Mike on a new line. 
Sample Input
3
2
6
10 22 5 75 65 80
3
4
20 580 420 900
1
5
100 90 80 50 25
Sample Output
87
1040
0
 */
public class Trader_Profit {
	public static int finder(int[] arr,int i,int flag,int k,int[][][] dp) {
		//flag 0 means that we can buy
		//flag 1 means we can sell
		if(i==arr.length) {
			return 0;
		}
		if(k<0) {
			return arr[i-1];
		}
		if(dp[flag][arr.length-i-1][k]>Integer.MIN_VALUE) {
			return dp[flag][arr.length-i-1][k];
		}
		if(flag==0) {
			int op1 = finder(arr, i+1, 1,k-1,dp) - arr[i];//we bought shares here
			int op2 = finder(arr, i+1, flag,k,dp);
			dp[flag][arr.length-i-1][k] = Math.max(op1, op2);
			return dp[flag][arr.length-i-1][k];
		}
		else {
			int op1 = finder(arr, i+1, 0,k,dp) + arr[i]; //we sold shares here
			int op2 = finder(arr, i+1, flag,k,dp);
			dp[flag][arr.length-i-1][k] = Math.max(op1, op2);
			return dp[flag][arr.length-i-1][k];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int total_test = sf.nextInt();
		for (int i = 0; i < total_test; i++) {
			int k = sf.nextInt();
			int n = sf.nextInt();
			int[][][] dp = new int[2][n][k+1];
			for (int j = 0; j < dp.length; j++) {
				for (int j2 = 0; j2 < dp[0].length; j2++) {
					Arrays.fill(dp[j][j2], Integer.MIN_VALUE);
				}
			}
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sf.nextInt();
			}
			System.out.println(finder(arr, 0, 0, k,dp));
		}
		sf.close();
	}

}
