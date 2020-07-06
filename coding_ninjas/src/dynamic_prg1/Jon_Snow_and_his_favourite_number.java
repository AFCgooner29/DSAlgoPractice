package dynamic_prg1;

import java.util.Scanner;

public class Jon_Snow_and_his_favourite_number {
	public static int[] finder(int[] arr,int k,int xor) {
		if(k==0) {
			return arr;
		}
		int[] temp = new int[1001];
		int elapsed = 0;
		for (int i = 0; i < temp.length; i++) {
			if(arr[i]>0) {
				int new_place = i^xor;
				if(arr[i]%2!=0 && elapsed%2==0) {
					temp[new_place]+=(arr[i]+1)/2;
					temp[i] = (arr[i]-1)/2; 
				}
				else if(arr[i]%2==0) {
					temp[new_place]+=(arr[i])/2;
					temp[i] = (arr[i])/2; 
				}
				else if(arr[i]%2!=0 && elapsed%2!=0) {
					temp[new_place]+=(arr[i]-1)/2;
					temp[i] = (arr[i]+1)/2;
				}
				elapsed+=arr[i];
			}
		}
		return finder(temp, k-1, xor);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int k = sf.nextInt();
		int x = sf.nextInt();
		int[] all = new int[n];
		for (int i = 0; i < all.length; i++) {
			all[i] = sf.nextInt();
		}
		/*
		Arrays.parallelSort(all);
		if(k%2!=0) {
			for (int i = 0; i < all.length; i=i+2) {
				all[i] = all[i]^x;
			}
		}
		Arrays.parallelSort(all);
		System.out.println(all[n-1]+" "+all[0]);
		*/
		int[] counter = new int[1024];
		for (int i = 0; i < all.length; i++) {
			counter[all[i]]++;
		}
		int[] ans = finder(counter, k, x);
		for (int i = ans.length-1; i >=0; i--) {
			if(ans[i]!=0) {
				System.out.print(i);
				break;
			}
		}
		System.out.print(" ");

		for (int i = 0; i < ans.length; i++) {
			if(ans[i]!=0) {
				System.out.print(i);
				break;
			}
		}
		sf.close();
	}

}
