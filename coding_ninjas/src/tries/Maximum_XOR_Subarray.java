package tries;

import java.util.Scanner;
/*
 * Maximum XOR Subarray
Send Feedback
Given an array of n integers, find subarray whose xor is maximum.
Input Format
First line contains single integer n (1<=n<=1000000).
Next line contains n space separated integers.
Output Format
Print xor of the subarray whose xor of all elements in subarray is maximum over all subarrays.
Constraints
1 <= n <= 1000000
1 <= A[i] <=100000 
Sample Input
4
1 2 3 4
Sample Output
7
 */
/*
 * Approach is very confusing
 * will write today
 */
public class Maximum_XOR_Subarray {
	public static class node {
		node left = null;
		node right = null;
	}
	public static void addtoTree(node head,int ele) {
		node curr = head;
		for (int i = 31; i >=0; i--) {
			int b = (ele>>i)&1;
			if(b==0) {
				//b is 0 so we add to the left node of head
				if(curr.left==null) {
					curr.left = new node();
				}
				curr = curr.left;
			}
			else {
				//b is 1 so we add to the right node of head
				if(curr.right==null) {
					curr.right = new node();
				}
				curr = curr.right;
			}
		}
	}
	public static int getMaxxor(node head,int ele) {
		int max_xor = 0;
		node cur = head;
		for (int i = 31; i >= 0; i--) {
			int b = (ele>>i)&1;
			if(b==0) {
				//chose right if possible
				if(cur.right!=null) {
					max_xor += Math.pow(2, i);
					cur = cur.right;
				}
				else {
					cur = cur.left;
				}
			}
			else {
				//chose left if possible
				if(cur.left!=null) {
					max_xor += Math.pow(2, i);
					cur = cur.left;
				}
				else {
					cur = cur.right;
				}
			}
		}
		return max_xor;
	}
	public static int createTree(int[] arr, node head) {
		int xor_till = 0;
		int max_xor = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			xor_till = xor_till^arr[i];
			if(i!=0) {
				max_xor = Integer.max(getMaxxor(head, xor_till), max_xor);
			}
			else {
				max_xor = Integer.max(max_xor, xor_till);
			}
			addtoTree(head, xor_till);
		}
		return max_xor;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sf.nextInt();
		}
		node head = new node();
		System.out.println(createTree(arr, head));
		sf.close();
	}

}
