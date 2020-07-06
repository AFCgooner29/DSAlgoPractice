package hard;
/*
 * 41. First Missing Positive
Hard

2893

740

Add to List

Share
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Finding_next_positive {
	public static int firstMissingPositive(int[] nums) {
        //1 if we find something -ve or 0 then set it to some out of range value
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<1) {
				nums[i] = nums.length+1;
			}
		}
		//now we mark found values as negative
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if(num-1<nums.length) {
				if(nums[num-1]>0) {
					nums[num-1] = -1*nums[num-1];
				}
			}
		}
		// now we find first not postive 
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) {
				return i+1;
			}
		}
		return nums.length+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}

}
