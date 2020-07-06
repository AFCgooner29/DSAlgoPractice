package strings;
/*
 * Palindrome String
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString { 
	public static int isPalindrome2(String A) {
		A = A.toLowerCase();
		int i = 0;
		int j = A.length()-1;
		while(i<j) {
			if((A.charAt(i)<'a' || A.charAt(i)>'z') && (A.charAt(i)<'0' || A.charAt(i)>'9') ) {
				i++;
				continue;
			}
			if((A.charAt(j)<'a' || A.charAt(j)>'z') && (A.charAt(j)<'0' || A.charAt(j)>'9') ) {
				j--;
				continue;
			}
			if(A.charAt(i)!=A.charAt(j)) {
				return 0;
			}
			i++;
			j--;
		}
		return 1;
	}
	public static int isPalindrome(String A) {
		A = A.toLowerCase();
		StringBuilder ss = new StringBuilder(A);
		int k = 0;
		while(k<ss.length()) {
			if((ss.charAt(k)<'a' || ss.charAt(k)>'z') && (ss.charAt(k)<'0' || ss.charAt(k)>'9') ) {
				ss.replace(k, k+1, "");
			}
			else {
				k++;
			}
		}
		if(ss.length()==1) {
			return 1;
		}
		int i;
		int j;
		if(ss.length()%2==0) {
			 j = ss.length()/2;
			 i = j-1;
		}
		else {
			 i = ss.length()/2-1;
			 j = i + 2;
		}
		while(i>-1 && j<ss.length()) {
			if(ss.charAt(i)!=ss.charAt(j)) {
				return 0;
			}
			i--;
			j++;
		}
		return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome2("2,,,,,,a2"));
	}

}
