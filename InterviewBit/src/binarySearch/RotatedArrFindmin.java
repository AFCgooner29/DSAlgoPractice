package binarySearch;

import java.util.ArrayList;

/*
 * 
Asked in:  
Facebook
Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
PROBLEM APPROACH:

Note: If you know the number of times the array is rotated, then this problem becomes trivial. If the number of rotation is x, then minimum element is A[x].
Lets look at how we can calculate the number of times the array is rotated.

Complete solution in the hints.
https://youtu.be/4qjprDkJrjY
 */
public class RotatedArrFindmin {
	public int findMin(final ArrayList<Integer> a) {
		int start = 0;
		int end = a.size()-1;
		//min element will have bigger number on both sides
		while(start<=end) {
			int mid = start + (end-start)/2;
			int prev = (mid+a.size()-1)%a.size();
			int next = (mid+1)%a.size();
			if(a.get(prev)>a.get(mid) && a.get(mid)<a.get(next)) {
				return a.get(mid);
			}
			if(a.get(mid)<a.get(end)) {
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
		
	}

}
