package dataStructures;

public class InorderTreeTraversal {
	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			this.val=x;
		}
	}
	public static void inorder(TreeNode root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
