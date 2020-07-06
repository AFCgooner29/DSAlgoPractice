package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 637. Average of Levels in Binary Tree
Easy

1194

165

Add to List

Share
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class Average_Levels_of_Binary_tree {
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> arr = new ArrayList<Double>();
        if(root==null) {return arr;}
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        TreeNode currNode;
        int size;
        while(!que.isEmpty()){
        	size = que.size();
        	double avg = 0;
        	for (int i = 0; i < size; i++) {
				currNode = que.poll();
				avg+=currNode.val;
				if(currNode.right!=null) {que.add(currNode.right);}
				if(currNode.left!=null) {que.add(currNode.left);}
			}
        	arr.add(avg/size);
        }
        return arr;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
