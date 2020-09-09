package dataStructures;
/*
 *   Merge Two Sorted Lists

Solution
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode ans = null;
		if(l1!=null && (l2==null || l2.val>l1.val)) {
			ans = l1;
			l1 = l1.next;
		}
		else if(l2!=null && (l1==null || l2.val<=l1.val)){
			ans = l2;
			l2 = l2.next;
		}
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				ans.next = l1;
				ans = ans.next;
				l1 = l1.next;
			}
			else {
				ans.next = l2;
				ans = ans.next;
				l2 = l2.next;
			}
		}
		if(l1!=null) {
			ans.next = l1;
		}
		else if(l2!=null) {
			ans.next = l2;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
