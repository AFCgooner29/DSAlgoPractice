package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
Asked in:  
Model N
InMobi
Amazon
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
 */
public class First_missing_integer {
	public static int firstMissingPositive(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			if(A.get(i)<1) {
				A.set(i, Integer.MAX_VALUE);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			
				int idx = Math.abs(A.get(i))-1;
				if(idx>=A.size()) {
					continue;
				}
				int val = Math.abs(A.get(idx));
				A.set(idx, -1*val);
		}
		for (int i = 0; i < A.size(); i++) {
			if(A.get(i)>0) {
				return i+1;
			}
		}
		return A.size()+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(sf.nextInt());
		}
		System.out.println(firstMissingPositive(arr));
		sf.close();
	}

}
