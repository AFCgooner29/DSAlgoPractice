package easy;
/*
 * Given an sorted array of 0’s and 1’s in non-decreasing order. Find the sum of array in O(log n)
Approach : Apply Binary Search to find the position of first 1 and return n-position+1.
 */
public class Sum_sorted_01_array {
	public static int findZero(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		boolean found = false;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==0) {
				start = mid+1;
			}
			else {
				found = true;
				end = mid-1;
			}
		}
		if(found)return start;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,1,1,1};
		System.out.println(arr.length - findZero(arr));
	}

}
