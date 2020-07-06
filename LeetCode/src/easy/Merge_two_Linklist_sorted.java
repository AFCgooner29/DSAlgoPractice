package easy;

/*
 * 21. Merge Two Sorted Lists
Easy

3638

541

Add to List

Share
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
/*
 * this works but 
 * takes too much memory
 */
public class Merge_two_Linklist_sorted {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		      public void print() {
		    	  ListNode curr = this;
		    	  while(curr!=null) {
		    		  System.out.println(curr.val);
		    		  curr = curr.next;
		    	  }
		      }
		  }
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode i = l1;
	        ListNode j = l2;
	        ListNode ans = new ListNode(-1);
	        while(i!=null && j!=null) {
	        	if(i.val<j.val) {
	        		ans.next = new ListNode(i.val);
	        		ans = ans.next;
	        		i = i.next;
	        	}
	        	else {
	        		ans.next = new ListNode(j.val);
	        		ans = ans.next;
	        		j = j.next;
	        	}
	        }
	        return ans;
	 }
}
