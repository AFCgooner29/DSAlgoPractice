package fenwick_tree;
/*
 * KQUERY
Send Feedback
Given a sequence of n numbers a1, a2, ..., an and a number of k- queries. A k-query is a triple (i, j, k) (1 ≤ i ≤ j ≤ n). For each k-query (i, j, k), you have to return the number of elements greater than k in the subsequence ai, ai+1, ..., aj.
Input Format
Line 1: n (1 ≤ n ≤ 30000).

Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^9).

Line 3: q (1 ≤ q ≤ 200000), the number of k- queries.

In the next q lines, each line contains 3 numbers i, j, k representing a k-query (1 ≤ i ≤ j ≤ n, 1 ≤ k ≤ 10^9).
Output Format
For each k-query (i, j, k), print the number of elements greater than k in the subsequence ai, ai+1, ..., aj in a single line.
Sample Input
5
5 1 2 3 4
3
2 4 1
4 4 4
1 5 2 
Sample Output
2
0
3 
 */
import java.util.Scanner;

public class KQUERY {
	public static void update_tree(int idx, int value, int[] BIT) {
		for (; idx < BIT.length; idx+= idx&(-idx)) {
			BIT[idx]++;
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
		Scanner sf  = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		int q = sf.nextInt();
		for (int i = 0; i < q; i++) {
			int start = sf.nextInt();
			int end = sf.nextInt();
			int k = sf.nextInt();
			int[] BIT = new int[(end-start)+2];
			int counter = 0;
			for (int j = start; j <=end; j++) {
				counter++;
				if(arr[j]>k) {
					update_tree(counter, 0, BIT);
				}
			}
			System.out.println(query(counter, BIT));
		}
		sf.close();
	}

}
