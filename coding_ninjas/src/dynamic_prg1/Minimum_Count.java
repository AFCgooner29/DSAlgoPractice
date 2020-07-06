package dynamic_prg1;

import java.util.Scanner;

/*
 * Minimum Count
Send Feedback
Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. Output will be 1, as 1 is the minimum count of numbers required.
Note : x^y represents x raise to the power y.
Input Format :
Integer N
Output Format :
Required minimum count
Constraints :
1 <= N <= 1000
Sample Input 1 :
12
Sample Output 1 :
3
Sample Output 1 Explanation :
12 can be represented as :
1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1
1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 2^2
1^1 + 1^1 + 1^1 + 1^1 + 2^2 + 2^2
2^2 + 2^2 + 2^2
As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1

 */
public class Minimum_Count {
	public static int finder2(int n) {
		/*
		 * learn again this one
		 * 
		 */
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int j = 4; j <=n; j++) {
			dp[j] = j;
			for (int i = 1; i < n; i++) {
				int sqr = i*i;
				if(sqr<=j) {
					dp[j] = Math.min(dp[j], 1+dp[j-sqr]);
				}
				else {
					break;
				}
			}
		}
		return	dp[n];
	}
	public static void finder(int n, int[] min_count, int curr_count,int[][] store) {
		if(n==0) {
			if(curr_count<min_count[0]) {
				min_count[0] = curr_count;
				return;
			}
		
		}
		else if (n<0) {
			return;
		}
		for (int i = 1; i < n; i++) {
			int sqr = i*i;
			if(n-sqr>0 && store[n-sqr][i]>0) {
				if(store[n-sqr][i]<min_count[0]) {
					min_count[0] = store[n-sqr][i];
					continue;
				}
			}
			else if(n%sqr!=n) {
				finder(n-sqr, min_count, curr_count+1,store);
				store[n-sqr][i] = min_count[0];
			}
			else {break;}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		//int[][] store = new int[N+1][N+1];
		//int[] min_count = {N};
		//finder(N, min_count, 0,store);
		System.out.println(finder2(N));
		sf.close();
	}

}
