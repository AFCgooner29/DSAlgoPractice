package codejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Victor warehousing is a public warehousing company essentially in the business of leasing storage spaces to clients. Clients are charged per square feet of a unit of storage leased. To remain competitive, retain and attract additional clients, the company specializes in providing various flexible ways of leasing storage spaces.. They provide this flexibility by allowing clients to customize units of storage as per their needs. The company accepts a specification of storage units from clients and builds their storage as per the given specification. Through the client specification the clients express what are the different units of storage required and how they must be assembled together.
 *  contains two parts. The different units of storage separated by a comma in the first line and how the units are related to each other in the following n-1 lines, where n stands for the number of different units of storage. A simple 
 	Pallet,Rack,Row,Shelf
Pallet = 12 Rack
Rack = 18 Row
Row = 30 Shelf
1Pallet = 12Rack = 216Row = 6480Shelf	
 */
public class ESKO_TEST_QUES {
	public static class Node{
		long value;
		String name;
		Node prev;
		Node next;
		Node(long val,String nam){
			this.value = val;
			this.name = nam;
		}
	}
	public static Node find_right_value(Node head,String right) {
		Node curr = head;
		Node prev = head;
		while(curr!=null) {
			if(curr.name.equals(right)) {
				//cool we found it now we need to check and update on upperside
				return curr;
			}
			prev = curr;
			curr=curr.next;
		}
		return prev;
		//this means we were not able to find the right side
	}
	public static void find_and_fit_left(Node head,String left,int val,Node Right) {
		Node curr = Right;
		if(val>=Right.value) {
			long inc = val/Right.value;
			//multiply all above values with inc
			while(curr!=head) {
				curr.value*=inc;
				curr = curr.prev;
			}
			Node temp = curr.next;
			curr.next = new Node(1,left);
			curr.next.prev = head;
			curr.next.next = temp;
			curr = Right.next;
			while(curr!=null) {
				curr.value*=inc;
				curr = curr.prev;
			}
		}
		else {
			//we have to insert in middle
			System.out.println("else");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf  = new Scanner(System.in);
		String[] all = sf.nextLine().split(",");
		Node head = new Node(0, "");
		for (int i = 0; i < all.length; i++) {
			String[] query = sf.nextLine().split(" ");
			String left = query[0];
			int val = Integer.valueOf(query[2]);
			String right = query[3];
			Node right_found = find_right_value(head, right);
			if(right_found.name!=right) {
				right_found.next = new Node(val, right);
				right_found.next.prev = right_found;
				right_found = right_found.next;
				//make right node
			}
			find_and_fit_left(head, left, val, right_found);
			
		}
		
		sf.close();
	}

}
