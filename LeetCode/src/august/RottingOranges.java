package august;

import java.util.LinkedList;
import java.util.Queue;

/*
 * In a given grid, each cell can have one of three values:

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
public class RottingOranges {
	public static class pair{
		int x;
		int y;
		public pair(int a,int b) {
			this.x = a;
			this.y = b;
		}
	}
	public static int orangesRotting(int[][] grid) {
        Queue<pair> que = new LinkedList<pair>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]==2) {
					que.add(new pair(i,j));
				}
				else if(grid[i][j]==1) {
					count++;
				}
			}
		}
        int time = 0;
        while(!que.isEmpty() && count>0) {
        	int size = que.size();
        	boolean noRottenFound = true;
        	for (int i = 0; i < size; i++) {
        		pair temp = que.poll();
        		int[] x = {1,-1,0,0};
        		int[] y = {0,0,1,-1};
        		for (int j = 0; j < 4; j++) {
					if(temp.x+x[j]>-1 && temp.x+x[j]<grid.length && temp.y+y[j]>-1 && temp.y+y[j]<grid[0].length && grid[temp.x+x[j]][temp.y+y[j]]==1) {
						count--;
						noRottenFound = false;
						que.add(new pair(temp.x+x[j],temp.y+y[j]));
						grid[temp.x+x[j]][temp.y+y[j]] = 2;
					}
				}
			}
        	if(noRottenFound)break;
        	time++;
        }
        if(count==0) {
        	return time;
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}

}
