package dataStructures;

public class LinkList {
	public static class Node{
		int val;
		Node next;
		Node(int data,Node child){val = data;next = child;}
	}
	Node head;
	public LinkList(int[] data) {
		// TODO Auto-generated constructor stub
		head = new Node(data[0], null);
		for (int i = 0; i < data.length; i++) {
			
		}
	}
}
