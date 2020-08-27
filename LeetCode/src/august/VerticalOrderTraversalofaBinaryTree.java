package august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * Vertical Order Traversal of a Binary Tree

Solution
Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 
 */
public class VerticalOrderTraversalofaBinaryTree {
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
	public static class CustomNode{
		int x;
		TreeNode curr;
		public CustomNode(int val,TreeNode root) {
			this.x = val;
			this.curr = root;
		}
	}
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> ans =  new ArrayList<List<Integer>>();
		HashMap<Integer, ArrayList<TreeNode>> hp = new HashMap<Integer, ArrayList<TreeNode>>();
		helper(root, 0, hp);
		ArrayList<Integer> tempo = new ArrayList<Integer>();
		for (int i : hp.keySet()) {
			tempo.add(i);
		}
		Collections.sort(tempo);
		for (int i = 0; i < tempo.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < hp.get(tempo.get(i)).size(); j++) {
				temp.add(hp.get(tempo.get(i)).get(j).val);
			}
			Collections.sort(temp);
			ans.add(temp);
		}
		tempo=null;
		hp=null;
		return ans;
    }
	public static void helper(TreeNode root,int x,HashMap<Integer, ArrayList<TreeNode>> hp) {
		Queue<CustomNode> que = new LinkedList<CustomNode>();
		que.add(new CustomNode(0, root));
		while(!que.isEmpty()) {
			int size = que.size();
			//created temporary Hashmap to fill all the data at current Level and then sort values having same x values and then insert to HP
			HashMap<Integer, ArrayList<TreeNode>> tempo = new HashMap<Integer, ArrayList<TreeNode>>();
			for (int i = 0; i < size; i++) {
				CustomNode temp = que.poll();
				if(!tempo.containsKey(temp.x)) {
					tempo.put(temp.x, new ArrayList<TreeNode>());
				}
				tempo.get(temp.x).add(temp.curr);
				if(temp.curr.left!=null) {
					que.add(new CustomNode(temp.x-1, temp.curr.left));
				}
				if(temp.curr.right!=null) {
					que.add(new CustomNode(temp.x+1, temp.curr.right));
				}
			}
			for(int i : tempo.keySet()) {
				ArrayList<TreeNode> currLevel = tempo.get(i);
				Collections.sort(currLevel,new Comparator<TreeNode>() {
					@Override
					public int compare(TreeNode o1, TreeNode o2) {
						// TODO Auto-generated method stub
						if(o1.val<o2.val) {
							return -1;
						}
						else if(o1.val>o2.val) {
							return 1;
						}
						return 0;
					}
				});
				for(TreeNode z : currLevel) {
					if(!hp.containsKey(i)) {
						hp.put(i, new ArrayList<TreeNode>());
					}
					hp.get(i).add(z);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
