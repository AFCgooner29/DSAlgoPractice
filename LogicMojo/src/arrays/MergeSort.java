package arrays;

import java.util.Arrays;

public class MergeSort {
	public static int[] mergeSort(int[] arr) {
		if(arr.length<2)return arr;
		int mid = arr.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		if(right==null)return left;
		if(left==null)return right;
		return merge(left,right);
	}
	private static int[] merge(int[] left, int[] right) {
		int i=0,j=0,k=0;
		int[] ret = new int[left.length+right.length]; 
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				ret[k] = left[i];
				i++;
				k++;
			}
			else {
				ret[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<left.length) {
			ret[k] = left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			ret[k] = right[j];
			j++;
			k++;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,12,1,2,4,7,421,2};
		for(int i :mergeSort(arr)) {
			System.out.println(i);
		}
	}

}
