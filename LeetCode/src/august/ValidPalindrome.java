package august;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while(start<end) {
        	if((s.charAt(start)<'a' || s.charAt(start)>'z') && (s.charAt(start)<'0' || s.charAt(start)>'9')) {
        		start++;
        		continue;
        	}
        	if((s.charAt(end)<'a' || s.charAt(end)>'z') && (s.charAt(end)<'0' || s.charAt(end)>'9')) {
        		end--;
        		continue;
        	}
        	if(s.charAt(start)==s.charAt(end)) {
        		start++;
        		end--;
        	}
        	else {
        		return false;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
