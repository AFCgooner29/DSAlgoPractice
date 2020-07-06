package string_algos;

import java.util.Scanner;

/*
 * Palindromic Substrings
Send Feedback
Given a string S, count and return the number of substrings of S that are palindrome.
Single length substrings are also palindromes. You just need to calculate the count, not the substrings.
Input Format :
String S
Output Format :
count of palindrome substrings
Constraints :
1 <= Length of S <= 1000
Sample Input :
aba
Sample Output :
4
**Note : Here 4 corresponds to ("a","b","a","aba").
 */
public class Palindromic_substr {
	public static int finder(String s1) {
		int left;
		int right;
		int counter = 0;
		for (int i = 0; i < s1.length(); i++) {
			left = i-1;
			right = i+1;
			
			while(left>=0 && right<s1.length() && s1.charAt(left)==s1.charAt(right)) {//odd length checker
				left--;
				right++;
				counter++;
			}
			if(i!=s1.length()-1 && s1.charAt(i)==s1.charAt(i+1)) {//even length checker
				left = i-1;
				right = i+2;
				counter++;
				while(left>=0 && right<s1.length() && s1.charAt(left)==s1.charAt(right)) {
					left--;
					right++;
					counter++;
				}
			}
		}
		
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		System.out.println(s1.length()+finder(s1));
		sf.close();
	}

}
