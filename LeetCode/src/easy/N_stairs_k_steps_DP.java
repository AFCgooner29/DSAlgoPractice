package easy;
/*
 * Given a number n which represent total stairs. Find in how many ways you can reach the nth stair with 1 or 2 steps at a time.
Approach : DP
Since to reach 0th, number of ways = 1;
to reach 1st, number of ways = 1 (0->1);
to reach 2nd, number of ways= 2 (0->1->2 | 0->2)
to reach 3rd, number of ways= 3
Hence we can see, to reach nth stair, number of ways= ways to reach (n-1)th +ways to reach (n-2)th.
Link : Nth Stair
Furthermore he asked me expand this problem with k-steps (k steps at max which can be taken) :
It’s simple again just need to add previous k values to get ways to reach at particular stair.
 */
public class N_stairs_k_steps_DP {
	public static int finder(int n,int k) {
		int[] dp = new int[n];
		for (int i = dp.length-1;i>=0; i--) {
			for (int j = 1; j <=k; j++) {
				if(j+i == dp.length) {
					dp[i]++;
				}
				else if(j+i<dp.length) {
					dp[i]+=dp[i+j];
				}
				else {
					break;
				}
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(finder(3, 2));
	}

}
