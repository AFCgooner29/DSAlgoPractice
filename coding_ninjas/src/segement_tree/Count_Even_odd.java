package segement_tree;

import java.util.Scanner;

/*
 * Counting Even/Odd
Send Feedback
Ashu and Shanu are best buddies. One day Shanu gives Ashu a problem to test his intelligence.He gives him an array of N natural numbers and asks him to solve the following queries:-
Query 0 :- modify the element present at index i to x.
Query 1:- count the number of even numbers in range l to r inclusive.
Query 2:- count the number of odd numbers in range l to r inclusive.
Input:
First line of the input contains the number N. Next line contains N natural numbers. 
Next line contains an integer Q followed by Q queries.

0 x y - modify the number at index x to y. 

1 x y - count the number of even numbers in range l to r inclusive.

2 x y - count the number of odd numbers in range l to r inclusive.
Constraints:
1<=N,Q<=10^5

1<=l<=r<=N 

0<=Ai<=10^9

1<=x<=N

0<=y<=10^9
Note:-
indexing starts from 1.
Sample Input
6
1 2 3 4 5 6
4
1 2 5
2 1 4
0 5 4
1 1 6
Sample Output
2
2
4
 */
public class Count_Even_odd {
	public static void buildTree(int[] arr,int[][] tree,int start,int end,int treeNode) {
		if(start==end) {
			if(arr[start]%2==0) {
				tree[treeNode][0] = 1;//even counter
				tree[treeNode][1] = 0;//odd_counter
			}
			else {
				tree[treeNode][0] = 0;//even counter
				tree[treeNode][1] = 1;//odd counter
			}
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode][0]=tree[2*treeNode][0] + tree[2*treeNode+1][0];
		tree[treeNode][1]=tree[2*treeNode][1] + tree[2*treeNode+1][1];
	}
	public static int query(int[][] tree,int start,int end,int treeNode,int x,int y,int type) {
		if(start>y || end<x) {
			return 0;
		}
		else if(start>=x && end<=y) {
			return tree[treeNode][type];
		}
		int mid = (start+end)/2;
		int ans1 = query(tree, start, mid, 2*treeNode, x, y, type);
		int ans2 = query(tree, mid+1, end, 2*treeNode+1, x, y, type);
		return ans1+ans2;
	}
	public static void update(int[] arr,int[][] tree,int start,int end,int treeNode,int x,int value) {
		if(start==end) {
			arr[x] = value;
			if(value%2==0) {
				tree[treeNode][0] = 1;
				tree[treeNode][1] = 0;
			}
			else {
				tree[treeNode][0] = 0;
				tree[treeNode][1] = 1;
			}
			return;
		}
		int mid = (start+end)/2;
		if(x>mid) {
			update(arr, tree, mid+1, end, 2*treeNode+1, x, value);
		}
		else {
			update(arr, tree, start, mid, 2*treeNode, x, value);
		}
		tree[treeNode][0]=tree[2*treeNode][0] + tree[2*treeNode+1][0];
		tree[treeNode][1]=tree[2*treeNode][1] + tree[2*treeNode+1][1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		int[][] tree = new int[4*n][2];
		buildTree(arr, tree, 0, n-1, 1);
		int q = sf.nextInt();
		for (int i = 0; i < q; i++) {
			int type = sf.nextInt();
			int x = sf.nextInt();
			int y = sf.nextInt();
			if(type!=0) {
				System.out.println(query(tree, 0, n-1, 1, x-1, y-1, type-1));
			}
			else {
				update(arr, tree, 0, n-1, 1, x-1, y);
			}
		}
		sf.close();
	}

}
