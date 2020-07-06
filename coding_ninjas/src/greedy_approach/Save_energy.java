package greedy_approach;

import java.util.Scanner;

/*
 * There are N towns in a line, numbered from 0 to N - 1. Starting from town 0, we want to reach town N - 1. From town i, we can jump to any town j > i with an energy cost of (j-i)*A[i] + (j2 - i2)*A[i]2, where A[i] for all i are given in input.

Find the minimum total energy cost to reach town N - 1 from town 0.
Example 1

Input:
5
1 -1 2 2 2

Output:
14

 */
/*
 * Approach 
 * we can use dp and find the min cost required form one spot to reach last point
 * 
 * DP Approach won't work in this case as DP does not consider the cost of going from
 * first i to some intermidiate j and then reaching k
 * as we dont know at j the person decided to go through it of skipped it
 */

/*
 * We need to use greedy approach only
 * we are checking starting from 1 to n-1 which number
 * is smaller that current initial number and in case both have same absolute value
 * but initial is >0 then second one might be negative so its better to go throught negative 
 * number
 * chose that number and set that index to intial
 * then find a pair suiting this intial and above conditions
 * if n-1 is not found to be appropriate pair then 
 * find dist from initial to end so calculate this and add to cost
 */
public class Save_energy {
	public static long cost_finder(int i,int j, int[] cities) {
		return (long)((j-i)*cities[i] + (Math.pow(j,2) - Math.pow(i,2))*Math.pow(cities[i],2));
	}
	
	public static long dp_app(int[] cities,int n) {
		long[] dp = new long[n];
		dp[n-1] = 0;
		dp[n-2] = cost_finder(n-2,n-1, cities);
		for (int i = cities.length-3; i >=0; i--) {
			dp[i] = Math.min(cost_finder(i,n-1 ,cities), dp[i+1]);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}
		return dp[0];
	}
	public static long greedy_app(int[] cities,int n) {
		long cost = 0;
		int ini = 0;
		/*
		  while(ini<n-1) { 
			  int next = ini+1; 
			  while(next<n-1) {
				  if(Math.abs(cities[ini])>Math.abs(cities[next]) || (Math.abs(cities[ini])==Math.abs(cities[next]) &&
				  cities[ini]>0)) { 
					  break; 
					  } 
				  else {
					  next++;
				  }
				  }
			 // cost+=cost_finder(ini, next,cities); 
			  ini = next;
		  }
		*/
		for (int i = 1; i < cities.length; i++) {
			if(Math.abs(cities[ini])>Math.abs(cities[i]) || (Math.abs(cities[ini])==Math.abs(cities[i]) && cities[ini]>0)) {
				cost+=cost_finder(ini, i,cities);
				ini = i;
			}
		}
		cost+=cost_finder(ini, n-1,cities);
		return cost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] cities = new int[n];
		for (int i = 0; i < cities.length; i++) {
			cities[i] = sf.nextInt();
		}
		System.out.println(greedy_app(cities, n));
		//System.out.println(dp_app(cities, n));
		sf.close();
	}

}
