package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Spiral Order Matrix I
Asked in:  
Microsoft
JP Morgan
Amazon
Flipkart
Adobe
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]
Problem Approach :

Complete solution in the hints.
 */
/*
 * Check for better solution
 */
public class Spiral_print {
	public static ArrayList<Integer> spiralOrder(final ArrayList<ArrayList<Integer>> A) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = A.size()-1;
        int colEnd = A.get(0).size()-1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(rowStart<=rowEnd && colStart<=colEnd){
            //right
        	for (int i = colStart; i <=colEnd && rowStart<=rowEnd && colStart<=colEnd; i++) {
				ans.add(A.get(rowStart).get(i));
			}
        	rowStart++;
        	//down
        	for (int i = rowStart; i <=rowEnd && rowStart<=rowEnd && colStart<=colEnd; i++) {
				ans.add(A.get(i).get(colEnd));
			}
        	colEnd--;
        	//left
        	for (int i = colEnd; i >=colStart && rowStart<=rowEnd && colStart<=colEnd; i--) {
				ans.add(A.get(rowEnd).get(i));
			}
        	rowEnd--;
        	//up
        	for (int i = rowEnd; i >=rowStart && rowStart<=rowEnd && colStart<=colEnd; i--) {
        		ans.add(A.get(i).get(colStart));
			}
        	colStart++;
        }
        return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		Scanner sf  = new Scanner(System.in);
		int n = sf.nextInt();
		int col = sf.nextInt();
		for (int i = 0; i < n; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < col; j++) {
				matrix.get(i).add(sf.nextInt());
			}
		}
		System.out.println(spiralOrder(matrix));
		
	}

}
