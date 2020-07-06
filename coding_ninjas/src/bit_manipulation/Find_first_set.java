package bit_manipulation;

import java.util.Scanner;

public class Find_first_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int a  = sf.nextInt();
		int b =1;
		if(a!=0) {
			for (int i = 0; i < 32; i++) {
				if((a & b)!=0) {
					System.out.println(b);
					break;
				}
				b = b<<1;
			}
		}
		else {
			System.out.println(a);
		}
		
		sf.close();
	}

}
