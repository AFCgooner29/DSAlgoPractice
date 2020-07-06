package coding_ninjas;

import java.util.Arrays;

public class pair_sum_0 {
	public static void PairSum(int[] input, int size) {
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print the desired output and don't return anything.
	 	 * Taking input is handled automatically.
		 */
		//this approach is very slow
		Arrays.sort(input);
		for (int i = 0; i < input.length-1; i++) {
			for (int j = i+1; j < input.length; j++) {
				if(input[i]+input[j]==0) {
					System.out.println(input[i]+" "+input[j]);
				}
			}
		}
	}
	public static void PairSum_faster(int[] input,int size) {
		Arrays.sort(input);
		int l = 0;
		int r = input.length - 1;
		while(l<r) {
			if(input[l]+input[r]>0) {
				r-=1;
			}
			else if(input[l]+input[r]<0) {
				l+=1;
			}
			else {
				System.out.println(input[l]+" "+input[r]);
				r-=1;
			}
		}
		
		
	}

	public static void main(String[] args) {
		
		int[] arr = {2,1,-2,2,3};
		//PairSum(arr,arr.length);
		PairSum_faster(arr, arr.length);
	}

}
