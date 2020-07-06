package tries;

import java.util.Scanner;
/*
 * Approach
 * below
 */
public class Maximum_XOR_Pair {
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
	public static void createTree(int[] arr, node head) {
		for (int i = 0; i < arr.length; i++) {
			addtoTree(head, arr[i]);
		}
	}
	public static int getMaxPair(node head,int[] arr) {
		int max_xor = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			node curr = head;
			int curr_xor = 0;
			for (int j = 31; j >=0; j--) {
				int b = (arr[i]>>j)&1;
				if(b==0) {
					//b is 0 so we add to the left node of head
					if(curr.right!=null) {
						curr_xor+=Math.pow(2, j);
						curr  = curr.right;
					}
					else {
						if(curr.left!=null) {
							curr = curr.left;
						}
						else {
							break;
						}
					}
				}
				else {
					//b is 1 so we add to the right node of head
					if(curr.left!=null) {
						curr_xor+=Math.pow(2, j);
						curr  = curr.left;
					}
					else {
						if(curr.right!=null) {
							curr = curr.right;
						}
						else {
							break;
						}
					}
				}
			}
			max_xor = Math.max(max_xor, curr_xor);
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
		createTree(arr, head);
		System.out.println(getMaxPair(head, arr));
		sf.close();
	}

}
