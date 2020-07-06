package easy;
/*
 * Moore Voting algorithm to find Elemnt having N/2 majority
 * this looks like some mathematical thing to find the candidates
 */
public class Majority_Element1 {
	public static int find_cand(int[] arr) {
		int count = 1;//initialize first element count
		int max_idx = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[max_idx]==arr[i]) {
				count++;
			}
			else {
				count--;
			}
			if(count==0) {
				max_idx = i;
				count = 1;
			}
		}
		return max_idx;
	}
	public static int find_Winner(int[] arr) {
		int cand_idx = find_cand(arr);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==arr[cand_idx]) {
				count++;
			}
		}
		if(count>arr.length/2) {
			return arr[cand_idx];
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,2,4,2,5,2,2};
		System.out.println(find_Winner(arr));
	}

}
