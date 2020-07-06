package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 994. Rotting Oranges
Medium

1417

174

Add to List

Share
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 */
/*
 * Approach is using BFS
 * we create a class pair to track the level of traversal in BFS
 */
public class Rotten_Oranges {
	public static class pair{
		int x;
		int y;
		int lev;
		pair(int a,int b,int c){
			this.x = a;
			this.y = b;
			this.lev = c;
		}
	}
	
	public static int orangesRotting(int[][] grid) {
		Queue<pair> new_q = new LinkedList<pair>();
		HashMap<String, Integer> not_rotten = new HashMap<String, Integer>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]==2) {
					new_q.add(new pair(i,j,0));
				}
				if(grid[i][j]==1) {
					not_rotten.put(i+","+j,1);
				}
			}
		}
		int last_lev = 0;
		int[] movesX = {1,-1,0,0};
		int[] movesY = {0,0,1,-1};
		while(!new_q.isEmpty() && !not_rotten.isEmpty()) {
			pair curr = new_q.poll();
			last_lev = curr.lev;
			if(grid[curr.x][curr.y]==1) {
				not_rotten.remove(curr.x+","+curr.y);
				grid[curr.x][curr.y]=2;
			}
			for (int i = 0; i < movesY.length; i++) {
				if(curr.x+movesX[i]>=0 && curr.x+movesX[i]<grid.length && curr.y+movesY[i]>=0 && curr.y+movesY[i]<grid[0].length && grid[curr.x+movesX[i]][curr.y+movesY[i]]!=0 && grid[curr.x+movesX[i]][curr.y+movesY[i]]!=2) {
					new_q.add(new pair(curr.x+movesX[i], curr.y+movesY[i], curr.lev+1));
				}
			}
		}
		if(not_rotten.isEmpty())return last_lev;
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}

}
