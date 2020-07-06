package greedy_approach;

import java.util.Arrays;
import java.util.Scanner;

public class Winning_Lottery {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int d = sf.nextInt();
		int[] tot = new int[d];
		Arrays.fill(tot, 0);
		n = n-1;
		tot[0] = 1;
		for (int i = d-1; i >0; i--) {
			if(n>=9) {
				tot[i]= 9;
				n=n-9;
			}
			else {
				tot[i] = n;
				n= 0;
			}
		}
		if(n>0) {
			tot[0] = 1+n;
		}
		for (int i = 0; i < tot.length; i++) {
			System.out.print(tot[i]);
		}
		sf.close();
	}

}
