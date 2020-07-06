package bit_manipulation;

import java.util.Scanner;

public class Unset_msb_to_i {
	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		int a = sf.nextInt();
		int j =1;
		int i = sf.nextInt();
		i = j<<i;
		if(i!=0) {
			i = i-1;
			}
		System.out.println(a & i);
		sf.close();
	}

}
