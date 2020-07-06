package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * Print concentric rectangular pattern in a 2d matrix.
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.
Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 */
public class PrettyPrint {
	public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		if(A==0) {
			return null;
		}
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < (2*A)-1; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < (2*A)-1; j++) {
				matrix.get(i).add(0);
			}
		}
		int rowmin =0;
		int rowmax =matrix.size()-1;
		int colmin = 0;
		int colmax = matrix.size()-1;
		while(A!=0){
			for (int i = colmin; i <=colmax; i++) {
				matrix.get(rowmin).set(i, A);
			}
			rowmin++;
			for (int i = colmin; i <=colmax; i++) {
				matrix.get(rowmax).set(i, A);
			}
			rowmax--;
			for (int i = rowmin; i <=rowmax; i++) {
				matrix.get(i).set(colmin, A);
			}
			colmin++;
			for (int i = rowmin; i <=rowmax; i++) {
				matrix.get(i).set(colmax, A);
			}
			colmax--;
			A--;
		}
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++) {
				System.out.print(matrix.get(i).get(j)+" ");
			}
			System.out.println();
		}
		return matrix;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prettyPrint(7);
	}

}
