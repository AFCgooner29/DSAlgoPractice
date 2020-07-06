package strings;
/*
 * 
Asked in:  
Facebook
Amazon
Qualcomm
Wipro
Microsoft
Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 

 */
public class Implement_strStr {
	public static int[] generateLPS(String A) {
		int[] ans = new int[A.length()];
		ans[0] = 0;
		int j = 0;
		int i = 1;
		while(i<A.length()) {
			if(A.charAt(i)==A.charAt(j)) {
				ans[i] = j+1;
				i++;j++;
			}
			else {
				if(j!=0) {
					j = ans[j-1];
				}
				else {
					ans[i] = 0;
					i++;
				}
			}
		}
		return ans;
	}
	public static int strStr(final String A, final String B) {
		if(A.isEmpty()||B.isEmpty())return -1;
        int[] lps = generateLPS(A);
        int i = 0;
        int j = 0;
        while(i<B.length()&& j<A.length()) {
        	if(A.charAt(j)==B.charAt(i)) {
        		i++;
        		j++;
        	}
        	else {
        		if(j!=0) {
        			j = lps[j-1];
        		}
        		else {
        			i++;
        		}
        	}
        	if(j==A.length()) {
        		return i-j;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("sub","sasadsubsubstr"));
	}

}
