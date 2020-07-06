package advanced_recursion;

import java.util.Arrays;

public class merge_sort_code {
	public static int[] mergeSort(int[] input){
		// Write your code here
		if(input.length>1) {
			int mid = input.length /2;
			int[] L = mergeSort(Arrays.copyOfRange(input, 0, mid));
			int[] R = mergeSort(Arrays.copyOfRange(input, mid, input.length));
			int j=0,i=0,k=0;
			while(j<R.length && i<L.length) {
				if(L[i]<R[j]) {
					input[k]=L[i];
					i++;
					k++;
				}
				else {
					input[k]=R[j];
					j++;
					k++;
				}
			}
			while(i<L.length) {
				input[k]=L[i];
				i++;
				k++;
			}
			while(j<R.length) {
				input[k]=R[j];
				j++;
				k++;
			}
		return input;
		}
		return input;
	}
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp = {99,1,2,5,6,3};
		
		mergeSort(inp);
		printArray(inp);
	}

}
