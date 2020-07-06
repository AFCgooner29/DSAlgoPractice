package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;
/*
 * THis is iterative solution to find LCS
 * we are fist filling first row and first column of DP array with
 * zeros as with one string with 0 length max LCS will be be 0
 * then for next row we will fill by making decision 
 * IF ELEMENT AT Ith place of s1 string and Jth element at s2 string is same them we will
 * pick data into dp[i][j] from dp[i-1][j-1]
 * else we pick up from MAX(dp[i-1][j],dp[i][j-1]) because LCS can be made using chosing ith element
 * or chosing j th element
 * 
 * 
 * 
 * Problem statement
 * 
 * LCS - Problem
Send Feedback
Given 2 strings of S1 and S2 with lengths m and n respectively, find the length of longest common subsequence.
A subsequence of a string S whose length is n, is a string containing characters in same relative order as they are present in S, but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to n. E.g. subsequences of string "abc" are - "",a,b,c,ab,bc,ac,abc.
Input Format :
Line 1 : String S1
Line 2 : String s2
Output Format :
Line 1 : Length of lcs
Sample Input :
adebc
dcadb
Sample Output :
3
 */

public class LCS_Iterative {
	public static int finder(String s1,String s2) {
		int n = s1.length()+1;
		int m = s2.length()+1;
		int[][] dp = new int[n][m];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if(s1.substring(i-1,i).equals(s2.substring(j-1,j))) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int ans = dp[n-1][m-1];
		dp = null;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		String s2 = sf.next();
		System.out.println(finder(s1, s2));
		sf.close();
	}

}
