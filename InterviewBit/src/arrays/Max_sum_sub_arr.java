package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Max_sum_sub_arr {
	public static int maxSubArray(final ArrayList<Integer> A) {
		int max_sum = Integer.MIN_VALUE;
		int curr_sum = 0;
		boolean is_all_neg = true;
		for (int i = 0; i < A.size(); i++) {
			if(A.get(i)>=0) {
				is_all_neg = false;
			}
			curr_sum += A.get(i);
			if(curr_sum<0) {
				curr_sum = 0;
			}
			max_sum = Math.max(max_sum, curr_sum);
		}
		if(is_all_neg) {
			return Collections.max(A);
		}
		return max_sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(maxSubArray(A));
		sf.close();
	}

}
