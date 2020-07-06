package easy;


/*
 * 66. Plus One
Easy

1305

2143

Add to List

Share
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Accepted
543,523
Submissions
1,294,070
 */
public class Plus_one {
	public static int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length-1; i >=0; i--) {
			if(i == digits.length-1) {
				int dummy = digits[i]+1;
				if(dummy>9) {
					digits[i] = dummy%10;
					carry = 1;
				}
				else {
					digits[i] = dummy;
				}
			}
			else {
				int dummy = digits[i]+carry;
				carry = 0;
				if(dummy>9) {
					digits[i] = dummy%10;
					carry = 1;
				}
				else {
					digits[i] = dummy;
				}
			}
		}
        if(carry>0) {
        	int[] new_dig = new int[digits.length+1];
        	new_dig[0] = carry;
        	for (int i = 1; i < new_dig.length; i++) {
				new_dig[i] = digits[i-1];
			}
        	return new_dig;
        }
        return digits;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
		int[] ans = plusOne(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]);
		}
	}

}
