package easy;
/*
 * Single Element in a Sorted Array
Solution
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
 */
/*
 * Approach we can use xor nut that solution is O(n)
 * We can use binary search to make it O(lgn)
 * every even index will have its pair at next index
 * every odd index will have its pair at previous index
 */
/*
 * Stefan Pochman's
 * odd xor 1 = odd-1
 * even xor 1 = even+1
 * 
 * public int singleNonDuplicate(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) >>> 1;
        if (nums[mid] == nums[mid ^ 1])
            lo = mid + 1;
        else
            hi = mid;
    }
    return nums[lo];
}
 */
public class SingleElementInArr {
	public int singleNonDuplicate(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum^nums[i];
        }
        return sum;
    }
	public static int singleNonDuplicate2(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end) {
        	int mid = start +(end-start)/2;
        	if(mid%2==1) {
        		//mid is odd so check previous index 1123344556677
        		if(nums[mid-1]!=nums[mid]) {
        			end = mid;
        		}
        		else {start = mid+1;}
        	}
        	else {
        		//mid is even
        		if(nums[mid+1]!=nums[mid]) {
        			end = mid;
        		}
        		else {start = mid+1;}
        	}
        }
        return nums[start];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3,3,4,4,5,5};
		System.out.println(singleNonDuplicate2(arr));
	}

}
