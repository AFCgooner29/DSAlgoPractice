package segement_tree;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Horrible Queries
Send Feedback
World is getting more evil and it's getting tougher to get into the Evil League of Evil. Since the legendary Bad Horse has retired, now you have to correctly answer the evil questions of Dr. Horrible, who has a PhD in horribleness (but not in Computer Science). You are given an array of N elements, which are initially all 0. After that you will be given C commands. They are -
0 p q v - you have to add v to all numbers in the range of p to q (inclusive), where p and q are two indexes of the array.

1 p q - output a line containing a single integer which is the sum of all the array elements between p and q (inclusive)
Input
In the first line you'll be given T, number of test cases.

Each test case will start with N (N <= 100 000) and C (C <= 100 000). After that you'll be given C commands in the format as mentioned above. 1 <= p, q <= N and 1 <= v <= 10^7.
Output
Print the answers of the queries.
Input:
1
8 6
0 2 4 26
0 4 8 80
0 4 5 20
1 8 8 
0 5 7 14
1 4 8
Output:
80  
508



We are constructing both lazy and tree together
 */
public class Horrible_Queries {
	public static long query(long[][] tree,int start,int end,int treeNode,int x,int y) {
		
		if(tree[treeNode][1]!=0) {//we added this because while updateLazy we are not setting
			//lazy value to the lower nodes so if query comes for lower nodes then the value returned
			//will not be latest updated values so we should update the values while query also3
			tree[treeNode][0]+=(tree[treeNode][1]*(end-start+1));
			if(start!=end) {
				//update the child also
				tree[2*treeNode][1]+=tree[treeNode][1];
				tree[2*treeNode+1][1]+=tree[treeNode][1];
			}
			tree[treeNode][1] = 0;
		}
		
		if(start>y || end<x) {
			return 0;
		}
		else if(start>=x && end<=y) {
			if(tree[treeNode][1]==0) {
				return tree[treeNode][0];
			}
			else {
				return tree[treeNode][0] + (tree[treeNode][1]*(end-start+1));
			}
		}
		int mid = (start+end)/2;
		long ans1 = query(tree, start, mid, 2*treeNode, x, y);
		long ans2 = query(tree, mid+1, end, 2*treeNode+1, x, y);
		return ans1+ans2;
	}
	public static void updateLazy(long[][] tree,int start,int end,int treeNode,int x,int y,long value) {
		if(tree[treeNode][1]!=0) {
			tree[treeNode][0]+=(tree[treeNode][1]*(end-start+1));
			if(start!=end) {
				//update the child also
				tree[2*treeNode][1]+=tree[treeNode][1];
				tree[2*treeNode+1][1]+=tree[treeNode][1];
			}
			tree[treeNode][1] = 0;
		}
		//no overlap
		if(start>y || end<x) {
			return;
		}
		else if(start>=x && end<=y) {
			tree[treeNode][0]+=(value*(end-start+1));
			if(start!=end) {
				//update the child also
				tree[2*treeNode][1]+=value;
				tree[2*treeNode+1][1]+=value;
			}
			return;
		}
		int mid = (start+end)/2;
		updateLazy(tree, start, mid, 2*treeNode, x, y, value);
		updateLazy(tree, mid+1, end, 2*treeNode+1, x, y, value);
		tree[treeNode][0] = tree[2*treeNode][0] + tree[2*treeNode+1][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test_cases = sf.nextInt();
		for (int i = 0; i < test_cases; i++) {
			int n = sf.nextInt();
			int q = sf.nextInt();
			long[][] tree = new long[4*n][2];
			for (int j = 0; j < tree.length; j++) {
				Arrays.fill(tree[j], 0);
			}
			for (int j = 0; j < q; j++) {
				int query_type  = sf.nextInt();
				int x = sf.nextInt();
				int y = sf.nextInt();
				int val = 0;
				if(query_type==0) {
					val = sf.nextInt();
					updateLazy(tree, 0, n-1, 1, x-1, y-1, val);
				}
				else {
					System.out.println(query(tree, 0, n-1, 1, x-1, y-1));
				}
				
			}
		}
		sf.close();
	}

}
