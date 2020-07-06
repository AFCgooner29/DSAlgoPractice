package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Max_abs_diff {
	public static int calculator(ArrayList<Integer> A,int x,int y) {
		return Math.abs(A.get(x)-A.get(y))+Math.abs(x-y);
	}
	public static int maxArr(ArrayList<Integer> A) {
		int x = 0;
		int y = x+1;
		int max = 0;
		while(x<A.size()-1) {
			if(y==A.size()) {
				x++;
				y = x+1;
				continue;
			}
			else {
				max = Math.max(calculator(A, x, y),max);
				y++;
			}
		}
		return max;
    }
	public static int fastermaxArr(ArrayList<Integer> A) {
		int min1 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		for (int i = 0; i < A.size(); i++) {
			min1 = Math.min(min1, A.get(i)+i);
			max1 = Math.max(max1, A.get(i)+i);
			min2 = Math.min(min2, A.get(i)-i);
			max2 = Math.max(max2, A.get(i)-i);
		}
		return Math.max(0, Math.max(max1-min1, max2-min2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(maxArr(A));
		System.out.println(fastermaxArr(A));
		sf.close();
	}

}
