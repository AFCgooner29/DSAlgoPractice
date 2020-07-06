package segement_tree;

import java.util.Scanner;
/*
 * Sum Of Squares
Send Feedback
Segment trees are extremely useful. In particular "Lazy Propagation" (i.e. see here, for example) allows one to compute sums over a range in O(lg(n)), and update ranges in O(lg(n)) as well. In this problem you will compute something much harder:
The sum of squares over a range with range updates of 2 types:
1) increment in a range
2) set all numbers the same in a range.
Input
There will be T (T <= 25) test cases in the input file. First line of the input contains two positive integers, N (N <= 100,000) and Q (Q <= 100,000). 
The next line contains N integers, each at most 1000. Each of the next Q lines starts with a number, which indicates the type of operation:

2 st nd -- return the sum of the squares of the numbers with indices in [st, nd] {i.e., from st to nd inclusive} (1 <= st <= nd <= N).

1 st nd x -- add "x" to all numbers with indices in [st, nd] (1 <= st <= nd <= N, and -1,000 <= x <= 1,000).

0 st nd x -- set all numbers with indices in [st, nd] to "x" (1 <= st <= nd <= N, and -1,000 <= x <= 1,000).
Output
For each test case output the “Case <caseno>:” in the first line and from the second line output the sum of squares for each operation of type 2. Intermediate overflow will not occur with proper use of 64-bit signed integer.
Input:
2
4 5
1 2 3 4
2 1 4
0 3 4 1
2 1 4
1 3 4 1
2 1 4
1 1
1
2 1 1
Output:
Case 1:
30
7
13
Case 2:
1
 */

//something is wrong in incrementing logic please check when to update the old values and when to override the old values +=
public class Sum_Of_Squares {
	public static void buildTree(int[] arr,long[][] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode][0] = arr[start]*arr[start];
			tree[treeNode][1] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode][0] = tree[2*treeNode][0]+tree[2*treeNode+1][0];
		tree[treeNode][1] = tree[2*treeNode][1]+tree[2*treeNode+1][1];
	}
	public static long query(long[][] tree,int start,int end,int treeNode,int idx,int idy) {
		if(start>idy || end<idx) {
			return 0;
		}
		else if(start>=idx && end<=idy) {
			return tree[treeNode][0];
		}
		int mid = (start+end)/2;
		long ans1 = query(tree, start, mid, 2*treeNode, idx, idy);
		long ans2 = query(tree, mid+1, end, 2*treeNode+1, idx, idy);
		return ans1+ans2;
	}
	public static void updateLazy(long[][] tree,long[][] lazy,int start,int end,int treeNode,int idx,int idy,int value,int type) {
		if(type==0) {//means to set leaf node to some given value
			if(lazy[treeNode][0]!=0) {
				tree[treeNode] = lazy[treeNode];
				
				if(start!=end) {
					lazy[2*treeNode] = lazy[treeNode];
					lazy[2*treeNode+1] = lazy[treeNode];
				}
				lazy[treeNode][0] = 0;
				lazy[treeNode][1] = 0;
			}
			if(start>idy || end<idx) {
				return;
			}
			else if(start>=idx && end<=idy) {
				tree[treeNode][0]=(idy-idx+1)*value*value;
				tree[treeNode][1]=(idy-idx+1)*value;
				return;
			}
			int mid = (start+end)/2;
			updateLazy(tree, lazy, start, mid, 2*treeNode, idx, idy, value, type);
			updateLazy(tree, lazy, mid+1, end, 2*treeNode+1, idx, idy, value, type);
			tree[treeNode][0] = tree[2*treeNode][0]+tree[2*treeNode+1][0];
			tree[treeNode][1] = tree[2*treeNode][1]+tree[2*treeNode+1][1];
		}
		else {
			if(lazy[treeNode][0]!=0) {
				tree[treeNode][0]+= lazy[treeNode][0];
				tree[treeNode][1]+= lazy[treeNode][1];
				
				if(start!=end) {
					lazy[2*treeNode] = lazy[treeNode];
					lazy[2*treeNode+1] = lazy[treeNode];
				}
				lazy[treeNode][0] = 0;
				lazy[treeNode][1] = 0;
			}
			if(start>idy || end<idx) {
				return;
			}
			else if(start>=idx && end<=idy) {
				tree[treeNode][0]+=(idy-idx+1)*value*value +2*value*tree[treeNode][1] + tree[treeNode][0];
				tree[treeNode][1]+=(idy-idx+1)*value;
				if(start!=end) {
					lazy[2*treeNode] = lazy[treeNode];
					lazy[2*treeNode+1] = lazy[treeNode];
				}
				return;
			}
			int mid = (start+end)/2;
			updateLazy(tree, lazy, start, mid, 2*treeNode, idx, idy, value, type);
			updateLazy(tree, lazy, mid+1, end, 2*treeNode+1, idx, idy, value, type);
			tree[treeNode][0] = tree[2*treeNode][0]+tree[2*treeNode+1][0];
			tree[treeNode][1] = tree[2*treeNode][1]+tree[2*treeNode+1][1];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test_case = sf.nextInt();
		for (int j = 1; j <= test_case; j++) {
			System.out.println("Case "+j+":");
			int n = sf.nextInt();
			int k = sf.nextInt();
			long[][] tree = new long[4*n][2];
			long[][] lazy = new long[4*n][2];
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sf.nextInt();
			}
			buildTree(arr, tree, 0, n-1, 1);
			
			for (int i = 0; i <k; i++) {
				int type = sf.nextInt();
				int idx1 = sf.nextInt();
				int idx2 = sf.nextInt();
				int value = 0;
				if(type!=2) {
					value = sf.nextInt();
				}
				if(type==2) {
					System.out.println(query(tree, 0, n-1, 1, idx1-1, idx2-1));
				}
				else {
					updateLazy(tree, lazy, 0, n-1, 1, idx1-1, idx2-1, value, type);
				}
			}
		}
		sf.close();
	}

}
