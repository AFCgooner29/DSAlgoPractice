package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 56. Merge Intervals
Medium

3615

263

Add to List

Share
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Merge_intervals56 {
	public static int[][] merge(int[][] intervals) {
		Arrays.parallelSort(intervals,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]<o2[0]) {
					return -1;
				}
				else if(o1[0]>o2[0]) {
					return 1;
				}
				return 0;
			}
		});
		int rem = 0;
		int i = 0;
		while(i<intervals.length-1) {
			if(intervals[i+1][0]<=intervals[i][1]) {
				int j = i+1;
				while(j<intervals.length && intervals[j][0]<=intervals[i][1]) {
					intervals[i][1] = Math.max(intervals[j][1],intervals[i][1]);
					intervals[j][0] = Integer.MAX_VALUE;
					j++;
					rem++;
				}
				i = j-1;
			}
			i++;
		}
		int[][] add = new int[intervals.length-rem][2];
		int j = 0;
		for (int k = 0; k < intervals.length; k++) {
			if(intervals[k][0]!=Integer.MAX_VALUE) {
				add[j]=intervals[k];
				j++;
			}
		}
		return add;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf  = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] nums = new int[n][2];
		for (int i = 0; i < nums.length; i++) {
			nums[i][0] = sf.nextInt();
			nums[i][1] = sf.nextInt();
		}
		merge(nums);
		sf.close();
	}

}
