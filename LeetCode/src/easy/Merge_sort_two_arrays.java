package easy;
/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class Merge_sort_two_arrays {
	public static void swapper(int[] arr,int j) {		
		while(j<arr.length-1 && arr[j]>=arr[j+1]) {
			int temp = arr[j];
       		arr[j] = arr[j+1];
       		arr[j+1] = temp;
       		j++;
		}
		while(j>0 && arr[j]<=arr[j-1]) {
			int temp = arr[j];
       		arr[j] = arr[j-1];
       		arr[j-1] = temp;
       		j--;
		}

	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i<m && j<n) {
        	if(nums1[i]>nums2[j]) {
        		int temp = nums1[i];
        		nums1[i] = nums2[j];
        		nums2[j] = temp;
        		swapper(nums2, j);
        		i++;
        	}
        	else {
        		i++;
        	}
        }
        while(j<n) {
        	nums1[i] = nums2[j];
        	j++;
        	i++;
        }
        for (int j2 = 0; j2 < nums1.length; j2++) {
			System.out.println(nums1[j2]);
		}
        //remaining elements we will add at the end
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,0,0,0};
		int[] nums2 = {1,4,5};
		merge(nums1, 2, nums2, 3);
	}

}
