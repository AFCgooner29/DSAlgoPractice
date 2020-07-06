package arrays;

import java.util.ArrayList;

/*
 * Pascal Triangle
Asked in:  
Google
Amazon
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details. 
Seen this question in a real interview before
 */
public class Pascal_triangle {
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
	public static ArrayList<ArrayList<Integer>> solve(int A) {
		ArrayList<ArrayList<Integer>> ans  =  new ArrayList<ArrayList<Integer>>(A);
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(1);
		ans.add(in);
		for (int i = 1; i <A; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j <=i; j++) {
				temp.add(0);
			}
			for (int j = 0; j < temp.size(); j++) {
				temp.set(j, getFromParent(ans.get(i-1), j));
			}
			ans.add(temp);
		}
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5));
	}

}
