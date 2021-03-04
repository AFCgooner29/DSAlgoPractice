package arrays;

public class IncreasingandDecreasingArrMax {
	public static int helper(int[] arr) {
		int start = 0;
		int end  = arr.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			//first we need to realize where is the change in direction in array
			//we use property to check the left and right of mid element
			//if left is small and rigt is big go right
			//is left is small and right is also small we got ans
			//if left is big tright is small go left;
			int left = (mid == 0) ? arr[mid] : arr[mid-1];
			int right = (mid == arr.length-1) ? arr[mid] : arr[mid+1];
			if(left<=arr[mid] && right>=arr[mid]) {
				start = mid +1;
			}
			else if(left>=arr[mid] && right<=arr[mid]) {
				end = mid-1;
			}
			else {
				return arr[mid];
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,1,1,0};
		System.out.println(helper(arr));
	}

}
