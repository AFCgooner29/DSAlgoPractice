package arrays;

import java.util.ArrayList;

/*
 * Anti Diagonals
Asked in:  
Microsoft
Adobe
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]

Seen this question in a real interview before
 */
public class Anti_diagonals {
	public static ArrayList<Integer> getDiagonal(ArrayList<ArrayList<Integer>> A,int idx,int idy){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(idx<A.size() && idy>=0) {
			ans.add(A.get(idx).get(idy));
			idx++;
			idy--;
		}
		return ans;
	}
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.get(0).size(); i++) {
			ans.add(getDiagonal( A, 0, i));
		}
		for (int i = 1; i < A.size(); i++) {
			ans.add(getDiagonal( A, i, A.get(0).size()-1));
		}
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
