package medium;
/*
 * Approach
 * We find which side of array is sorted 
 * for that side we can check the first element will be smallest
 * we update the min with that element
 * and check the otherside if that side has a smaller element
 * 
 * while checking if(nums[start]<=nums[mid]) = is important because start and mid might be equal
 * still need to investigate on this statement 
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
	public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end) {
        	int mid = (start+end)/2;
        	min = Math.min(nums[mid], min);
        	if(nums[start]<=nums[mid]) {
        		//left is sorted
        		min = Math.min(nums[start], min);
        		start = mid+1;
        	}
        	else {
        		//right is sorted
        		end = mid-1;
        	}
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,6,0,1};
		System.out.println(findMin(arr));
	}

}
