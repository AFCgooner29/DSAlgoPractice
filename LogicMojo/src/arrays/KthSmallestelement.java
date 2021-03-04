package arrays;

import java.util.Arrays;

public class KthSmallestelement {
	public static int helper(int[] arr,int left,int right,int k) {
		if(left==right) {
			return arr[left];
		}
		int pivot = arr[right];
		int i = left;
		int j = right-1;
		while(i<j) {
			while(i<j && arr[i]<pivot)i++;
			while(i<j && arr[j]>=pivot)j--;
			if(i<j)
				swap(arr,i,j);
		}
		swap(arr,j,right);
		
		if(j+1>k) {
			return helper(arr, left, j-1, k);
		}
		else {
			return helper(arr, j+1, right, k);
		}
	}
	public static void swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  arr = {1,5,12,1,23,4,5,6,12,3,53,234,23,54,123,2,6,62,2,2321,21,3,341};
		int k = 12;
		System.out.println(helper(arr, 0, arr.length-1, k));
		Arrays.parallelSort(arr);
		System.out.println(arr[k-1]);
	}

}
