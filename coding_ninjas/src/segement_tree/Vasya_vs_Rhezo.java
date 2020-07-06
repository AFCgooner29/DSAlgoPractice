package segement_tree;

import java.util.Scanner;

public class Vasya_vs_Rhezo {
/*
 * Vasya vs Rhezo
Send Feedback
Queen Vasya is preparing for a war against Rhezo. She has N warriors in total arranged in a line. Let us number the warriors by numbers from 1 to N. She will fight Rhezo's army for Q days, and each day she can choose only one warrior.
For each warrior, we know 2 values associated with him, let us call these A and B. Each day Vasya can choose her warrior from a range Li to Ri, she must choose the warrior with maximum A value. If there is more than 1 warrior having the same maximum A value, she chooses the warrior with minimum B value. If still there is more than 1 warrior with same maximum A value and same minimum B value, she chooses the one with lower index in line.
You being the hand of Queen Vasya, need to help her in choosing the warrior for each day.
Input:
First line contains a single integer N, denoting the number of warriors Queen Vasya has. 
Second line contains N space separated integers Ai. Third line contains N space separated integers Bi.
Next line contains a single integer Q, denoting the number of days Queen Vasya chooses a warrior. 
Each of the next Q lines contains 2 integers Li and Ri.
Output:
For each Li and Ri, print the index of the warrior that Queen Vasya should choose.
Constraints:
1≤ N,Q ≤10^6
1≤ Ai,Bi ≤10^9
1≤Li≤Ri
Sample Input
5
1 8 4 6 8
4 8 6 3 7
4
1 4
2 4
3 4
1 5
Sample Output
2
2
4
5
 */
	public static void buildTree(int[][] arr,int[][] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode][0] = arr[start][0];//COntains A value
			tree[treeNode][1] = arr[start][1];//Contains B value
			tree[treeNode][2] = start;//Contains the index of element selected
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		//we have to take the person with max A and if both A are same then MIN B
		//if that also matches then Lower index element
		if(tree[2*treeNode][0]>tree[2*treeNode+1][0]) {
			tree[treeNode] = tree[2*treeNode];
		}
		else if(tree[2*treeNode][0]<tree[2*treeNode+1][0]) {
			tree[treeNode] = tree[2*treeNode+1];
		}
		else {
			if(tree[2*treeNode][1]>tree[2*treeNode+1][1]) {
				tree[treeNode] = tree[2*treeNode+1];
			}
			else{
				tree[treeNode] = tree[2*treeNode];
			}
		}
	}
	public static int[] query(int[][] tree,int start,int end,int treeNode,int x,int y) {
		//completely outside
		if(start>y || end<x) {
			int[] temp = new int[3];
			temp[0] = Integer.MIN_VALUE;
			temp[1] = Integer.MAX_VALUE;
			temp[2] = -1;
			return temp;
		}
		else if(start>=x && end<=y) {
			return tree[treeNode];
		}
		int mid = (start+end)/2;
		int[] ans1 = query(tree, start, mid, 2*treeNode, x, y); 
		int[] ans2 = query(tree, mid+1, end, 2*treeNode+1, x, y);
		if(ans1[0]>ans2[0]) {
			return ans1;
		}
		else if(ans1[0]<ans2[0]) {
			return ans2;
		}
		else {
			if(ans1[1]>ans2[1]) {
				return ans2;
			}
			else{
				return ans1;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sf.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i][1] = sf.nextInt();
		}
		int[][] tree = new int[4*n][3];
		buildTree(arr, tree, 0, n-1, 1);
		int q = sf.nextInt();
		for (int i = 0; i < q; i++) {
			System.out.println(query(tree, 0, n-1, 1, sf.nextInt()-1, sf.nextInt()-1)[2]+1);
		}
		sf.close();
	}

}
