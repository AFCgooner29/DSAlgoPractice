package backtracking;

import java.util.Scanner;
/*
 * Adam likes to solve mathematical puzzles and riddles. He is quite good in them. But he is new to Sudoku, he never solved it before. Adam needs your help to solve Sudoku.

Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column, and sub grid of size 3×3 contains exactly one instance of the digits from 1 to 9.

Input
Input contains 9 lines of 9 space separated digits from 0 to 9(0 denotes an empty space).

Output
Output contains 9 lines of 9 space separated digits from 1 to 9 which represent solution of Sudoku.

Constraints
Already mentioned above

Example
Input:
  3 0 6 5 0 8 4 0 0
  5 2 0 0 0 0 0 0 0
  0 8 7 0 0 0 0 3 1
  0 0 3 0 1 0 0 8 0
  9 0 0 8 6 3 0 0 5
  0 5 0 0 9 0 6 0 0
  1 3 0 0 0 0 2 5 0
  0 0 0 0 0 0 0 7 4
  0 0 5 2 0 6 3 0 0


Output:
  3 1 6 5 7 8 4 9 2
  5 2 9 1 3 4 7 6 8
  4 8 7 6 2 9 5 3 1
  2 6 3 4 1 5 9 8 7
  9 7 4 8 6 3 1 2 5
  8 5 1 7 9 2 6 4 3
  1 3 8 9 4 7 2 5 6
  6 9 2 3 5 1 8 7 4
  7 4 5 2 8 6 3 1 9

 */

/*
 * plan is to do it recursively
 * checker function checks if the input digit(dig) can be placed at that position
 * after that we are running recursion till we get to last cell of board
 * if the current cell is not 0 then we move forward
 * else we check which number we can place, we place that number and move forward
 * to check all the possibilities
 * in the end assign the value to the board[8][8] in base case
 * this can be optimized by changing the checker funtion which will return only the strings
 * which can be placed on that x and y instead of checking all 9 numbers
 */

public class Sudoku {
	public static boolean valid_finder(int[][] board,int x,int y,int dig) {
		for (int i = 0; i < board.length; i++) {
			//this we are checking for row and column
			//this is better function than checker
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
	public static boolean checker(int[][] board,int x,int y,int dig) {
		for (int i = 0; i < board.length; i++) {
			if(board[x][i]==dig) {
				return false;		
			}
			if(board[i][y]==dig) {
				return false;
			}
		}
		if(x>=0 && x<=2) {
			if(y>=0 && y<=2) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else if(y>=3 && y<=5) {
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else {
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
		}
		else if(x>=3 && x<=5) {
			if(y>=0 && y<=2) {
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else if(y>=3 && y<=5) {
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else {
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 8; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
		}
		else {
			if(y>=0 && y<=2) {
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else if(y>=3 && y<=5) {
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
			else {
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						if(board[i][j]==dig) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	public static void sudoko(int[][] board,int x,int y) {
		if(x==board.length-1 && y==board.length-1) {
			for (int i = 1; i <= 9; i++) {
				if(checker(board, x, y, i)) {
					board[x][y]=i;
					break;
				}
			}
			//print the board
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println("");
			}
			return;
		}
		if(board[x][y]!=0) {
			if(y!=8) {
				sudoko(board, x, y+1);
			}
			else {
				sudoko(board, x+1, 0);
			}
		}
		else {
			for (int i = 1; i <= 9; i++) {
				if(checker(board, x, y, i)) {
					board[x][y]=i;
					if(y!=8) {
						sudoko(board, x, y+1);
					}
					else {
						sudoko(board, x+1, 0);
					}
					board[x][y]=0;
				}
			}
			if(board[x][y]==0) {
				return;
			}
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int[][] board = new int[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]=sf.nextInt();
			}
		}
		sudoko(board, 0, 0);
		sf.close();
		
	}

}
