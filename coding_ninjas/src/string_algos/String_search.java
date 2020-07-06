package string_algos;

import java.util.Scanner;

/*
 * String Search
Send Feedback
Given two strings S and T, write a function to find if T is present as a substring inside S or not. If yes, return the starting index otherwise return -1.
Input format :

Line 1 : String S

Line 2 : String T

Sample Input 1:
WelcomeBack
come 
Sample Output 1:
3
Sample Input 2:
WelcomeBack
code
Sample Output 2:
-1
 */
public class String_search {

	public static int[] longest_pre_suf_sum(String s1) {
		int i = 0;
		int j = 1;
		int[] lps = new int[s1.length()];
		lps[0] = 0;
		while (j<s1.length()) {
			if(s1.charAt(i) == s1.charAt(j)) {
				lps[j] = i+1;
				j++;
				i++;
			}
			else {
				if(i!=0) {
					i = lps[i-1];
				}
				else {
					lps[j] = 0;
					j++;
				}
			}
		}
		return lps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String input = sf.next();
		String pat = sf.next();
		int[] lps = longest_pre_suf_sum(pat);
		int i = 0;
		int j = 0;
		int last_match = 0;
		while(j<pat.length() && i<input.length()) {
			if(input.charAt(i)==pat.charAt(j)) {
				j++;
				i++;
				last_match = i;
			}
			else {	
				if(j!=0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
				
			}
		}
		if(j==pat.length()) {
			System.out.println(last_match-pat.length());
		}
		else {
			System.out.println(-1);
		}
		sf.close();
	}

}
