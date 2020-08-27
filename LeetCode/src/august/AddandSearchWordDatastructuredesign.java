package august;

import java.util.ArrayList;
import java.util.HashMap;

public class AddandSearchWordDatastructuredesign {
	public static class Node {
		HashMap<Character, Node> next = new HashMap<Character, Node>();
		char val;
		public Node(char value) {
			this.val = value;
		}
	}
	public static class WordDictionary {
		Node myNode;
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        myNode = new Node('*');
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        Node curr = this.myNode;
	    	for (char i : word.toCharArray()) {
				if(curr.next.containsKey(i)) {
					curr = curr.next.get(i);
				}
				else {
					curr.next.put(i, new Node(i));
					curr = curr.next.get(i);
				}
			}
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	    	Node curr = this.myNode;
	    	int count = 0;
	    	for (char i : word.toCharArray()) {
				if(i!='.' && curr.next.containsKey(i)) {
					curr = curr.next.get(i);
				}
				else if(i=='.') {
					return customSearch(word.substring(count), curr);
				}
				else {
					return false;
				}
				count++;
			}
	    	if(curr.next.keySet().isEmpty()) {
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean searchHelper(String word,Node curr) {
	    	int count = 0;
	    	for (char i : word.toCharArray()) {
				if(i!='.' && curr.next.containsKey(i)) {
					curr = curr.next.get(i);
				}
				else if(i=='.') {
					return customSearch(word.substring(count), curr);
				}
				else {
					return false;
				}
				count++;
			}
	    	if(curr.next.keySet().isEmpty()) {
	    		return true;
	    	}
	    	return false;
	    }
	    public boolean customSearch(String word,Node customNode) {
	    	if(word.isEmpty()) {
	    		return true;
	    	}
	    	if(word.charAt(0)=='.') {
	    		for(char i : customNode.next.keySet()) {
		    		return customSearch(word.substring(1), customNode.next.get(i));
		    	}
	    		return false;
	    	}
	    	else {
	    		return searchHelper(word,customNode);
	    	}
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary obj = new WordDictionary();
		obj.addWord("abcd");
		boolean param_2 = obj.search("abc");
		System.out.println(param_2);
	}

}
