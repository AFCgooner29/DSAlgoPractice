package backtracking_mergesort_assignment;

import java.util.Scanner;

public class Power_ofnum {
	public static int power(int num,int pow) {
		if(pow==0) {
			return 1;
		}
		return num*power(num,pow-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int num = sf.nextInt();
		int pw = sf.nextInt();
		System.out.println(power(num,pw));
		sf.close();
	}

}
