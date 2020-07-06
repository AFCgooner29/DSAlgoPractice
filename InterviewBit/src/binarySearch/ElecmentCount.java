package binarySearch;

import java.util.ArrayList;
/*
 * Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.

PROBLEM APPROACH :

For complete solution, look at the hint.

https://youtu.be/pLT_9jwaPLs
 */
public class ElecmentCount {
	public int findCount(final ArrayList<Integer> A, int B) {
		int min_idx;
		int max_idx;
		int start = 0;
		int end = A.size()-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(A.get(mid)<B) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		min_idx = end+1;
		start = 0;
		end = A.size()-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(A.get(mid)>B) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		max_idx = start-1;
		return max_idx-min_idx+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
