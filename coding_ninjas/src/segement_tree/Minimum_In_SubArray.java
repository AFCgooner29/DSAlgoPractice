package segement_tree;

import java.util.Scanner;

/*
 * 
 * Range Minimum Query
Given an array A of size N, there are two types of queries on this array.
1) q l r: In this query you need to print the minimum in the sub-array A[l:r].
2) u x y: In this query you need to update A[x]=y.
Input:
First line of the test case contains two integers, N and Q, size of array A and number of queries.
Second line contains N space separated integers, elements of A.
Next Q lines contain one of the two queries.
Output:
For each type 1 query, print the minimum element in the sub-array A[l:r].
Contraints:
1≤N,Q,y≤10^5
1≤l,r,x≤N
Sample Input :
5 5
1 5 2 4 3
q 1 5
q 1 3
q 3 5
u 3 6
q 1 5
Sample Output :
1
1
2
1
 * 
 */
public class Minimum_In_SubArray {

	public static void buildMinSegtree(int[] arr,int[] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		buildMinSegtree(arr, tree, start, mid, 2*treeNode);
		buildMinSegtree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
	}
	public static void updateTree(int[] arr,int[] tree,int start,int end,int treeNode,int idx,int val) {
		if(start==end) {
			arr[idx] = val;
			tree[treeNode] = val;
			return;
		}
		int mid = (start+end)/2;
		if(idx>mid) {
			updateTree(arr, tree, mid+1, end, 2*treeNode+1, idx, val);
		}
		else {
			updateTree(arr, tree, start, mid, 2*treeNode, idx-1, val);
		}
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
	}
	public static int fetch(int[] tree,int start,int end,int treeNode,int left,int right) {
		//completely inside left and right
		if(start>=left && end<=right) {
			return tree[treeNode];
		}
		//not inside
		else if(start>right || end<left) {
			return Integer.MAX_VALUE;
		}
		//partially inside
		int mid = (start+end)/2;
		int ans1 = fetch(tree, start, mid, 2*treeNode, left, right);
		int ans2 = fetch(tree, mid+1, end, 2*treeNode+1, left, right);
		return Math.min(ans1, ans2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int k = sf.nextInt();
		int[] tree = new int[4*n];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		buildMinSegtree(arr, tree, 0, n-1, 1);
		for (int i = 0; i <k; i++) {
			String quer_type = sf.next();
			int idx1 = sf.nextInt();
			int idx2 = sf.nextInt();
			if(quer_type.equals("u")) {
				updateTree(arr, tree, 0, n-1, 1, idx1, idx2);
			}
			else {
				System.out.println(fetch(tree, 0, n-1, 1, idx1-1, idx2-1));
			}
		}
		sf.close();
	}

}
