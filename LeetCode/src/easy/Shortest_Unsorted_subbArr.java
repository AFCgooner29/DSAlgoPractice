package easy;
/*
 * 581. Shortest Unsorted Continuous Subarray
Easy

2261

116

Add to List

Share
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
/*
 * not working
 */
public class Shortest_Unsorted_subbArr {
	public static int findUnsortedSubarray(int[] nums) {
        int i = 0;
        int size = 0;
        int start = 0;
        int min = 0;
        while(i<nums.length-1) {
        	if(nums[i]>nums[i+1]) {
        		int max = nums[i];
        		start = i;
        		min = nums[i];
        		while(i<nums.length && nums[i]<=max) {
        			max = Math.max(max, nums[i]);
        			min = Math.min(min, nums[i]);
        			i++;
        			size++;
        		}
        	}
        	i++;
        }
        while(start>0 && (nums[start]==nums[start-1] || nums[start-1]>min)) {
        	start--;
        	size++;
        }
        return size;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,9,12,1,1,2,14};
		System.out.println(findUnsortedSubarray(nums));
	}

}
