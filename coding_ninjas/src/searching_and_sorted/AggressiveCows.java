package searching_and_sorted;

import java.util.Scanner;

/*
 * Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. 
The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each 
other once put into a stall. To prevent the cows from hurting each other, 
FJ wants to assign the cows to the stalls, such that the minimum distance between any 
two of them is as large as possible. What is the largest minimum distance?
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
public class AggressiveCows {
	public static boolean isPossible(int[] sheds,int space,int Cows) {
		int count = 1;
		int last_filled = sheds[0];
		for (int i = 0; i < sheds.length; i++) {
			if(sheds[i] - last_filled>=space) {
				last_filled = sheds[i];
				count++;		
			}
		}
		if(count>=Cows) {
			return true;
		}
		return false;
	}
	public static int finder(int NoOfStalls, int Cows,int[] sheds) {
		int start = 0;
		int end = NoOfStalls;
		int last_poss = start;
		while(start<end) {
			int mid = start + (end-start)/2;
			if(isPossible(sheds, mid, Cows)) {
				last_poss=mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return last_poss;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tests = sf.nextInt();
		for (int i = 0; i < tests; i++) {
			int[] sheds = {1,2,8,4,9};
			System.out.println(finder(sf.nextInt(), sf.nextInt(), sheds));
		}
		sf.close();
	}

}
