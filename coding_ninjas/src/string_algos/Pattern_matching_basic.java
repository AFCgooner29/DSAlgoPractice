package string_algos;

import java.util.Scanner;

public class Pattern_matching_basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		String pat = sf.next();
		for (int i = 0; i < s1.length() - pat.length(); i++) {
			if(s1.substring(i,i+pat.length()).equals(pat)) {
				System.out.println("Found at "+(i+1)+" to "+(i+pat.length()));
			}
		}
		sf.close();
	}

}
