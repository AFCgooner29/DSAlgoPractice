package dynamin_programming2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Square Brackets
Send Feedback
You are given:
a positive integer n,
an integer k, 1<=k<=n,
an increasing sequence of k integers 0 < s1 < s2 < ... < sk <= 2n.
What is the number of proper bracket expressions of length 2n with opening brackets appearing in positions s1, s2,...,sk?
Illustration
Several proper bracket expressions:
[[]][[[]][]] 
[[[][]]][][[]]
An improper bracket expression:
[[[][]]][]][[]]
There is exactly one proper expression of length 8 with opening brackets in positions 2, 5 and 7.
Task
Write a program which for each data set from a sequence of several data sets:
1. reads integers n, k and an increasing sequence of k integers from input,
2. computes the number of proper bracket expressions of length 2n with opening brackets appearing at positions s1,s2,...,sk,
3. writes the result to output.
Input
The first line of the input file contains one integer d, 1 <= d <= 10, which is the number of data sets. The data sets follow. Each data set occupies two lines of the input file. The first line contains two integers n and k separated by single space, 1 <= n <= 19, 1 <= k <= n. The second line contains an increasing sequence of k integers from the interval [1;2n] separated by single spaces.
Output
The i-th line of output should contain one integer - the number of proper bracket expressions of length 2n with opening brackets appearing at positions s1, s2,...,sk.
Sample Input
5 
1 1 
1 
1 1 
2 
2 1 
1 
3 1 
2 
4 2 
5 7 
Sample Output
1 
0 
2 
3 
2 
* Approach
* we have to make decisions that if we can place openening bracket or closing at ith position
* we will maintain count of opening and closing brackets
* if we reach end of length allowed then we check if opening brackets are equal to closing
* then we return 1 (one possibility is there)
* else
* return 0
* 
* now we have decisions
* if opening == n that means we have placed all allowed opening brackets then we only place closing
* else if opening==closing or we are instructed to place opening in Sk then we need to place a opening bracket
* else we try placing both and return sum of those possibilities
 */
public class Square_Brackets {
	public static int finder(int n,int opening,int closing,int i,HashMap<Integer, Integer> hp,int[][] dp) {
		if(i==2*n+1) {
			if(opening==closing) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if(opening>n || closing>n) {
			return 0;
		}
		if(dp[opening][closing]>-1) {
			return dp[opening][closing];
		}
		if(opening==closing || hp.get(i)!=null) {
			dp[opening][closing] =  finder(n, opening+1, closing, i+1,hp,dp);
			return dp[opening][closing];
		}
		else if(opening==n) {
			dp[opening][closing] = finder(n, opening,closing+1, i+1,hp,dp);
			return dp[opening][closing];
		}
		dp[opening][closing] = finder(n, opening+1,closing, i+1,hp,dp) + finder(n, opening,closing+1, i+1,hp,dp); 
		return dp[opening][closing];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 0; i < tot; i++) {
			int n = sf.nextInt();
			int k = sf.nextInt();
            int flag = 0;
            int[][] dp = new int[n+1][n+1];
            for (int j = 0; j < dp.length; j++) {
				Arrays.fill(dp[j], -1);
			}
			HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
			for (int j = 0; j < k; j++) {
                int temp =sf.nextInt(); 
				hp.put(temp, 0);
                if(temp==0){
                    System.out.println(0);
                    flag=1;
                }
			}
            if(flag==0){
                System.out.println(finder(n, 0 , 0, 1,hp,dp));
            }
		
		}
		sf.close();
	}

}
