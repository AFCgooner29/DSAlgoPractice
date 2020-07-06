package segement_tree;
/*
 * Maximum Sum In Subarray
Send Feedback
You are given a sequence A[1], A[2], ..., A[N] . ( |A[i]| ≤ 15007 , 1 ≤ N ≤ 50000 ). A query is defined as follows:
Query(x,y) = Max { a[i]+a[i+1]+...+a[j] ; x ≤ i ≤ j ≤ y }.
Given M queries, your program must output the results of these queries.
Input
The first line of the input file contains the integer N.
In the second line, N numbers follow.
The third line contains the integer M.
M lines follow, where line i contains 2 numbers xi and yi.
Output
Your program should output the results of the M queries, one 
query per line.
Sample Input:
3 
-1 2 3 
1
1 2
Sample Output:
2
 */
import java.util.Scanner;

public class Maximum_Sum_In_Subarray {
	public static void buildTree(int[] arr,long[][] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode][0] = arr[end];   //this contains sum
			tree[treeNode][1] = arr[end]; //this contains BPS(Best prefix sum)
			tree[treeNode][2] = arr[end]; //best suffix sum
			tree[treeNode][3] = arr[end]; //best sum
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode][0] = tree[2*treeNode+1][0]+ tree[2*treeNode][0]; //total sum of both
		tree[treeNode][1] = Math.max(tree[2*treeNode][0]+tree[2*treeNode+1][1], tree[2*treeNode][1]);
		tree[treeNode][2] = Math.max(tree[2*treeNode+1][0]+tree[2*treeNode][2], tree[2*treeNode+1][2]);
		tree[treeNode][3] = Math.max(tree[2*treeNode][3],
				Math.max(tree[2*treeNode+1][3], 
				Math.max(tree[2*treeNode][2]+tree[2*treeNode+1][1], 
				Math.max(tree[treeNode][1], tree[treeNode][2]))));
	}
	public static long[] fetch(long[][] tree,int start,int end,int treeNode,int idx,int idy) {
		//in range of idx and idy
		if(start>=idx && end<=idy) {
			return tree[treeNode];
		}
		else if(start>idy || end<idx) {
			long[] temp = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
			return temp;
		}
		int mid = (start+end)/2;
		long[] ans1 = fetch(tree, start, mid, 2*treeNode, idx, idy);
		long[] ans2 = fetch(tree, mid+1, end, 2*treeNode+1, idx, idy);
		long[] temp = new long[4];
		temp[0] = ans2[0]+ ans1[0]; //total sum of both
		temp[1] = Long.max(ans1[0]+ans2[1], ans1[1]);
		temp[2] = Long.max(ans2[0]+ans1[2], ans2[2]);
		temp[3] = Long.max(ans1[3],
				Long.max(ans2[3], 
				Long.max(ans1[2]+ans2[1], 
				Long.max(temp[1], temp[2]))));
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		long[][] tree = new long[4*n][4];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		int k = sf.nextInt();
		buildTree(arr, tree, 0, n-1, 1);
		
		for (int i = 0; i <k; i++) {
			int idx1 = sf.nextInt();
			int idx2 = sf.nextInt();
			System.out.println(fetch(tree, 0, n-1, 1, idx1-1, idx2-1)[3]);
			
		}
		sf.close();
	}

}
