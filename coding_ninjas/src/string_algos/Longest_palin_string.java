package string_algos;

import java.util.Scanner;

public class Longest_palin_string {
	public static int finder(String s1) {
		int left;
		int right;
		int counter = 1;
		for (int i = 0; i < s1.length(); i++) {
			left = i-1;
			right = i+1;
			int curr_counter1 = 1;
			int curr_counter2 = 0;
			while(left>=0 && right<s1.length() && s1.charAt(left)==s1.charAt(right)) {
				left--;
				right++;
				curr_counter1 = curr_counter1+2;
			}
			if(i!=s1.length()-1 && s1.charAt(i)==s1.charAt(i+1)) {
				left = i-1;
				right = i+2;
				curr_counter2 = 2;
				while(left>=0 && right<s1.length() && s1.charAt(left)==s1.charAt(right)) {
					left--;
					right++;
					curr_counter2 = curr_counter2+2;
				}
			}
			counter = Math.max(counter, Math.max(curr_counter1,curr_counter2));
		}
		
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		System.out.println(finder(s1));
		sf.close();
	}

}
