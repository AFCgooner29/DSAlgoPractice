package adhoc_problems;

import java.util.Scanner;

public class Sub_arr_with_given_sum {
	public static int finder(int[] arr,int sum_req) {
		int sum = 0;
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum = sum + arr[j];
				if(sum==sum_req) {
					counter++;
				}
			}
		}
		return counter;
	}
	public static int finder_n_approach(int[] arr,int sum_req) {
		int right = 0;
		int left  = 0;
		int curr_sum = arr[0];
		int counter = 0;
		while (left<arr.length && right<arr.length) {
			if(curr_sum==sum_req) {
				counter++;
				right++;
			}
			else if(curr_sum<sum_req) {
				right++;
				curr_sum+=arr[right];
			}
			else {
				left++;
				curr_sum-=arr[left-1];
			}
		}
		return counter;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		int sum_req = sf.nextInt();
		System.out.println(finder(arr, sum_req));
		System.out.println(finder_n_approach(arr, sum_req));
		sf.close();
	}

}
