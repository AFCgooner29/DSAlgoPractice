package codejam;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int j = 0; j < test; j++) {
			int n = sf.nextInt();
			int[] alic = new int[n];
			int[] bob = new int[n];
			for (int i = 0; i < alic.length; i++) {
				alic[i] = sf.nextInt();
				bob[i] = sf.nextInt();
			}
			Arrays.parallelSort(bob);
		}
		sf.close();
	}

}
