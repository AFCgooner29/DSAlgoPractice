package easy;
/*
 * 268. Missing Number
Easy

1477

1858

Add to List

Share
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Missing_number {
	public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if(num==0) {
				nums[0] = -1;
			}
			else {
				nums[num] = -1*nums[num];
			}
		}
        int i;
        for (i = 0; i < nums.length; i++) {
			if(nums[i]>0) {
				break;
			}
		}
        return i;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
