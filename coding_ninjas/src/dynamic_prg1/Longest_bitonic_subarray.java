package dynamic_prg1;

import java.util.Scanner;

/*
 * Largest Bitonic Subarray
Send Feedback
You are given an array of positive integers as input. Write a code to return the length of the largest such subsequence in which the values are arranged first in strictly ascending order and then in strictly descending order.
Such a subsequence is known as bitonic subsequence. A purely increasing or purely decreasing subsequence will also be considered as a bitonic sequence with the other part empty.
Note that the elements in bitonic subsequence need not be consecutive in the given array but the order should remain same.
Input Format:
Line 1 : A positive Integer N, i.e., the size of array
Line 2 : N space-separated integers as elements of the array 
Output Format:
Length of Largest Bitonic subsequence
Input Constraints:
1<= N <= 100000
Sample Input 1:
6
15 20 20 6 4 2
Sample Output 1:
5
Sample Output 1 Explanation:
Here, longest Bitonic subsequence is {15, 20, 6, 4, 2} which has length = 5.
Sample Input 2:
2
1 5
Sample Output 2:
2
Sample Input 3:
2
5 1
Sample Output 3:
2
 */
public class Longest_bitonic_subarray {
	public static void finder(int[] arr,int[] res,int pivot) {
		if(pivot==0) {
			res[0] = 1;
		}
		else {
			for (int i = pivot-1; i >= 0; i--) {
				if(arr[i]<arr[pivot] && res[i]>=res[pivot]) {
					res[pivot] = res[i]+1;
				}
			}
		}
		if(pivot==arr.length-1) {
			return;
		}
		finder(arr,res,pivot+1);
		
	}
	public static void finder_rev(int[] arr,int[] res,int pivot) {
		if(pivot==arr.length-1) {
			res[pivot] = 1;
		}
		else {
			for (int i = pivot+1; i < arr.length; i++) {
				if(arr[i]<arr[pivot] && res[i]>=res[pivot]) {
					res[pivot] = res[i]+1;
				}
			}
		}
		if(pivot==0) {
			return;
		}
		finder_rev(arr,res,pivot-1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[] arr = new int[tot];
		int[] res_i = new int[tot];
		int[] res_d = new int[tot];
		
		for (int i = 0; i < tot; i++) {
			arr[i] = sf.nextInt();
			res_i[i] = 1;
			res_d[i] = 1;
		}
		finder(arr, res_i, 0);
		finder_rev(arr, res_d,arr.length-1);
		int max = 0;
		for (int i = 0; i < res_d.length; i++) {
			 if(max<res_d[i]+res_i[i]-1) { max = res_d[i]+res_i[i]-1; }
					}
		System.out.println(max);
		sf.close();
	}

}
