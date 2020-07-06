package bit_manipulation;

import java.util.Scanner;

public class Unset_first_setbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int a  = sf.nextInt();
		System.out.println(a & (a-1));
		sf.close();
	}

}
