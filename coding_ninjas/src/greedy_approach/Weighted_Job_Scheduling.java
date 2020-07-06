package greedy_approach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * Weighted Job Scheduling
Send Feedback
You are given N jobs where every job is represented as:
1.Start Time
2.Finish Time
3.Profit Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
Input
The first line of input contains one integer denoting N.
Next N lines contains three space separated integers denoting the start time, finish time and the profit associated with the ith job. 
Output
Output one integer, the maximum profit that can be achieved.
Constraints
1 ≤ N ≤ 10^6
1 ≤ ai, di, p ≤ 10^6
Sample Input
4
3 10 20
1 2 50
6 19 100
2 100 200
Sample Output
250
 */
public class Weighted_Job_Scheduling {
	public static int bsearch(int[][] jobs, int start, int end, int j) {
		/*
		 * if(end<start) { return -1; } if(start==end) { return end; } int mid =
		 * (start+end)/2; if(jobs[mid][1]<=jobs[j][0]) { return bsearch(jobs, mid+1,
		 * end, j); } else { return bsearch(jobs, start, mid-1, j); }
		 */
		int last_found = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (jobs[mid][1] <= jobs[j][0]) {
				start = mid + 1;
				last_found = mid;
			} else {
				end = mid - 1;
			}
		}
		return last_found;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[][] jobs = new int[tot][3];
		for (int i = 0; i < tot; i++) {
			jobs[i][0] = sf.nextInt();
			jobs[i][1] = sf.nextInt();
			jobs[i][2] = sf.nextInt();
		}
		Arrays.parallelSort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				}
				return 0;
			}
		});
		int[] max = new int[tot];// this will store max profit that can be generated at ith point
		max[0] = jobs[0][2];
		for (int i = 1; i < jobs.length; i++) {
			int val = jobs[i][2];
			int fin = bsearch(jobs, 0, i - 1, i);
			//System.out.println(fin);
			if (fin != -1) {
				val = val + max[fin];
			}

			/*
			 * for (int j = i - 1; j >= 0; j--) {
			 * 
			 * if (jobs[j][1] <= jobs[i][0]) { //System.out.println(j); val = val + max[j];
			 * break; } }
			 */

			max[i] = Math.max(val, max[i - 1]);
		}
		System.out.println(max[tot - 1]);
		sf.close();
	}

}
