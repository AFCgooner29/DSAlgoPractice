package hard;

public class MergeKsortedLinkedLists {
	public static class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		ListNode test = head;
		test = test.next;
		System.out.println(test.val +" "+head.val);
	}

}
