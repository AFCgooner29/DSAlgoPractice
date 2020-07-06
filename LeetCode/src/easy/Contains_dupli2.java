package easy;

import java.util.HashMap;

/*
 * 219. Contains Duplicate II
Easy

737

897

Add to List

Share
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class Contains_dupli2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if(hp.containsKey(nums[i])) {
				if(i - hp.get(nums[i])<=k) { //if last found at and current index falls under range k
					return true;
				}
				else {
					hp.put(nums[i], i); //updating last found at
				}
			}
			else {
				hp.put(nums[i], i);
			}
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
