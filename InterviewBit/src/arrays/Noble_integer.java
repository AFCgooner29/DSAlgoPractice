package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Noble Integer
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */
public class Noble_integer {
	public static boolean isNoble(ArrayList<Integer> A,int idx) {
		int num = A.get(idx);
		int rem = A.size()-(idx+1);
		if(num==rem) {
			return true;
		}
		return false;
	}
	public static void remDupli(ArrayList<Integer> A) {
		Set<Integer> S = new LinkedHashSet<Integer>();
		S.addAll(A);
		A.clear();
		A.addAll(S);
	}
	public static int solve(ArrayList<Integer> A) {
		//remDupli(A);
		Collections.sort(A);
		int start = 0;
		int end = A.size()-1;
		while(start<=end) {
			int mid = (start+end);
			if(mid!=A.size()-1 && A.get(mid+1)!=A.get(mid)&&isNoble(A, mid)) {
				return 1;
			}
			else if(A.get(mid)>A.size()-(mid+1)) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(solve(A));
	}

}
