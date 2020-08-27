package hard;

/*
 * Remove Extra Edge

Problem Description

Given a binary tree A where all values of nodes are distinct, there is a pair of leaf nodes which have the same value.

Considering that the pair that has the same value is indeed the same node and not two different nodes, return the tree after removing one of the edges from it.

You need to remove the edge from the parent whose value is greater. See examples for more details.

Problem Constraints

1 <= size of tree <= 100000

1 <= value of node <= 109

Input Format

First and only argument is the binary tree A.

Output Format

Return the root of the binary tree after removing the extra edge.

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 * TreeNode* Solution::solve(TreeNode* A) {}
 */
public class RemoveExtraEdge {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}
	public static void solveHelper(TreeNode A, TreeNode[] visited) {
		if(A==null)return;
		if(visited[A.right.val]!=null) {
			//already visited
			if(visited[A.right.val].left.val==A.right.val){
				//parent's left or right
				if(visited[A.right.val].val>A.val) {
					visited[A.right.val].left = null;
				}
				else {
					A.right = null;
				}
			}
			if(visited[A.right.val].right.val==A.right.val){
				if(visited[A.right.val].val>A.val) {
					visited[A.right.val].right = null;
				}
				else {
					A.right = null;
				}
			}
		}
		if(visited[A.left.val]!=null) {
			if(visited[A.left.val].left.val==A.left.val){
				//parent's left or right
				if(visited[A.left.val].val>A.val) {
					visited[A.left.val].left = null;
				}
				else {
					A.left = null;
				}
			}
			if(visited[A.left.val].right.val==A.left.val){
				if(visited[A.left.val].val>A.val) {
					visited[A.left.val].right = null;
				}
				else {
					A.left = null;
				}
			}
		}
		visited[A.right.val] = A;
		visited[A.left.val] = A;
		solveHelper(A.right,visited);
		solveHelper(A.left,visited);
		return;
	}
	public static TreeNode solve(TreeNode A) {
		TreeNode[] visited = new TreeNode[120];
		solveHelper(A, visited);
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
