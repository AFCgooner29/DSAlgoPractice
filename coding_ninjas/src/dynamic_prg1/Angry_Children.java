package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;

public class Angry_Children {
	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		long[] packet = new long[n];
 		int k = sf.nextInt();
 		for (int i = 0; i < packet.length; i++) {
			packet[i] = sf.nextLong();
		}
 		Arrays.parallelSort(packet);
 		long tot_sum=0;
 		long min_cost = Long.MAX_VALUE;
 		long cost_curr = 0;
 		for (int i = 0; i < packet.length; i++) {
 			if(i<k) {
				if(i!=0) {
					cost_curr += i*packet[i] - tot_sum;
					if(i==k-1) {
						min_cost = Math.min(min_cost, cost_curr);
					}
				}
			}
			else {
				tot_sum-=packet[i-k];
				cost_curr = cost_curr - (tot_sum - (k-1)*packet[i-k]) + ((k-1)*packet[i] - tot_sum);
				min_cost = Math.min(min_cost, cost_curr);
			}
 			tot_sum+=packet[i];
		}
 		System.out.println(min_cost);
 		sf.close();
	}

	/* below is worst way of doing
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] dp = new int[n][n];
		int[] packet = new int[n];
 		int k = sf.nextInt();
 		for (int i = 0; i < packet.length; i++) {
			packet[i] = sf.nextInt();
		}
 		for (int i = 0; i < packet.length; i++) {
			for (int j = 0; j < packet.length; j++) {
				dp[i][j] = Math.abs(packet[i]-packet[j]);
			}
			Arrays.parallelSort(dp[i]);
		}
 		int[] selecter = new int[n];
 		Arrays.fill(selecter, 0);
 		//int min_num = Integer.MAX_VALUE;
 		//String min_indx = "";
 		int ans = 0;
 		for (int i = 0; i < selecter.length; i++) {
			for (int j = 0; j <k; j++) {
				selecter[i]+=dp[i][j];
			} /*
				 * if(selecter[i]<=min_num) { min_num = selecter[i]; ans = Math.max(ans,
				 * min_num); min_indx+=String.valueOf(i)+" " ; }
				 
		}
 		Arrays.parallelSort(selecter);
 		for (int i = 0; i < k; i++) {
			ans+=selecter[i];
		}
 		System.out.println(ans/2);
 		//System.out.println(min_indx);
 		sf.close();
	}*/

}
