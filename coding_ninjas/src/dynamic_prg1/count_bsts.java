package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;

public class count_bsts {
	public static long countTrees1(int numKeys,double[] dp) {
		/* Your class should be named Solution
			 * Don't write main().
			 * Don't read input, it is passed as function argument.
			 * Return output and don't print it.
		 	 * Taking input and printing output is handled automatically.
			*/
		if(numKeys==0 || numKeys == 1) {
			return 1;
		}
		else if(dp[numKeys]>0) {
			return (long)dp[numKeys];
		}
		int res = 0;
		for(int i = 2; i <=numKeys; i++) {
			res = 0;
			for (int j = 1; j <= i; j++) {
				res+= countTrees1(j-1, dp)*countTrees1(i-j, dp) ;
				
			}
			dp[i] = res%(Math.pow(10, 9)+7);
		}
		return (long)dp[numKeys];
			
	}
	static long numberOfBST(int n) 
    { 
  
    // DP to store the number  
    // of unique BST with key i 
    long dp[] = new long[n + 1]; 
    Arrays.fill(dp, 0); 
  
    // Base case 
    dp[0] = 1; 
    dp[1] = 1; 
  
    // fill the dp table in 
    // top-down approach. 
    for (int i = 2; i <= n; i++)  
    { 
        for (int j = 1; j <= i; j++)  
        { 
  
            // n-i in right * i-1 in left 
        	double temp = (dp[i] + (dp[i - j] * dp[j - 1]))%(Math.pow(10, 9)+7);
            dp[i] = (long)temp; 
        } 
    } 
  
    return (long)(dp[n]%(Math.pow(10, 9)+7)); 
} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		double[] dp = new double[n+1];
		dp[0] = 0;
		dp[1] = 1;
		System.out.println(countTrees1(n,dp));
		System.out.println(numberOfBST(n));
		sf.close();
	}

}
