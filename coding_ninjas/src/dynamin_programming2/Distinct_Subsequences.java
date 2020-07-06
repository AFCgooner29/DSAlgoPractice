package dynamin_programming2;

import java.util.HashMap;
import java.util.Scanner;

public class Distinct_Subsequences {
	public static final long mod = 1000000007;
	
	 
	public static long finder(String s1) {
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		long dp[] = new long[s1.length()+1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 2*(dp[i-1]%mod);
			if(hp.get(s1.substring(i-1,i))!=null) {
				dp[i] = (dp[i] - dp[hp.get(s1.substring(i-1,i))]+mod)%mod;
			}
			hp.put(s1.substring(i-1,i), i-1);
		}
		return dp[s1.length()]%mod;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 0; i < tot; i++) {
			System.out.println(finder(sf.next()));
		}
		sf.close();
		
	}

}
