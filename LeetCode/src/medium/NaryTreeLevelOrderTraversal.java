package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import medium.LevelOrderTraversalBinaryTree.TreeNode;

public class NaryTreeLevelOrderTraversal {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		if(root==null)return arr;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        Node currNode;
        while(!que.isEmpty()) {
        	int size = que.size();
        	List<Integer> sublist = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++) {
				currNode = que.poll();
				sublist.add(currNode.val);
				for (int j = 0; j < currNode.children.size(); j++) {
					que.add(currNode.children.get(j));
				}
			}
        	arr.add(sublist);
        }
        return arr;
    }
}
