package medium;

import java.util.Scanner;

/*
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Remove_k_digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		StringBuilder s1 = new StringBuilder(sf.nextLine());
		int k = sf.nextInt();
		/*
		 * int first_max = 0; int second_max = 0; for (int i = 0; i < s1.length(); i++)
		 * { if(Integer.parseInt(s1.substring(i,i+1))>first_max) { first_max =
		 * Integer.parseInt(s1.substring(i,i+1)); } else { second_max =
		 * Math.max(second_max, Integer.parseInt(s1.substring(i,i+1))); } }
		 * System.out.println(first_max+" "+second_max);
		 */
		int i = 0;
		/*
		while(k>0 || i<s1.length()) {
			if(s1.charAt(i)>s1.charAt(i+1)) {
				s1.delete(i, i+1);
				k--;
			}
			else {
				i++;
			}
		}
		
		*/
		while(k>0) {
			while(i<s1.length()-1 && s1.charAt(i)<=s1.charAt(i+1)) {
				i++;
			}
			s1.delete(i, i+1);
			k--;
			i = 0;
		}
		System.out.println(s1);
		sf.close();
	}

}
