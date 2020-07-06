package backtracking_mergesort_assignment;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Sudoku Solver
Send Feedback
Given a 9*9 sudoku board, in which some entries are filled and others are 0 (0 indicates that the cell is empty), you need to find out whether the Sudoku puzzle can be solved or not i.e. return true or false.
Input Format :
9 Lines where ith line contains ith row elements separated by space
Output Format :
 true or false
Sample Input :
9 0 0 0 2 0 7 5 0 
6 0 0 0 5 0 0 4 0 
0 2 0 4 0 0 0 1 0 
2 0 8 0 0 0 0 0 0 
0 7 0 5 0 9 0 6 0 
0 0 0 0 0 0 4 0 1 
0 1 0 0 0 5 0 8 0 
0 9 0 0 7 0 0 0 4 
0 8 2 0 4 0 0 0 6
Sample Output :
true
 */
public class Sudoku_solver {
	public static ArrayList<Integer> valid_finder_options(int[][] board,int x,int y) {
		int[] ans = {0,1,2,3,4,5,6,7,8,9};
		for (int i = 0; i < board.length; i++) {
			//this we are checking for row and column
			ans[board[x][i]] = 0;
			ans[board[i][y]] = 0;
		}
		int xlow = x - x%3;
		int xup = x + (2-x%3);
		int ylow = y - y%3;
		int yup = y + (2-y%3);
		for (int i = xlow; i <= xup; i++) {
			for (int j = ylow; j <=yup; j++) {
				ans[board[i][j]]=0;
			}
		}
		ArrayList<Integer> anss = new ArrayList<Integer>();
		for (int i = 0; i < ans.length; i++) {
			if(ans[i]!=0) {
				anss.add(ans[i]);
			}
		}
		return anss;
	}
	public static boolean valid_finder(int[][] board,int x,int y,int dig) {
		for (int i = 0; i < board.length; i++) {
			//this we are checking for row and column
			if(board[x][i]==dig) {
				return false;
			}
			if(board[i][y]==dig) {
				return false;
			}
		}
		//now we have to check all the 3x3 grids
		int xlow = x - x%3;
		int xup = x + (2-x%3);
		int ylow = y - y%3;
		int yup = y + (2-y%3);
		for (int i = xlow; i <= xup; i++) {
			for (int j = ylow; j <=yup; j++) {
				if(board[i][j]==dig) {
					return false;
				}
			}
		}
		return true;
	}
	public static void solver(int[][] board,int x,int y,int[] issolved) {
		if(x==8 && y==8) {
			issolved[0] = 1;
			return;
		}
		if(board[x][y]!=0) {
			if(y<8) {
				solver(board, x, y+1,issolved);
			}
			else {
				solver(board, x+1, 0,issolved);
			}
		}
		else {
			ArrayList<Integer> valid_nums = valid_finder_options(board, x, y);
			if(valid_nums.isEmpty()) {
				return;
			}
			else {
				for (int i = 0; i < valid_nums.size(); i++) {
					board[x][y] = valid_nums.get(i);
					if(y<8) {
						solver(board, x, y+1,issolved);
					}
					else {
						solver(board, x+1, 0,issolved);
					}
					board[x][y] = 0;
				}
			}
			//trying faster approach by not checking all numbers from 0 to 9
			//below was old approach
//			for (int i = 1; i <=9; i++) {
//				if(valid_finder(board, x, y, i)) {
//					board[x][y] = i;
//					if(y<8) {
//						solver(board, x, y+1,issolved);
//					}
//					else {
//						solver(board, x+1, 0,issolved);
//					}
//					board[x][y] = 0;
//				}
//			}
			
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int[][] board = new int[9][9];
		int[] issolved = {0};
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]=sf.nextInt();
			}
		}
		solver(board, 0, 0,issolved);
		if(issolved[0]==1) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		sf.close();
	}

}
