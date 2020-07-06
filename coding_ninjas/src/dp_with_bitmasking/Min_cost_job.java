package dp_with_bitmasking;

import java.util.Arrays;
import java.util.Scanner;

public class Min_cost_job {
	public static int bimask(int[][] matrix,int bit,int n,int[] dp) {
		if(n>matrix.length) {
			return 0;
		}
		if(dp[bit]!=-1) {
			return dp[bit];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if(((bit>>i)&1)==0) {
				int ans = bimask(matrix, (bit|(1<<i)), n+1,dp) + matrix[n][i];
				min = Integer.min(ans, min);
			}
		}
		dp[bit] = min;
		return min;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int no_of_person = sf.nextInt();
		int[][] matrix = new int[no_of_person][no_of_person];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = sf.nextInt();
			}
		}
		int[] dp = new int[(1<<no_of_person)];
		Arrays.fill(dp, -1);
		System.out.println(bimask(matrix, 0, 0,dp));
		sf.close();
	}

}
