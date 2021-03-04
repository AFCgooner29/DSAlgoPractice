package arrays;

import java.util.Arrays;

public class MinRailwayPlatforms {
	/**
	 * 
	 * @param arrival
	 * @param departure
	 * @return the max number of Platform needed
	 */
	public static int minimumNumberOfPlatform(int arrival[], int departure[]) {
		Arrays.parallelSort(arrival);
		Arrays.parallelSort(departure);
		int max = 0;
		int currTrains = 0;
		int i = 0;
		int j = 0;
		while(i<arrival.length && j<departure.length) {
			if(arrival[i]<departure[j]) {
				currTrains++;
				i++;
			}
			else if(departure[i]<arrival[i]) {
				currTrains--;
				j++;
			}
			else {
				i++;
				j++;
			}
			max = Math.max(max, currTrains);
		}
		return max;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
