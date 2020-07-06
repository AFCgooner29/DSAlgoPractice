package arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
 */
public class Max_unsorted_arr {
	public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < A.size()-1; i++) {
			
			if(A.get(i)>A.get(i+1)) {
				int L = i;
				int R = i++;
				int min = A.get(L);
				int last_R = R;
				int max = A.get(i);
				while(R<A.size()) {
					if(A.get(R)<max) {
						last_R = R;
					}
					max = Math.max(max, A.get(R));
					min = Math.min(min, A.get(R));
					R++;
				}
				//last_R--;
				while(L>=0 && A.get(L)>min) {
					L--;
				}
				L++;
				ans.add(L);
				ans.add(last_R);
				break;
			}
		}
		if(ans.isEmpty())ans.add(-1);
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(subUnsort(A));
		sf.close();
	}

}
