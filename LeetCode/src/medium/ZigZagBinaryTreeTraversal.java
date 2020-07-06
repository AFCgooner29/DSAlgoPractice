package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

1899

99

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

public class ZigZagBinaryTreeTraversal {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> arr = new ArrayList<List<Integer>>();
    	if(root==null) {
    		return arr;
    	}
    	Queue<TreeNode> que = new LinkedList<TreeNode>();
    	boolean right= false;
    	que.add(root);
    	int size;
    	TreeNode currNode;
    	while(!que.isEmpty()) {
    		size = que.size();
    		List<Integer> sublist = new ArrayList<Integer>();
    		for (int i = 0; i < size; i++) {
				currNode = que.poll();
				if(right) {
					sublist.add(currNode.val);
				}
				else {
					sublist.add(0,currNode.val);
				}
				if(currNode.left!=null) {
					que.add(currNode.left);
				}
				if(currNode.right!=null) {
					que.add(currNode.right);
				}
				//right = true;
			}
    		right = !right;
    		arr.add(sublist);
    	}
    	return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4,null,null),null),new TreeNode(3,null,new TreeNode(5,null,null)));
		System.out.println(zigzagLevelOrder(root));
	}

}
