package revision;

import java.util.Arrays;

/*
 * Problem Description

Find the contiguous subarray within an array, A of length N which has the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10] 
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:

 10 
Output 2:

 6 


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 

 */
public class MaxSumContiguousSubarray {
	public static int maxSubArray(final int[] A) {
		int subSum = 0;
		int maxSum = Integer.MIN_VALUE;
		boolean postiveFound = false;
		for (int i = 0; i < A.length; i++) {
			subSum+=A[i];
			if(!postiveFound && A[i]>=0) {
				postiveFound = true;
			}
			if(subSum<0) {
				subSum = 0;
			}
			maxSum = Math.max(maxSum, subSum);
		}
		if(!postiveFound)
			return  Arrays.stream(A).max().getAsInt();
		return maxSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,-1,-1,-11};
		System.out.println(maxSubArray(arr));
	}

}
