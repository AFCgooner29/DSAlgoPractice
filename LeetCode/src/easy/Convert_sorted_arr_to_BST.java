package easy;

import java.util.Arrays;

/*
 * 108. Convert Sorted Array to Binary Search Tree
Easy

2173

198

Add to List

Share
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Convert_sorted_arr_to_BST {
	

	public static class TreeNode { 
		int val; 
		TreeNode left; 
		TreeNode right; 
		TreeNode(int x) { 
			val = x; 
			} 
	}
	 
    public static TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length<=0) {
    		return null;
    	}
    	if(nums.length==1) {
    		TreeNode curr = new TreeNode(nums[0]);
    		return curr;
    	}
        int mid = (nums.length-1)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        curr.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        return curr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {-10,-8,0,1,3};
		System.out.println(sortedArrayToBST(nums));
	}

}
