package number_theory1;

import java.util.Scanner;

public class GCD {
	public static int findGCD(int a,int b) {
		if(a==0 || b==0) {
			return Math.max(a, b);
		}
		return findGCD(b, a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		System.out.println(findGCD(sf.nextInt(), sf.nextInt()));
		sf.close();
	}

}
