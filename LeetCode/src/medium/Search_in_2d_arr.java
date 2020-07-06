package medium;
/*
 * 74. Search a 2D Matrix
Medium

1533

151

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
/*
 * Approach
 * we start from top right corner
 * if that value is less then we move to next row
 * if that value is greater then we check the row by decreasing column
 * repeat till found or return false
 */
/*
 * we can use binary search also
 */
public class Search_in_2d_arr {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        int m = matrix[n].length-1;
        while(true) {
        	if(n>=matrix.length || m<0) {
        		break;
        	}
        	if(matrix[n][m]==target) {
        		return true;
        	}
        	if(matrix[n][m]<target) {
        		//value at nm is less then we need to to next row
        		n++;
        	}
        	else {
        		m--;
        	}
        }
        return false;
    }
	public static boolean binsearMatrix(int[][] matrix, int target) {
		int start = 0;
		int end = matrix[0].length*matrix.length -1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			int mid_val = matrix[mid/matrix[0].length][mid%matrix[0].length];
			if(mid_val==target) {
				return true;
			}
			if(mid_val<target) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3,5,7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix, 12));
	}

}
