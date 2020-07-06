package easy;

import java.util.Arrays;
import java.util.Comparator;

public class Two_City_Scheduling {
	public int twoCitySchedCost(int[][] costs) {
		for (int i = 0; i < costs.length; i++) {
			costs[i][0] = costs[i][0]-costs[i][1];
		}
		Arrays.parallelSort(costs,new Comparator<int[]>() {
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
		int tot_cost = 0;
		int num = 0;
		for (int i = 0; i < costs.length; i++) {
			if(num>=costs.length/2) {
				//send to 2nd place
				tot_cost+=costs[i][1];
			}
			else {
				tot_cost+=costs[i][0]+costs[i][1];
			}
			num++;
		}
		return tot_cost;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
