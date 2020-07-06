package dynamin_programming2;
/*
 * Smallest Super-Sequence
Send Feedback
Given two strings S and T, find and return the length of their smallest super-sequence.
A shortest super sequence of two strings is defined as the shortest possible string containing both strings as subsequences.
Note that if the two strings do not have any common characters, then return the sum of lengths of the two strings.
Input Format:
Line 1 : A string
Line 2: Another string
Output Format:
Length of the smallest super-sequence of given two strings. 
Sample Input:
ab
ac
Sample Output:
3
Sample Output Explanation:
Their smallest super-sequence can be "abc" which has length=3.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Smallest_Super_Sequence {
	public static int LCS_finder(String s1,String s2,int[][] dp) {
		if(s1.length()==0 || s2.length() == 0) {
			return 0;
		}
		if(dp[s1.length()][s2.length()]>-1) {
			return dp[s1.length()][s2.length()];
		}
		if(s1.substring(0,1).equals(s2.substring(0,1))) {
			dp[s1.length()][s2.length()] = 1 + LCS_finder(s1.substring(1), s2.substring(1),dp);
			return dp[s1.length()][s2.length()];
		}
		int op1 = LCS_finder(s1.substring(1), s2,dp);
		int op2 = LCS_finder(s1, s2.substring(1),dp);
		dp[s1.length()][s2.length()] = Math.max(op1, op2);
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		String s2 = sf.next();
		int[][] dp =new int[s1.length()+1][s2.length()+1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i],-1);
		}
		int common = LCS_finder(s1, s2,dp);
		System.out.println(s1.length()+s2.length()-common);
		sf.close();
	}

}
