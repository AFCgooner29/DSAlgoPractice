package fenwick_tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Distinct Query Problem
Send Feedback
Given a sequence of n numbers a1, a2, ..., an and a number of d-queries. A d-query is a pair (i, j) (1 ≤ i ≤ j ≤ n). For each d-query (i, j), you have to return the number of distinct elements in the subsequence ai, ai+1, ..., aj.
Input
Line 1: n (1 ≤ n ≤ 30000).
Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^6).
Line 3: q (1 ≤ q ≤ 200000), the number of d-queries.
In the next q lines, each line contains 2 numbers i, j representing a d-query (1 ≤ i ≤ j ≤ n).
Output
For each d-query (i, j), print the number of distinct elements in the subsequence ai, ai+1, ..., aj in a single line.
Sample Input
5
1 1 2 1 3
3
1 5
2 4
3 5
Sample Output
3
2
3 
 */
public class Distinct_qry_prblm {
	public static void update_tree(int idx, int value, int[] BIT,HashMap<Integer, HashMap<Integer, Integer>> hp) {
		for (; idx < BIT.length; idx+= idx&(-idx)) {
			if(hp.containsKey(idx)) {
				if(!hp.get(idx).containsKey(value)) {
					hp.get(idx).put(value, 1);
					BIT[idx]++;
				}
			}
			else {
				hp.put(idx, new HashMap<Integer, Integer>());
				hp.get(idx).put(value, 1);
			}
		
		}
	}
	public static int query(int idx, int[] BIT) {
		int ans = 0;
		for (; idx > 0; idx-= idx&(-idx)) {
			ans+=BIT[idx];
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n+1];
		int[] BIT = new int[n+1];
		Arrays.fill(BIT, 0);
		HashMap<Integer, HashMap<Integer, Integer>> hp = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 1; i <=n; i++) {
			arr[i] = sf.nextInt();
			update_tree(i, arr[i], BIT, hp);
		}
		
		int q = sf.nextInt();
		for (int i = 0; i <q; i++) {
			int start = sf.nextInt();
			int end = sf.nextInt();
			System.out.println(query(end, BIT)-query(start-1, BIT));
		}
		sf.close();
	}

}
