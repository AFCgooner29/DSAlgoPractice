package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;

public class Hasan_and_Trip {
	// below solution not passing all test cases
	/*
	public static double dist(long[][] cities,int x,int xu) {
		double xer = Math.pow(cities[x][0]-cities[xu][0], 2);
		double yer = Math.pow(cities[x][1]-cities[xu][1], 2);
		return Math.sqrt(xer+yer);
	}
	public static double finder(long[][] cities,double[][] dp,double[] maxer,int x,int xfrom) {
		if(x == cities.length-1) {
			return cities[x][2] - dist(cities, x, xfrom);
		}
		double first = Double.NEGATIVE_INFINITY;
		for (int i = x+1; i < cities.length; i++) {
			
			  	if(dp[x][i]>Double.NEGATIVE_INFINITY) { 
			  			first = dp[x][i];
			  			maxer[0] = Math.max(maxer[0],first);
			  		} else {
			 
				first =  finder(cities, dp, maxer, i,x) - dist(cities, x, xfrom) + cities[x][2];
				maxer[0] = Math.max(maxer[0],first);
				}
			dp[x][i] = maxer[0];
		}
			return Math.max(maxer[0],first);
	}
	
	public static double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		long[][] cities = new long[n][3];
		for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < 3; j++) {
				cities[i][j] = sf.nextInt();
			}
		}
		double[] maxer =new double[1];
		maxer[0] = Double.NEGATIVE_INFINITY;
		double[][] dp = new double[n][n];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Double.NEGATIVE_INFINITY);	
		}
		maxer[0] = finder(cities, dp, maxer, 0, 0);
		System.out.println(String.format("%.6f",roundAvoid(maxer[0],6)));
		sf.close();
	}
	*/
	public static double roundAvoid(double value, int places) {
	    double scale = Math.pow(10, places);
	    return Math.round(value * scale) / scale;
	}
	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		long[][] cities = new long[n][3];
		for (int i = 0; i < cities.length; i++) {
			for (int j = 0; j < 3; j++) {
				cities[i][j] = sf.nextInt();
			}
		}
		double[] ans = new double[3001];
		Arrays.fill(ans,Double.NEGATIVE_INFINITY);
		sf.close();
		ans[0] = cities[0][2];
		for (int i = 1; i < n; ++i) {
			long x1 = cities[i][0];
			long y1 = cities[i][1];
		    for (int j = 0; j < i; ++j) {
		        long x2 = cities[j][0];
		        long y2 = cities[j][1];
		        ans[i] = Math.max(ans[i], ans[j] - Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
		    }
		    ans[i]+=cities[i][2];  
		}
		System.out.println(String.format("%.6f",roundAvoid(ans[n-1],6)));
	}
	
}
