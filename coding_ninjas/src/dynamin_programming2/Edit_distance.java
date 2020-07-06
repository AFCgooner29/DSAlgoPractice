package dynamin_programming2;
/*
 * Author : Sharanmeet Singh
 * Date : 20/2/2020
 * Edit Distance - Problem
Send Feedback
Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :
1. Delete a character

2. Replace a character with another one

3. Insert a character
Note - Strings don't contain spaces
Input Format :
Line 1 : String s
Line 2 : String t
Output Format :
Line 1 : Edit Distance value
Constraints
1<= m,n <= 20
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 */

/*
 * Approach below
 * when we have 2 strings ans we start from index 0 and 0 for both strings
 * then at each positions we make some decisions the decisions are
 * 1. if character at index x and y is same then we do not need to edit it hence do not add
 * to edit distance
 * 2. if character is not equal at x and y then we make following decisions
 * 		1. Either we substitute the character of s1 at x with that of s2's at y, we do not
 * 			really change character we just assume that its changed and we move on
 * 			in this case x and y are both inceremented
 * 		2. Either we delete the xth character of s1 and continue checking for x+1 and y
 * 		3. Either we add same character as of s2's yth pos in front of s1 and then check 
 * 			for x and y+1 as by adding we made chars in s1 to be x+1, we do not include newly added
 * 			char and check for further strings
 * 		In all the ways we are doing +1 work so we find min of all the above three decisions
 * 		and add 1 to it
 * 
 * Iterative approach
 * 		similar to LCS
 */
import java.util.Arrays;
import java.util.Scanner;

public class Edit_distance {
	//below solution does not work for all the cases
	//when s1 is smaller that s2 but have something common
	/*public static int finder(String s1,String s2) {
		int n = s1.length()+1;
		int m = s2.length()+1;
		int[][] dp =new int[n][m];
		for (int j = 0; j < dp.length; j++) {
			Arrays.fill(dp[j], -1);
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
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
		int max_seq = dp[n-1][m-1];
		dp=null;
		int min_len = Math.min(n-1, m-1);
		int max_len = Math.max(n-1, m-1);
		int diff = max_len-min_len;
		min_len=min_len - max_seq + diff;
		
		return min_len;
		
	}*/
	public static int finder_recursive(String s1,String s2,int x,int y,int[][] dp) {
		if(x==s1.length() || y==s2.length()) {
			return Math.max(s1.length()-x, s2.length()-y);
		}
		int ans = 0;
		if(dp[x][y]>-1) {
			return dp[x][y];
		}
		if (s1.substring(x,x+1).equals(s2.substring(y,y+1))) {
			ans = finder_recursive(s1, s2, x+1, y+1,dp);
		}
		else {
			ans = 1 + Math.min(finder_recursive(s1, s2, x+1, y,dp),Math.min(finder_recursive(s1, s2, x+1, y+1, dp),finder_recursive(s1, s2, x, y+1, dp)));
		}
		dp[x][y]=ans;
		return ans;
	}
	public static int finder_iter(String s1,String s2,int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i; // because if length of one string is 0 then Edit distance equals length of 2nd string
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=i; // because if length of one string is 0 then Edit distance equals length of 2nd string
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(s1.substring(i-1,i).equals(s2.substring(j-1,j))) {
					dp[i][j] = dp[i-1][j-1];
			}
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1]/*substitution*/, Math.min(dp[i-1][j]/*deletion*/, dp[i][j-1]/*adding in front of s1*/));
					}
				}
		}
		int ans = dp[dp.length-1][dp[0].length-1];
		dp = null;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		String s2 = sf.next();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(finder_recursive(s1, s2, 0, 0,dp));
		System.out.println(finder_iter(s1, s2, dp));
		sf.close();
	}

}
