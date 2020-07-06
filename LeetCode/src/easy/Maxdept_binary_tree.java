package easy;
/*
 * 104. Maximum Depth of Binary Tree
Easy

2218

66

Add to List

Share
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class Maxdept_binary_tree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int max1=0;
        int max2=0;
        if(root.left!=null){
            max1 = 1+maxDepth(root.left);
        }
        if(root.right!=null){
            max2 = 1+maxDepth(root.right);
        }
        return Math.max(max1,max2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
