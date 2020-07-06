package dynamic_prg1;

import java.util.Scanner;

/*
 * StairCase Problem
Send Feedback
A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return all possible number of ways.
Time complexity of your code should be O(n).
Input format :
Integer n (No. of steps)
Constraints :
n <= 70
Sample Input 1:
4
Sample Output 1:
7

 */
public class StairCase_Problem {
	public static long finder(int tot,long[] res,int start) {
		res[start] = res[start-1]+res[start-2]+res[start-3];
		if(start==tot-1) {
			return res[tot-1];
		}
		return finder(tot, res, start+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		if(tot<=3) {
			long[] res = new long[3];
			res[0] = 1;
			res[1] = 2;
			res[2] = 4;
			System.out.println(res[tot-1]);
			sf.close();
			return;
		}
		else {
			long[] res = new long[tot];
			res[0] = 1;
			res[1] = 2;
			res[2] = 4;
			System.out.println(finder(tot, res, 3));
		}

		
		sf.close();
	}

}
