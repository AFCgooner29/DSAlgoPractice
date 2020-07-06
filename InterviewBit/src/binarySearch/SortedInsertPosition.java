package binarySearch;

import java.util.ArrayList;

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class SortedInsertPosition {
	public static int searchInsert(ArrayList<Integer> a, int b) {
		int start = 0;
		int end = a.size()-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(a.get(mid)>b) {
				end = mid-1;
			}
			else if(a.get(mid)<b) {
				start = mid+1;
			}
			else {
				return mid;
			}
		}
		return start-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
