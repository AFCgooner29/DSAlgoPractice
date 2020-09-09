package dataStructures;

public class LListAddtwoNumbers {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode res = new ListNode();
		ListNode start = res;
        while(l1!=null && l2!=null) {
        	int sum = l1.val +l2.val + carry;
        	if(sum>9) {
        		carry = 1;
        		sum = sum-10;
        	}
        	res.next = new ListNode(sum);
        	res = res.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1!=null) {
        	int sum = l1.val + carry;
        	if(sum>9) {
        		carry = 1;
        		sum = sum-10;
        	}
        	res.next = new ListNode(sum);
        	res = res.next;
        	l1 = l1.next;
        }
        while(l2!=null) {
        	int sum = l2.val + carry;
        	if(sum>9) {
        		carry = 1;
        		sum = sum-10;
        	}
        	res.next = new ListNode(sum);
        	res = res.next;
        	l2 = l2.next;
        }
        return start.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
