package dynamic_prg1;

import java.util.Arrays;

/*
 * This program is to find longest increasing subsequence
 */
public class Longes_inc_sub_seq {
	public static int finder(int[] arr,int[] res,int pivot) {
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
			return Arrays.stream(res).max().getAsInt();
		}
		return finder(arr,res,pivot+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,9,1,3,4,6,7};
		int[] res = new int[arr.length];
		System.out.println(finder(arr, res,0));
	}

}
