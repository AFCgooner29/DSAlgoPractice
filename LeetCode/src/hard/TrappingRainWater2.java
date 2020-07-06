package hard;
/*
 * 407. Trapping Rain Water II
Hard

1248

30

Add to List

Share
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.


The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.

 



After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

 

Constraints:

1 <= m, n <= 110
0 <= heightMap[i][j] <= 20000
 */
public class TrappingRainWater2 {
    public static int trapRainWater(int[][] heightMap) {
    	int[][] upmax = new int[heightMap.length][heightMap[0].length];
    	int[][] leftmax = new int[heightMap.length][heightMap[0].length];
    	int[][] downmax = new int[heightMap.length][heightMap[0].length];
    	int[][] rightmax = new int[heightMap.length][heightMap[0].length];
    	for (int j = 0; j < rightmax.length; j++) {
			for (int j2 = 0; j2 < rightmax[j].length; j2++) {
				upmax[j][j2] = Math.max(upmax[Math.max(0, j-1)][j2], heightMap[j][j2]);
				leftmax[j][j2] = Math.max(leftmax[j][Math.max(0, j2-1)], heightMap[j][j2]);
			}
		}
    	for (int j2 = rightmax[0].length-1; j2 >= 0; j2--) {
    		for (int j = rightmax.length-1; j >= 0; j--) {
    			rightmax[j][j2] = Math.max(heightMap[j][j2], rightmax[j][Math.min(j2+1, rightmax[0].length-1)]);
    			downmax[j][j2] =  Math.max(heightMap[j][j2],downmax[Math.min(j+1, rightmax.length-1)][j2]);
    		}
		}
    	int max=0;
    	for (int i = 1; i < rightmax.length-1; i++) {
			for (int j = 1; j < rightmax[i].length-1; j++) {
				int up = Math.min(upmax[i][j], downmax[i][j]);
				int lef = Math.min(leftmax[i][j], rightmax[i][j]);
				max+= Math.min(up, lef) - heightMap[i][j];
			}
		}
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
		trapRainWater(matrix);
	}

}
