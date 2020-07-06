package dp_with_bitmasking;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Candy
Send Feedback
Gary is a teacher at XYZ school. To reward his N students he bought a packet of N candies all with different flavours. But the problem is some students like certain flavour while some doesn't. Now Gary wants to know the number of ways he can distribute these N candies to his N students such that every student gets exactly one candy he likes.
Input Format :
Line 1 : An integer N (1<= N <= 16) denoting number of students and candies.
Next N lines : N integers describing the preferences of one student. 1 at i'th (0 <= i < N) position denotes that this student likes i'th candy , 0 means he doesn't.
Assume input to be 0-indexed based.
Output Format :
Return the number of ways Gary can distribute these N candies to his N students such that every student gets exactly one candy he likes.``
Sample Input:
3
1 1 1
1 1 1
1 1 1
Sample Output:
6
 */
/*
 * make a no of candy size mask and give the candy to the child who likes it
 * if all children got candy then return 1 else find the candy that child can eat then add that
 * to ans and return ans
 */
public class Candy {
	public static long finder(int[][] matrix,int bit,int child, long[] dp) {
		if(child==matrix.length) {
			return 1;
		}
		if(dp[bit]!=-1) {
			return dp[bit];
		}
		long ans = 0;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[child][i]==1 && (bit&(1<<i))==0) {
				ans+=finder(matrix, bit|(1<<i), child+1,dp);
			}
		}
		dp[bit] = ans;
		return ans;
	}
	public static long solve(int[][] like,int N){
        long[] dp = new long[(1<<N)];
		Arrays.fill(dp, -1);
		return finder(like,0,0,dp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j]=sf.nextInt();
			}
		}
		System.out.println(solve(matrix, n));
		long[] dp = new long[(1<<n)];
		Arrays.fill(dp, -1);
		System.out.println(finder(matrix, 0, 0, dp));
		sf.close();
	}

}
