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
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	/*
	 * Plan is to reverse the first half of the linked list then compare with the second half of the list
	 */
	public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	//we need to reverse the list where slow is traversing
        }
        if(fast!=null) {
        	//there are odd no of rows
        	slow = slow.next;
        }
        fast = head;
        slow = reverse(slow);
        while(slow!=null) {
        	if(slow.val!=fast.val) {
        		slow =null;
        		fast = null;
        		return false;
        	}
        	slow = slow.next;
        	fast = fast.next;
        }
        slow =null;
		fast = null;
        return true;
        
    }
	public static ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		//head.next = new ListNode();
		System.out.println(isPalindrome(head));
	}

}
