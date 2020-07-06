package dynamin_programming2;

/*
 * Charlie and Pilots
Send Feedback
Charlie acquired airline transport company and to stay in business he needs to lower the expenses by any means possible. There are N pilots working for his company (N is even) and N/2 plane crews needs to be made. A plane crew consists of two pilots - a captain and his assistant. A captain must be older than his assistant. Each pilot has a contract granting him two possible salaries - one as a captain and the other as an assistant. A captain's salary is larger than assistant's for the same pilot. However, it is possible that an assistant has larger salary than his captain. Write a program that will compute the minimal amount of money Charlie needs to give for the pilots' salaries if he decides to spend some time to make the optimal (i.e. the cheapest) arrangement of pilots in crews.
Input
The first line of input contains integer N, 2 ≤ N ≤ 10,000, N is even, the number of pilots working for the Charlie's company. The next N lines of input contain pilots' salaries. The lines are sorted by pilot's age, the salaries of the youngest pilot are given the first. Each of those N lines contains two integers separated by a space character, X i Y, 1 ≤ Y < X ≤ 100,000, a salary as a captain (X) and a salary as an assistant (Y).
Output
The first and only line of output should contain the minimal amount of money Charlie needs to give for the pilots' salaries. 
Sample Input
4 
5000 3000 
6000 2000 
8000 1000 
9000 6000 
Sample Output
19000 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Charlie_and_Pilots {

	public static int finder(int[] caps,int[] ass, int x,int n,int[][] dp) {
		if(n==0) {
			return 0;
		}
		if(dp[n][x]!=-1) {
			return dp[n][x];
		}
		if(x==0) {
			dp[n][x] = ass[0] + finder(Arrays.copyOfRange(caps, 1, caps.length), Arrays.copyOfRange(ass, 1, ass.length), x+1, n-1,dp);
			return dp[n][x];
		}
		else if(x==n) {
			dp[n][x] =  caps[0] + finder(Arrays.copyOfRange(caps, 1, caps.length), Arrays.copyOfRange(ass, 1, ass.length), x-1, n-1,dp);
			return dp[n][x];
		}
		else {
			int op1 = ass[0] + finder(Arrays.copyOfRange(caps, 1, caps.length), Arrays.copyOfRange(ass, 1, ass.length), x+1, n-1,dp);
			int op2 = caps[0] + finder(Arrays.copyOfRange(caps, 1, caps.length), Arrays.copyOfRange(ass, 1, ass.length), x-1, n-1,dp);
			dp[n][x] = Math.min(op1, op2);
			return dp[n][x];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[] caps = new int[tot];
		int[] ass = new int[tot];
		int[][] dp = new int[tot+1][(tot/2)+1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < tot; i++) {
			caps[i] = sf.nextInt();
			ass[i] = sf.nextInt();
		}
		System.out.println(finder(caps,ass, 0, tot,dp));
		sf.close();
	}

}
