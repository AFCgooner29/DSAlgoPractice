package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;
/*
 * this is not workin check again
 */
public class Shortest_Subsequence {
	
	public static int solve(String s1,String s2,int[][] dp){
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input. Input is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int k = j;
				while(k<s2.length()) {
					if(s1.substring(i-1,i).equals(s2.substring(k-1,k))) {
						break;
					}
					k++;
				}
				if(k==s2.length()) {
					dp[i][j] = 1;
				}
				int op1 = 1 + dp[i-1][j-1];
				int op2 = dp[i-1][j];
				dp[i][j] = Math.min(op1, op2);
			}
		}
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
		System.out.println(solve(s1, s2,dp));
		sf.close();
	}

}
