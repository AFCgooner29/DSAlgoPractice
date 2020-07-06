package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Minimum Number of Chocolates
Send Feedback
Noor is a teacher. She wants to give some chocolates to the students in her class. All the students sit in a line and each of them has a score according to performance. Noor wants to give at least 1 chocolate to each student. She distributes chocolates to them such that If two students sit next to each other then the one with the higher score must get more chocolates. Noor wants to save money, so she wants to minimise the total number of chocolates.
Note that when two students have equal score they are allowed to have different number of chocolates.
Input Format:
First Line: Integer N, the number of students in Noor’s class. 
Second Line: Each of the student's score separated by spaces.
Output Format:
Output a single line containing the minimum number of chocolates Noor must give.
Input Constraints
 1 <= N <= 100000
 1 <= score <= 100000
Sample Input:
4
1 4 4 6
sample Output:
6
Sample Input:
3
8 7 5
sample Output:
6
 */

public class Minimum_Number_of_Chocolates {
	/*
	 * we write very interesting approach here
	 * whenever there are problems where you have to check front and behind elements of array
	 * and then decide something
	 * in that case first do optimal solution for checking front  and 0 to n
	 * then check back condition and change n to 0
	 */
	public static int getMin(int arr[], int N) {
		int[] choc_given = new int[N];
		choc_given[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>arr[i-1]) {
				choc_given[i] = choc_given[i-1]+1;
				//current is bigger than previos
			}
			/*
			 * else if(arr[i]<arr[i-1]) { //previos was bigger if(choc_given[i-1]==1) { for
			 * (int j = i-1; j >=0; j--) { choc_given[j]++; if(j==0 ||arr[j-1]<=arr[j]) {
			 * break; } } } choc_given[i] = 1;
			 * 
			 * }
			 */
			else {
				//both are equal
				choc_given[i] = 1;
			}
		}
		for (int i = choc_given.length-2; i >= 0; i--) {
			if(arr[i]>arr[i+1]) {
				if(choc_given[i]<=choc_given[i+1]) {
					choc_given[i] = choc_given[i+1]+1;
				}
				
			}
		}
		
		 //for (int i = 0; i < arr.length; i++) { System.out.println(choc_given[i]); }
		 
		return Arrays.stream(choc_given).sum();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		System.out.println(getMin(arr, N));
		sf.close();
	}

}
