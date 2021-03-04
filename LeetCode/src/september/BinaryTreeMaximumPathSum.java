package september;
/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
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
	public static int maxPathSum(TreeNode root) {
		if(root==null)return 0;
        int[] max = new int[1];
        maxPathSumHelper(root, max);
        return max[0];
    }
	public static int maxPathSumHelper(TreeNode root,int[] max) {
		if(root==null) {
			return 0;
		}
		int Lsum = maxPathSumHelper(root.left, max);
		int Rsum = maxPathSumHelper(root.right, max);
		/*
		 * 1. current node value plus left can be considered above
		 * 2. current Node value plus right	can be considered avbove
		 * 3.	left + current + right 
		 * 4. current can be considered above
		 */
		max[0] = Math.max(max[0], root.val);
		max[0] = Math.max(Lsum+root.val,Math.max(root.val+Rsum,Lsum+root.val+Rsum));
		return Math.max(Lsum+root.val,Math.max(root.val+Rsum,root.val));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
		System.out.println(maxPathSum(root));
	}

}
