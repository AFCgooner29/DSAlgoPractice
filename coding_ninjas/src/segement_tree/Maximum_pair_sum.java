package segement_tree;

import java.util.Scanner;
/*
 * Maximum Pair Sum
Send Feedback
You are given a sequence A[1], A[2], ..., A[N], ( 0 ≤ A[i] ≤ 10^8 , 2 ≤ N ≤ 10^5 ). There are two types of operations and they are defined as follows:
Update:
This will be indicated in the input by a 'U' followed by space and then two integers i and x.
U i x, 1 ≤ i ≤ N, and x, 0 ≤ x ≤ 10^8.
This operation sets the value of A[i] to x.
Query:
This will be indicated in the input by a 'Q' followed by a single space and then two integers i and j.
Q x y, 1 ≤ x < y ≤ N.
You must find i and j such that x ≤ i, j ≤ y and i != j, such that the sum A[i]+A[j] is maximized. Print the sum A[i]+A[j].
Input
The first line of input consists of an integer N representing the length of the sequence. 
Next line consists of N space separated integers A[i]. Next line contains an integer Q, Q ≤ 10^5, representing the number of operations. Next Q lines contain the operations.
Output
 Output the maximum sum mentioned above, in a separate line, for each Query.
 */
public class Maximum_pair_sum {
	public static void buildTree(int[] arr,int[][] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode][1] = Integer.MIN_VALUE; //this contains second max
			tree[treeNode][0] = arr[end];   //this contains max element
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode][0] = Math.max(tree[2*treeNode+1][0], tree[2*treeNode][0]);
		tree[treeNode][1] = Math.min(Math.max(tree[2*treeNode+1][1], tree[2*treeNode][0]), Math.max(tree[2*treeNode+1][0], tree[2*treeNode][1]));
	}
	public static void updateTree(int[] arr,int[][] tree,int start,int end,int treeNode,int idx,int value) {
		if(start==end) {
			arr[idx] = value;
			tree[treeNode][0] = arr[idx];
			return;
		}
		int mid = (start+end)/2;
		if(idx>mid) {
			updateTree(arr, tree, mid+1, end, 2*treeNode+1, idx, value);
		}
		else {
			updateTree(arr, tree, start, mid, 2*treeNode, idx, value);
		}
		tree[treeNode][0] = Math.max(tree[2*treeNode+1][0], tree[2*treeNode][0]);
		tree[treeNode][1] = Math.min(Math.max(tree[2*treeNode+1][1], tree[2*treeNode][0]), Math.max(tree[2*treeNode+1][0], tree[2*treeNode][1]));
	}
	
	public static int[] fetch(int[][] tree,int start,int end,int treeNode,int idx,int idy) {
		if(start>=idx && end<=idy) {
			return tree[treeNode];
		}
		else if(end<idx || idy<start) {
			int[] temp = {Integer.MIN_VALUE,Integer.MIN_VALUE};
			return temp;
		}
		int mid = (start+end)/2;
		int[] ans1 = fetch(tree, start, mid, 2*treeNode, idx, idy);
		int[] ans2 = fetch(tree, mid+1, end, 2*treeNode+1, idx, idy);
		int temp[] = new int[2];
		temp[0] = Math.max(ans1[0], ans2[0]);
		temp[1] = Math.min(Math.max(ans1[0], ans2[1]), Math.max(ans1[1], ans2[0]));
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] tree = new int[4*n][2];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		int k = sf.nextInt();
		buildTree(arr, tree, 0, n-1, 1);
	/*	for (int i = 1; i < tree.length; i++) {
			System.out.println(tree[i][0]+tree[i][1]);
		}*/
		
		for (int i = 0; i <k; i++) {
			String quer_type = sf.next();
			int idx1 = sf.nextInt();
			int idx2 = sf.nextInt();
			if(quer_type.equals("U")) {
				updateTree(arr, tree, 0, n-1, 1, idx1-1, idx2);
			}
			else {
				int[] temp = fetch(tree, 0, n-1, 1, idx1-1, idx2-1);
				System.out.println(temp[0]+temp[1]);
			}
		}
		sf.close();
	}

}
