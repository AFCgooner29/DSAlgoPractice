package dynamin_programming2;
//balika vadhu problem
import java.util.Arrays;
import java.util.Scanner;

public class LCS_of_given_length {
	public static int finder(String s1,String s2,int l,int[][][] dp) {
		if(l==0) {
			return 0;//ASCI value of ans
		}
		if(s1.length()==0 || s2.length()==0) {
			return Integer.MIN_VALUE;
		}
		
		if(dp[s1.length()][s2.length()][l]>-1) {
			return dp[s1.length()][s2.length()][l];
		}
		if(s1.substring(0,1).equals(s2.substring(0,1))) {
			int first = (int)s1.charAt(0)+finder(s1.substring(1), s2.substring(1), l-1,dp);
			int third = finder(s1, s2.substring(1), l, dp);
			int sec_ans = finder(s1.substring(1), s2, l,dp);
			dp[s1.length()][s2.length()][l] = Math.max(first, Math.max(sec_ans, third));
			return dp[s1.length()][s2.length()][l];
		}
		else {
			int third = finder(s1.substring(1), s2,l,dp);
			int sec_ans = finder(s1, s2.substring(1),l,dp);
			dp[s1.length()][s2.length()][l] =  Math.max(sec_ans, third);
			return dp[s1.length()][s2.length()][l];
		}
		
		
	}
	public static void finder_iter(String s1,String s2) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test_cases = sf.nextInt();
		for (int i = 0; i < test_cases; i++) {
			String s1 = sf.next();
			String s2 = sf.next();
			int l =sf.nextInt();
			 int[][][] dp = new int[101][101][101];
			 for (int j = 0; j <101; j++) { 
				 for (int j2 = 0; j2 < 101; j2++) {
					 Arrays.fill(dp[j][j2], -1);
				}
			 }
					 
			int ans =finder(s1, s2,l,dp);
			if(ans<=0) {
				System.out.println(0);
			}
			else {
				System.out.println(ans);
			}
		}
		sf.close();
	}

}
