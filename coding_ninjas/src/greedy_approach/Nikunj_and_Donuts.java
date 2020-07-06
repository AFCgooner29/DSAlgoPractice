package greedy_approach;

import java.util.Arrays;
import java.util.Scanner;

public class Nikunj_and_Donuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		long[] input = new long[tot];
		for (int i = 0; i < tot; i++) {
			input[i] = sf.nextLong();
		}
		Arrays.parallelSort(input);
		long val = 0;
		for (int i = input.length-1; i >= 0; i--) {
			val+=input[i] * Math.pow(2, (input.length - i -1));
		}
		System.out.println(val);
		sf.close();
	}

}
