package dataStructures;

public class FlattenDoublyList {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	};
	public Node flatten(Node head) {
        if(head.child==null) {
        	return flatten(head.next);
        }
        else {
        	head.next = getAllChild(head.child,head.next);
        }
		return head;
    }
	public Node getAllChild(Node head,Node nextt) {
		if(head==null) {
			return head;
		}
		Node child = head.child;
		if(child!=null) {
			return flatten(child);
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
