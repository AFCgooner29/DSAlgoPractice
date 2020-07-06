package strings;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given the array of strings A,
you need to find the longest string S which is the prefix of ALL the strings in the array.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1
and S2.

For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Input Format

The only argument given is an array of strings A.
Output Format

Return longest common prefix of all strings in A.
For Example

Input 1:
    A = ["abcdefgh", "aefghijk", "abcefgh"]
Output 1:
    "a"
    Explanation 1:
        Longest common prefix of all the strings is "a".

Input 2:
    A = ["abab", "ab", "abcd"];
Output 2:
    "ab"
    Explanation 2:
        Longest common prefix of all the strings is "ab".
Seen this question in a real interview beforeYesNo
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(ArrayList<String> A) {
		String common = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			int j;
			for (j = 0; j < A.get(i).length() && j< common.length(); j++) {
				if(A.get(i).charAt(j)!=common.charAt(j)) {
					common = common.substring(0, j);
					break;
				}
			}
			common = common.substring(0, j);
		}
		return common;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<String> A = new ArrayList<String>();
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.next());
		}
		System.out.println(longestCommonPrefix(A));
		sf.close();
	}

}
