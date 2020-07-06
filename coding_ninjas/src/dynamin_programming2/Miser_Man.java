package dynamin_programming2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Miser Man
Send Feedback
Jack is a wise and miser man. Always tries to save his money.
One day, he wants to go from city A to city B. Between A and B, there are N number of cities(including B and excluding A) and in each city there are M buses numbered from 1 to M. And the fare of each bus is different. Means for all N*M busses, fare (K) may be different or same. Now Jack has to go from city A to city B following these conditions:
1. At every city, he has to change the bus.
2. And he can switch to only those buses which have number either equal or 1 less or 1 greater to the previous.
You are to help Jack to go from A to B by spending the minimum amount of money.
N, M, K <= 100.
Input
Line 1:    N M

Line 2:    NxM Grid

Each row lists the fares the M busses to go form the current city to the next city.
Output
Single Line containing the minimum amount of fare that Jack has to give.
Sample Input
5 5
1  3  1  2  6
10 2  5  4  15
10 9  6  7  1
2  7  1  5  3
8  2  6  1  9
Sample Output
10


Approach
we have three decisions to make
1 either we use same number of bus for next city
2 either we chose bus one before which we chose last time
3 either we choose bus one after which we chose last time
4 we return min of all three options
 */
public class Miser_Man {
	public static int finder(int[][] bus_stand,int x,int y,int[][] dp) {
		if(x==bus_stand.length) {
			return 0;
		}
		if(dp[x][y]<Integer.MAX_VALUE) {
			return dp[x][y];
		}
		if(y>=1 && y<bus_stand[0].length-1) {
			int opt1 = bus_stand[x][y] + finder(bus_stand, x+1, y-1,dp);
			int opt2 = bus_stand[x][y] + finder(bus_stand, x+1, y+1,dp);
			int opt3 = bus_stand[x][y] + finder(bus_stand, x+1, y,dp);
			dp[x][y] = Math.min(opt1, Math.min(opt2, opt3));
			return dp[x][y];
		}
		else if(y==0) {
			int opt2 = bus_stand[x][y] + finder(bus_stand, x+1, y+1,dp);
			int opt3 = bus_stand[x][y] + finder(bus_stand, x+1, y,dp);
			dp[x][y] = Math.min(opt2,opt3);
			return dp[x][y];
		}
		else {
			int opt1 = bus_stand[x][y] + finder(bus_stand, x+1, y-1,dp);
			int opt3 = bus_stand[x][y] + finder(bus_stand, x+1, y,dp);
			dp[x][y] = Math.min(opt1,opt3);
			return dp[x][y];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		int[][] bus_stand = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bus_stand[i][j] = sf.nextInt();
			}
		}
		int min_val = Integer.MAX_VALUE;
		int[][] dp = new int[n][m];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < m; i++) {
			min_val = Math.min(min_val, finder(bus_stand, 0, i,dp));
		}
		System.out.println(min_val);
		sf.close();
	}

}
