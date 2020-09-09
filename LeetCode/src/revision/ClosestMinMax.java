package revision;
/*
 * Closest MinMax
Problem Description

Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

and atleast one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3]
Input 2:

A = [2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Only choice is to take both elements.
Explanation 2:

 Take the whole array.

 */
public class ClosestMinMax {
	public static int solve(int[] A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i :A) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		if(min==max) {
			return 1;
		}
		int minIdx = Integer.MAX_VALUE;
		int maxIdx = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==min) {
				minIdx = i;
			}
			if(A[i]==max) {
				maxIdx = i;
			}
			if(minIdx==Integer.MAX_VALUE || maxIdx == Integer.MAX_VALUE)
				continue;
			ans = Math.min(ans, Math.abs(maxIdx-minIdx)+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,2,3};
		System.out.println(solve(A));
	}

}
