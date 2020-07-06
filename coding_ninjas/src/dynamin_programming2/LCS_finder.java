package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Author : Sharanmeet singh
 * Date : 20/2/2020
 * in this we find the longest common subsequence between two strings
 * For eg there are two strings "abcdef" and "a22b21pqwc123diimef" here you can see
 * the first string is completely present in second string so the answer is 6
 * this code will return the length of LCS not the LCS itself
 * 
 * Approach
 * We will start from first index of both strings and then we have to make decisions based on
 * the values at the start
 * Decision 1 : if first element of both strings is same then we are sure that first element
 * will be part of LCS then we return 1+LCS(on remaining strings) remaining strings are found
 * by excluding first element from both strings
 * Decision 2 : if first element does not match, then either first element of first string will
 * be part of LCS or first element of second string
 * So we call on both decisions MAX(LCS(first string,remove first element of second),LCS(remove 
 * first element of first,second string as it is))
 * this will give us the max from both decisions.
 * 
 * TO OPTIMIZE WE WILL USE A DP ARRAY WHICH WILL WORK ON LENGTH OF STRINGS ON WHICH FUNCTION
 * IS CALLED
 */
public class LCS_finder {
	public static int finder(String s1,String s2,int x,int y,int l1,int l2,int[][] dp) {
		if(x==s1.length() || y==s2.length()) {
			return 0;
		}
		else if(dp[l1][l2]>-1) {
			return dp[l1][l2];
		}
		int ans = 0;
		if(s1.substring(x,x+1).equals(s2.substring(y,y+1))) {
			ans = 1+finder(s1, s2, x+1, y+1,l1-1,l2-1,dp);
		}
		else {
			ans = Math.max(finder(s1, s2, x+1, y,l1-1,l2,dp), finder(s1, s2, x, y+1,l1,l2-1,dp));
		}
		dp[l1][l2] = ans;
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
		System.out.println(finder(s1, s2, 0, 0,s1.length(),s2.length(),dp));
		dp = null;
		sf.close();
	}

}
