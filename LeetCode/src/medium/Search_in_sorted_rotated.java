package medium;
/*
 * Approach
 * we find the mid of the array
 * and if target is present at mid we return mid
 * otherwise we find which side of array is sorted 
 * for each side we check if target can be in that sorted side
 * then we search that side otherwise we search other side
 */
/*
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class Search_in_sorted_rotated {
	public static int finder(int[] nums, int target) {
		if(nums.length<1) {
			return -1;
		}
		int start = 0;
		int end = nums.length-1;
		while(start<end) {
			int mid = (start+end)/2;
			if(nums[start]<=nums[mid]) {
				//then left side is sorted
				if(target>=nums[start] && target<=nums[mid]) {
					end = mid;
				}
				else {
					start = mid+1;
				}
			}
			else {
				//right is sorted
				if(nums[mid]<=target && target<=nums[end]) {
					start = mid;
				}
				else {
					end = mid-1;
				}
			}
		}
		return start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1};
		System.out.println(finder(arr, 1));
	}

}
