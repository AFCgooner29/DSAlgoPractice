package medium;
/*
 * 287. Find the Duplicate Number
Medium

3798

468

Add to List

Share
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Find_repeating_num {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i])-1;
			if(nums[num]<0) {
				return num+1;
			}
			nums[num] = -1 * nums[num];
		}
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
