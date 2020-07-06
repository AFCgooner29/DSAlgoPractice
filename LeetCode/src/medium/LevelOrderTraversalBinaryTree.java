package medium;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
/*
 * For Level remember the number of element in que at the time before insertuion of new is the elements at same level
 */
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
	public class TreeNode {
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
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        TreeNode currNode;
        while(!que.isEmpty()) {
        	int size = que.size();
        	List<Integer> sublist = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
				currNode = que.poll();
				sublist.add(currNode.val);
				if(currNode.left!=null) {que.add(currNode.left);}
				if(currNode.right!=null) {que.add(currNode.right);}
			}
        	arr.add(sublist);
        }
        return arr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
