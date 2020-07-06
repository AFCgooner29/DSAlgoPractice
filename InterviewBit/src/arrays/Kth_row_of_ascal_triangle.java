package arrays;

import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class Kth_row_of_ascal_triangle {
	public static int getFromParent(ArrayList<Integer> parent,int idx) {
		if(idx>=parent.size()) {
			return parent.get(idx-1);
		}
		else if(idx==0) {
			return parent.get(0);
		}
		else {
			return parent.get(idx)+parent.get(idx-1);
		}
	}
	public static ArrayList<Integer> getRow(int A) {
		ArrayList<Integer> prev = new ArrayList<Integer>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		if(A==0) {
			return curr;
		}
		curr.add(1);
		for (int i = 2; i <=A; i++) {
			prev = curr;
			curr = new ArrayList<Integer>();
			for (int j = 0; j <i; j++) {
				curr.add(0);
				curr.set(j, getFromParent(prev, j));
			}
		}
		return curr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(5));
	}

}
