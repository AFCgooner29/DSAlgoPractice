package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Loot Houses
Send Feedback
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
Input Format
Line 1 : An integer N 
Line 2 : N spaced integers denoting money in each house
Output Format
 Line 1 : Maximum amount of money looted
Input Constraints
1 <= n <= 10^4
1 <= A[i] < 10^4
Sample Input :
6
5 5 10 100 10 5
Sample Output 1 :
110
 */
public class Loot_Houses {
	public static int getMaxMoneys(int arr[], int n,int[] loot){
		/*
		 * Here we are setting the last and second last and third last entry in loot array
		 * if there is only one house to loot i.e. last one then max loot is equal to
		 * the value of house, same goes for second last house as consecutive houses can't be looted
		 * so for the rest of the houses loot can be found using looping over all the remaining
		 * houses apart from consectuive one whatever max loot can be gathered that will be picked and 
		 * call the function on n-1
		 * then we find the max of loot array
		 */
 		
		if(n==0) {
			return Arrays.stream(loot).max().getAsInt();
		}
		else if(n==arr.length || n==arr.length-1) {
			if(loot[n-1]>0) {
				return loot[n-1];
			}
			loot[n-1] = arr[n-1];
			return getMaxMoneys(arr, n-1, loot);
		}
		else if(n==arr.length-2) {
			if(loot[n-1]>0) {
				return loot[n-1];
			}
			loot[n-1] = arr[n-1]+loot[n+1];
			return getMaxMoneys(arr, n-1, loot);
		}
		int max_loot = 0;
		for (int i = n+2; i < loot.length; i++) {
			int looter = 0 ;
			if(loot[i-1]>0) {
				looter = loot[i-1] + arr[n-1];
			}
			else {
				looter = getMaxMoneys(arr, i, loot) + arr[n-1];
			}
			if(max_loot<looter) {
				max_loot = looter;
			}
		}
		loot[n-1] = max_loot; 
		return getMaxMoneys(arr, n-1, loot);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf =new Scanner(System.in);
		int tot = sf.nextInt();
		int[] arr = new int[tot];
		int[] loot = new int[tot];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		System.err.println(getMaxMoneys(arr, tot, loot));
		sf.close();
	}

}
