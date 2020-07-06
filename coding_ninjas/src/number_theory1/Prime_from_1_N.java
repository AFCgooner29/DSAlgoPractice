package number_theory1;

import java.util.Scanner;

public class Prime_from_1_N {
	public static int findPrime(int N) {
		int[] prime = new int[N+1];
        int ans = 0;
		for (int i = 1; i < prime.length; i++) {
			if(i==1) {
				ans++;
			}
			else {
				if(prime[i]==0) {
					ans++;
					for (int j = i+i; j < prime.length; j=j+i) {
						prime[j] = 1;
					}
				}
			}
		}
            return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		System.out.println(findPrime(sf.nextInt()));
		sf.close();
	}

}
