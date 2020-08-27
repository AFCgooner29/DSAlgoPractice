package dataStructures;
/*
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class LinkedListPalindrome {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	/*
	 * Plan is to reverse the first half of the linked list then compare with the second half of the list
	 */
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
