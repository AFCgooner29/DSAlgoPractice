package binarySearch;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return index of B in array A, otherwise return -1
Constraints

1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are disitinct.
For Example

Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Output 1:
    0
Explanation 1:
 Target 4 is found at index 0 in A.


Input 2:
    A = [5, 17, 100, 3]
    B = 6
Output 2:
    -1
 */
/*
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class Search_in_rotated_sortArray {
	public static int search(final ArrayList<Integer> A, int target) {
		int start = 0;
		int end = A.size()-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
            if(A.get(mid)==target){
                return mid;
            }
			if(A.get(start)<=A.get(mid)) {
				//then left side is sorted
				if(target>=A.get(start) && target<=A.get(mid)) {
					end = mid;
				}
				else {
					start = mid+1;
				}
			}
			else {
				//right is sorted
				if(A.get(mid)<=target && target<=A.get(end)) {
					start = mid;
				}
				else {
					end = mid-1;
				}
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(search(A, 9));
		sf.close();
	}

}
