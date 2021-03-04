package arrays;

public class SortArrayOf012 {
	public static void helper(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		int mid = 0;
		while(mid<=j) {
			if(arr[mid] == 0) {
				swap(arr, mid, i);
				mid++;
				i++;
			}
			else if (arr[mid]==2) {
				swap(arr, mid, j);
				mid++;
				j--;
			}
			else {
				mid++;
			}
		}
		
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,2,2,2,2,1,1,1,1,0,0,0,0};
		helper(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}

}
