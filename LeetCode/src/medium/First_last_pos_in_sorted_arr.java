package medium;
/*
 * 34. Find First and Last Position of Element in Sorted Array
Medium

2860

128

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
/*
 * Approach we are using binary search
 * first we will find mid
 * and if mid>target then look to the left arr
 * and if mid<target then look to the right arr
 * if mid == target then based on what bound we want lower can be found on left side
 * we update ans according to logic
 */
public class First_last_pos_in_sorted_arr {
	public static int upperBound(int[] nums,int target) {
		int start = 0;
		int end = nums.length-1;
		int ans = -1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(nums[mid]<target) {
				start = mid+1;
			}
			else if(nums[mid]>target){
				end = mid-1;
			}
			else {
				if(mid==nums.length-1 || (nums[mid]!=nums[mid+1])) {
					ans = mid;
				}
				start = mid+1;
			}
		}
		return ans;
	}
	public static int lowerBound(int[] nums,int target) {
		int start = 0;
		int end = nums.length-1;
		int ans = -1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(nums[mid]<target) {
				start = mid+1;
			}
			else if(nums[mid]>target){
				end = mid-1;
			}
			else {
				if(mid==0 || (nums[mid]!=nums[mid-1])) {
					ans = mid;
				}
				end = mid-1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1};
		System.out.println(upperBound(arr,1));
		System.out.println(lowerBound(arr, 1));
	}

}
