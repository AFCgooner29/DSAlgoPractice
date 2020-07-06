package easy;
/*
 * 543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
/*
 * Approach
 * go to all the child nodes then set maxLeft and maxRight to 0
 * then their parent can have maxLeft = max(maxLeftofchild,maxRightofchild) of left child if there 
 * maxRight = max(maxLeftofchild,maxRightofchild) of right child
 * if maxRight+maxLeft > ans then update ans
 * 
 * in the end return ans
 */
public class Diameter_of_Binary_Tree {
	public static class TreeNode {
		TreeNode right;
		TreeNode left;
		int maxLeft = 0;
		int maxRight = 0;
	}
	public void fillmaxs(TreeNode root,int[] ans) {
		
		if(root.right!=null) {
			fillmaxs(root.right,ans);
			root.maxRight = Math.max(root.right.maxLeft, root.right.maxRight) + 1;
		}
		if(root.left!=null) {
			fillmaxs(root.left,ans);
			root.maxLeft = Math.max(root.left.maxLeft, root.left.maxRight) + 1;
		}
		ans[0] = Math.max(root.maxLeft+root.maxRight,ans[0]);
		return;
	}
	public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        fillmaxs(root, ans);
        return ans[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//here create the tree
	}

}
