package medium;

import java.util.Arrays;
/*
 * Same as normal search without duplucates
 * but one new case is there when nums[start] == nums[mid] == nums[end]
 * in this case we can start squeezing the array to stop the conflict
 * for eg check for this array 1 3 1 1 1 1 we need to find 3
 * so above condition is true here so we can squeeze the array from a side till this condition
 * breaks
 */
public class Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(nums[mid]==target) {
				return true;
			}
			if(nums[mid]==nums[start]&& nums[start]==nums[end]) {
				if(!search(Arrays.copyOfRange(nums, start, mid), target)) {
					return search(Arrays.copyOfRange(nums, mid+1, end), target);
				}
				return true;
			}
			else if(nums[mid]>=nums[start]) {
				//left side is sorted
				if(target>=nums[start] && target<=nums[mid]) {
					end = mid;
				}
				else {
					start = mid+1;
				}
			}
			else {
				//right is sorted
				if(target>=nums[mid] && target<=nums[end]) {
					start = mid;
				}
				else {
					end = mid-1;
				}
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
