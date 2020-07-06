package segement_tree;

import java.util.Scanner;

/*
 * The fight for the best number in the globe is going to finally come to an end.The top two contenders for the best number are number 2 and number 3.It's the final the entire world was waiting for. Expectorates from all across the globe came to witness the breath taking finals.
The finals began in an astonishing way.A common problem was set for both of them which included both these number.The problem goes like this.
Given a binary string (that is a string consisting of only 0 and 1). They were supposed to perform two types of query on the string.
Type 0: Given two indices l and r.Print the value of the binary string from l to r modulo 3.

Type 1: Given an index l flip the value of that index if and only if the value at that index is 0.
The problem proved to be a really tough one for both of them.Hours passed by but neither of them could solve the problem.So both of them wants you to solve this problem and then you get the right to choose the best number in the globe.
Input:
The first line contains N denoting the length of the binary string .
The second line contains the N length binary string.Third line contains the integer Q indicating the number of queries to perform.
This is followed up by Q lines where each line contains a query.
Output:
For each query of Type 0 print the value modulo 3.
Constraints:
1<= N <=10^5

1<= Q <= 10^5

0 <= l <= r < N
Sample Input
5
10010
6
0 2 4
0 2 3
1 1
0 0 4
1 1
0 0 3
Sample Output
2
1
2
1
 */
public class Problem_2_vs_3 {
	public static void buildTree(String[] tree,String input,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode] = input.substring(start,start+1);
			return;
		}
		int mid = (start+end)/2;
		buildTree(tree, input, start, mid, 2*treeNode);
		buildTree(tree, input, mid+1, end, 2*treeNode+1);
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	}
	public static void update(String input,String[] tree,int start,int end,int treeNode,int idx) {
		if(start==end) {
			tree[treeNode] = "1";
			return;
		}
		int mid = (start+end)/2;
		if(idx>mid) {
			update(input, tree, mid+1, end, 2*treeNode+1, idx);
		}
		else {
			update(input, tree, start, mid, 2*treeNode, idx);
		}
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	}
	public static String query(String[] tree,int start,int end,int treeNode,int x,int y) {
		if(start>y || end<x) {
			return "";
		}
		else if(start>=x && end<=y) {
			return tree[treeNode];
		}
		int mid = (start+end)/2;
		String s1 = query(tree, start, mid, 2*treeNode, x, y);
		String s2 = query(tree, mid+1, end, 2*treeNode+1, x, y);
		return s1+s2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		String input = sf.next();
		String[] tree = new String[4*n];
		int q = sf.nextInt();
		buildTree(tree, input, 0, n-1, 1);
		for (int i = 0; i < q; i++) {
			int query_type = sf.nextInt();
			int x = sf.nextInt();
			int y = 0;
			if(query_type==0) {
				y = sf.nextInt();
				System.out.println(Long.parseLong(query(tree, 0, n-1, 1, x, y),2)%3);
			}
			else {
				if(input.charAt(x) == '0') {
					update(input, tree, 0, n-1, 1, x);
				}
			}
		}
		sf.close();
	}

}
