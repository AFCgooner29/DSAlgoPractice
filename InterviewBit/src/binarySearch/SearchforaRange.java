package binarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]
Seen this 
 */
public class SearchforaRange {
	public static ArrayList<Integer> searchRange(final ArrayList<Integer> A, int B) {
		int start = 0;
		int end = A.size()-1;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(-1);
		ans.add(-1);
		boolean isfound = false;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(A.get(mid)>B) {
				end = mid-1;
			}
			else if(A.get(mid)<B) {
				start = mid+1;
			}
			else {
				isfound = true;
				end = mid-1;
			}
		}
		if(!isfound) {
			return ans;
		}
		ans.set(0, end+1);
		start = 0;
		end = A.size()-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(A.get(mid)>B) {
				end = mid-1;
			}
			else if(A.get(mid)<B) {
				start = mid+1;
			}
			else {
				start = mid+1;
			}
		}
		ans.set(1, start-1);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(searchRange(A, sf.nextInt()));
		sf.close();
	}

}
