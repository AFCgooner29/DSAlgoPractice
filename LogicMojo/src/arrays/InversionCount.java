package arrays;

public class InversionCount {
	static int inversions = 0; 
	public static void divide(int[] arr,int left,int right) {
		if(left==right)return;
		int mid = left + (right-left)/2;
		divide(arr, left, mid);
		divide(arr, mid+1, right);
		merge(arr,left,mid,right);
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int i = left;
		int j = mid+1;
		int k = 0;
		int[] temp = new int[right-left+1];
		while(i<mid+1 && j<right+1) {
			if(arr[i]<=arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				//inversion
				inversions+=(mid-i+1);
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i<mid+1) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (j<right+1) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		k=0;
		while(left<right+1) {
			arr[left] = temp[k];
			left++;
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {21,2,1,24,35,11,2,3,7,4};
		divide(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(inversions);
	}

}
