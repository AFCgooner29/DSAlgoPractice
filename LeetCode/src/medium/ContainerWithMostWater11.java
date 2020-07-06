package medium;
/*
 * 11. Container With Most Water
Medium

6084

581

Add to List

Share
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater11 {
    public int maxArea1(int[] height) {
    	int max = 0;
        for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
			}
		}
        return max;
    }
    public int maxArea(int[] height) {
    	int max = 0;
    	int i=0;
    	int j=height.length-1;
        while (i<j) {
        	max = Math.max(max, (j-i)*Math.min(height[i], height[j]));
        	if(height[i]<height[j]) {
        		i++;
        	}
        	else {
        		j++;
        	}
		}
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
