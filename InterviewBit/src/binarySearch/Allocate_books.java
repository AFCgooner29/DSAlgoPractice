package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 
Asked in:  
Google
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.



Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return that minimum possible number
Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^5
For Example

Input 1:
    A = [12, 34, 67, 90]
    B = 2
Output 1:
    113
Explanation 1:
    There are 2 number of students. Books can be distributed in following fashion : 
        1) [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2) [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
        3) [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

        Of the 3 cases, Option 3 has the minimum pages = 113.

Input 2:
    A = [5, 17, 100, 11]
    B = 4
Output 2:
    100
 */
/*
 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
 * we use binary search technique to find the min number of books we can allocate 
 */
public class Allocate_books {
	public static boolean isPosible(ArrayList<Integer> A, int max,int B) {
		int i = 0;
		int curr_sum =0;
		int no_of_s= 1;
		for(i=0;i<A.size();i++) {
			if(A.get(i)>max) {
				return false;
			}
			if(curr_sum+A.get(i)>max) {
				curr_sum = A.get(i);
				no_of_s++;
				if(no_of_s>B) {
					return false;
				}
			}
			else {
				curr_sum+=A.get(i);
			}
		}
		return true;
	}
	public static int books(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < A.size(); i++) {
			min = Math.min(min, A.get(i));
			max+=A.get(i);
		}
        int last_found = 0;
        while(min<=max) {
        	int mid = min + (max-min)/2;
        	if(isPosible(A, mid, B)) {
        		last_found = mid;
        		max = mid-1;
        	}
        	else {
        		min=mid+1;
        	}
        }
        return last_found;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(books(A, 5));
	}

}
