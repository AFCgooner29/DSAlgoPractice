package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */
public class Set_matrix_zero {
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		boolean first_row = false;
		boolean first_col = false;
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).get(0)==0) {
				first_col = true;
				break;
			}
		}
		for (int i = 0; i < a.get(0).size(); i++) {
			if(a.get(0).get(i)==0) {
				first_row = true;
				break;
			}
		}
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).size(); j++) {
				if(a.get(i).get(j)==0) {
					a.get(0).set(j, 0);
					a.get(i).set(0, 0);
				}
			}
		}
		for (int j = 1; j < a.size(); j++) {
			if(a.get(j).get(0)==0) {
				//set everything 0 in innermatrix
				for (int i = 1; i < a.get(j).size(); i++) {
					a.get(j).set(i, 0);
				}
			}
		}
		for (int j = 1; j < a.get(0).size(); j++) {
			if(a.get(0).get(j)==0) {
				//set everything 0 in innermatrix
				for (int i = 1; i < a.size(); i++) {
					a.get(i).set(j, 0);
				}
			}
		}
		for (int i = 0; i < a.size() && first_col; i++) {
			a.get(i).set(0,0);
		}
		for (int i = 0; i < a.get(0).size() && first_row; i++) {
			a.get(0).set(i,0);
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		ArrayList<ArrayList<Integer>> arr= new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<Integer>());
			for (int j = 0; j < m; j++) {
				arr.get(i).add(sf.nextInt());
			}
		}
		setZeroes(arr);
		System.out.println(arr);
		sf.close();
	}

}
