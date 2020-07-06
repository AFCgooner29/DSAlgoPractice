package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
public class Dupli_in_arr {
	public static int repeated_num_const_mem(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			int temp = Math.abs(A.get(i));
			if(A.get(temp-1)<0) {
				return temp;
			}
			else {
				A.set(temp-1, -1*A.get(temp-1));
			}
		}
		return -1;
	}
	public int repeatedNumber(final ArrayList<Integer> A) {
        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.size(); i++) {
			if(hp.containsKey(A.get(i))) return A.get(i);
			hp.put(A.get(i), 1);
		}
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(repeated_num_const_mem(A));
		sf.close();
	}

}
