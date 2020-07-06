package hard;

public class Median_of_two_sorted_array {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) {
        	return findMedianSortedArrays(nums2, nums1);
        }
        int start = 0;
        int mid_range = (nums1.length+nums2.length+1)/2;
        int end = nums1.length;
        while(start<=end) {
        	int mid = start+(end-start)/2;
        	int partX = mid;
        	int partY = mid_range-partX;
        	int leftX = (mid==0) ? Integer.MIN_VALUE : nums1[mid-1];
        	int rightX = (mid==nums1.length) ? Integer.MAX_VALUE : nums1[mid];
        	int leftY = (partY==0) ? Integer.MIN_VALUE : nums2[partY-1];
        	int rightY = (partY==nums2.length) ? Integer.MAX_VALUE : nums2[partY];
        	if(leftX<=rightY && leftY<=rightX) {
        		//this can be median
        		if((nums1.length+nums2.length)%2==0) {
        			double val = (double)Math.max(leftY, leftX)+Math.min(rightX, rightY);
        			return val/2;
        		}
        		else {
        			return Math.max(leftY, leftX);
        		}
        	}
        	else if(leftX>rightY) {
        		end = mid-1;
        	}
        	else {
        		start = mid+1;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
