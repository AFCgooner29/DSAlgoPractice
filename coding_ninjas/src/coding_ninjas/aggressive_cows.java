package coding_ninjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class aggressive_cows {
	/*
	 * 
Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows. 
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3 
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8, 
resulting in a minimum distance of 3.
	 */
	/*
	 * Approach using binary search we can guess some number
	 * using that number we will find if that can be the max min distance between the cows
	 * if that distance can be allocated then we set start = mid+1 to search for the max value
	 * is its not possible here then ans will be in end = mid-1
	 */
	public static boolean checker(ArrayList<Long> all_stalls,long dist,int cows) {
		long start = all_stalls.get(0);
		long cow_count =1;
		for(int i = 1;i<all_stalls.size();i++) {
			if(all_stalls.get(i)-start>=dist) {
				cow_count+=1;
				start = all_stalls.get(i);
			
			}
			if(cow_count==cows) {
				return true;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Long> al = new ArrayList<Long>();
		Scanner sf = new Scanner(System.in);
		int total = sf.nextInt();
		while(total>0) {
			al.clear();
			int no_of_stall = sf.nextInt();
			int no_of_cows = sf.nextInt();
			long max_dis = -1;
			
			for (int i = 0; i < no_of_stall; i++) {
				al.add(sf.nextLong());
			}
			if(no_of_stall==1) {
				System.out.println(0);
				return;
			}
			Collections.sort(al);
			long start = 0;
			long end = al.get(no_of_stall-1) - al.get(0);
			while(start<=end) { 
				long mid = start +(end-start)/2;
				if(checker(al, mid, no_of_cows)) {
					max_dis = mid;
					start=mid+1;
				}
				else {
					end = mid-1;
				}
				 
				  }
			 System.out.println(max_dis);
			 total--;
			 
			 }
		sf.close();
	}
	
	
	
	/*
	 * 
	 * 4 2
100000000
500000000
900000000
1
	 */

}
