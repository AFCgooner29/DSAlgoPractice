package advanced_recursion;

public class remove_cons_dupli {
	/*
	 * Remove Duplicates Recursively
Send Feedback
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= Length of String S <= 10^3
Sample Input :
aabccba
Sample Output :
abcba

	 */
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		if(s.equals("")) {
			return "";
		}
		if(s.length()>1 && s.charAt(0)==s.charAt(1)) {//checking its not last character and if next one is same then we remove first one and call recursively on that
			s = s.substring(1);
			return removeConsecutiveDuplicates(s);
		}
		return s.substring(0,1)+removeConsecutiveDuplicates(s.substring(1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbbababbccc";
		s = removeConsecutiveDuplicates(s);
		System.out.println(s);
	}

}
