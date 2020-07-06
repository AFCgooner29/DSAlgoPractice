package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree {
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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root == null)return 0;
        que.add(root);
        TreeNode currNode;
        int depth=0;
        while(!que.isEmpty()) {
        	int size = que.size();
        	depth++;
        	for (int i = 0; i < size; i++) {
        		currNode = que.poll();
        		if(currNode.right==null && currNode.left==null) {
            		return depth;
            	}
            	if(currNode.left!=null) {que.add(currNode.left);}
    			if(currNode.right!=null) {que.add(currNode.right);}
			}
        }
        return depth;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
