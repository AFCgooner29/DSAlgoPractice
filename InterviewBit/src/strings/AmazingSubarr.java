package strings;

import java.util.HashMap;

/*
 * Amazing Subarrays
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
Seen this question in a real 
 */
public class AmazingSubarr {
	public int solve(String A) {
		int count = 0;
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		hp.put("A",1);
		hp.put("E",1);
		hp.put("I",1);
		hp.put("O",1);
		hp.put("U",1);
		hp.put("a",1);
		hp.put("e",1);
		hp.put("i",1);
		hp.put("o",1);
		hp.put("u",1);
		for (int i = 0; i < A.length(); i++) {
			if(hp.containsKey(A.substring(i,i+1))) {
				count+=A.length()-i;
				count = count%10003;
			}
		}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
