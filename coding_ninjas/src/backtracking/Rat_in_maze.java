package backtracking;

import java.util.Scanner;


public class Rat_in_maze {
	public static void ratInAMaze(int maze[][]){
		
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
		r_in_m(maze,0,0);
		}
	public static void r_in_m(int maze[][],int x,int y) {
		if(x==maze.length-1 && y==maze.length-1) {
			//print the maze
			maze[x][y]=2;
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze.length; j++) {
					if(maze[i][j]==2) {
						System.out.print("1 ");
					}
					else {
						System.out.print("0 ");
					}
					
				}
							}
			System.out.println("");
			
			return;
		}
		if(maze[x][y]!=0 && maze[x][y]!=2) {			
			
				maze[x][y]=2;
				if(x!=0) {
					r_in_m(maze, x-1, y);
				}
				if(x!=maze.length-1) {
					r_in_m(maze, x+1, y);
				}
				if(y!=0) {
					r_in_m(maze, x, y-1);
				}
				if(y!=maze.length-1) {
					r_in_m(maze, x, y+1);
				}
				maze[x][y]=1;
				}
		
		return;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] maze=new int[n][n]; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j]=sf.nextInt();
			}
			
		}
		ratInAMaze(maze);
		sf.close();
	}

}
