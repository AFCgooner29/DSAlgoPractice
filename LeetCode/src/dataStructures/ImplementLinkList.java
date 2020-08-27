package dataStructures;
/*
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 */
public class ImplementLinkList {
	static class Node{
		Node next;
		int val;
	}
	static class MyLinkedList {
		Node head;
		int length = 0;
	    /** Initialize your data structure here. */
	    public MyLinkedList() {
	    }
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	        Node curr = this.head;
	        int i = 0;
	    	while(curr!=null && i<=index) {
	    		if(i==index) {
	    			return curr.val;
	    		}
	    		curr=curr.next;
	    		i++;
	    	}
	    	return -1;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	    	Node curr = new Node();
	    	curr.val = val ;
	    	this.length++;
	    	if(this.head==null) {
	    		this.head = curr;
	    		return;
	    	}
	    	curr.next = this.head;
	        this.head = curr;
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	    	if(this.head==null) {
	    		this.head.val = val;
	    		this.length++;
	    		return;
	    	}
	    	Node curr = this.head;
	    	while(curr.next!=null) {
	    		curr=curr.next;
	    	}
	    	Node temp = new Node();
			temp.val = val ;
	        curr.next = temp;
	        this.length++;
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	    	if(index==0) {
	    		this.addAtHead(val);
	    		return;
	    	}
	    	else if(index==this.length) {
	    		this.addAtTail(val);
	    		return;
	    	}
	    	else if(index<0 || index>this.length) {
	    		return;
	    	}
	    	Node curr = this.head;
	    	Node prev = null;
	        int i = 0;
	    	while(curr!=null && i<=index) {
	    		if(i==index) {
	    			Node temp = new Node();
	    			temp.val = val;
	    			temp.next = prev.next;
	    			prev.next = temp;
	    			this.length++;
	    			return;
	    		}
	    		prev = curr;
	    		curr=curr.next;
	    		i++;
	    	}
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	    	if(index == 0 && this.length!=0) {
	        	this.head = this.head.next;
	        	this.length--;
	        	return;
	        }
	    	if(index>=this.length)return;
	        Node curr = this.head;
	        Node prev = null;
	        int i = 0;
	    	while(curr!=null && i<=index) {
	    		if(i==index) {
	    			prev.next = curr.next;
	    			curr = null;
	    			this.length--;
	    			return;
	    		}
	    		prev = curr;
	    		curr=curr.next;
	    		i++;
	    	}
	    	return;
	        
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(7);
		obj.addAtHead(2);
		obj.addAtHead(1);
		obj.addAtIndex(3,0);
		obj.deleteAtIndex(2);
		obj.addAtHead(6);
		obj.addAtTail(4);
		System.out.println(obj.get(4));
		obj.addAtHead(4);
		
	}

}
