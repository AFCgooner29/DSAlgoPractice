package coding_ninjas;

import java.util.Arrays;
import java.util.Scanner;

public class atleast_difference {
	public static void n2checker(long[] arr,long k) {
		long count = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i; j < arr.length; j++) {
				if(Math.abs(arr[i]-arr[j])>=k) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void fastest_checker(long[] arr,long k) {
		Arrays.sort(arr);
		long count = 0;
		int start = 0;
		int end = start+1;
		while(start<arr.length-1) {
			long diff = Math.abs(arr[start]-arr[end]);
			if(diff>=k) {
				count+=arr.length-end;
				start++;
				end = start+1;
			}
			else {
				if(end==arr.length-1) {
					start++;
					end = start+1;
				}
				else {
					end++;
				}
				
			}
		}
		System.out.println(count);
			
	}
	
	public static void binary_checker(long[] arr,long k) {
		long count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int ans = arr.length ;
			int start = i+1;
			int end = arr.length-1;
			while(start<=end) {
				int mid = (start+end)/2;
				if(Math.abs(arr[i]-arr[mid])>=k) {
					end = mid-1;
					ans =mid;
				}
				else {
					start = mid+1;
				}
			}
			count+=arr.length - ans;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		long k = sf.nextLong();
		long[] ele = new long[tot];
		for (int i = 0; i < tot; i++) {
			ele[i]=sf.nextLong();
		}
		n2checker(ele, k);
		binary_checker(ele, k);
		fastest_checker(ele, k);
		sf.close();
	}

}
