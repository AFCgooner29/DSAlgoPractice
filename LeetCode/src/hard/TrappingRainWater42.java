package hard;
/*
 * 42. Trapping Rain Water
Hard
https://leetcode.com/problems/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
/*
 * In first iteration we find left max for full array
 * In second iteration we find right max and we use left max to check what water it can hold
 */
public class TrappingRainWater42 {
    public static int trap(int[] height) {
    	int max=0;
        int[] total = new int[height.length];
        if(height.length==0) {
        	return max;
        }
        total[0] = height[0];
        for (int i = 1; i < height.length; i++) {
			total[i] = Math.max(height[i], total[i-1]);
		}
        int maxHere = height[total.length-1];
        for (int i = total.length-2; i >=0; i--) {
			maxHere = Math.max(height[i], maxHere);
			max+=Math.min(total[i],maxHere) - height[i];
		}
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] all = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(all));
	}

}
