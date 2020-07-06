package medium;

import java.util.ArrayList;
/*
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
public class Implement_Trie_Prefix_Tree {
	public static class Trie {
	    ArrayList<Trie> next;
	    String val;
	    boolean endHere;
	    /** Initialize your data structure here. */
	    public Trie() {
	        this.next = new ArrayList<Trie>();
	    }
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	Trie curr = this;
	    	outer : while(!word.isEmpty()) {
	    		for (int i = 0; i < curr.next.size(); i++) {
					if(word.substring(0,1).equals(curr.next.get(i).val)) {
						curr = curr.next.get(i);
						word = word.substring(1);
						continue outer;
					}
				}
	    		curr.next.add(new Trie());
	    		curr.next.get(curr.next.size()-1).val = word.substring(0,1);
	    		word = word.substring(1);
	    		curr = curr.next.get(curr.next.size()-1);
	    	}
	    	curr.endHere = true;
	    	return;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        Trie curr = this;
	        outer : while(!word.isEmpty()) {
	    		for (int i = 0; i < curr.next.size(); i++) {
					if(word.substring(0,1).equals(curr.next.get(i).val)) {
						curr = curr.next.get(i);
						word = word.substring(1);
						continue outer;
					}
				}
	    		return false;
	    	}
	        if(!curr.endHere)return false;
	    	return true;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	Trie curr = this;
	        outer : while(!prefix.isEmpty()) {
	    		for (int i = 0; i < curr.next.size(); i++) {
					if(prefix.substring(0,1).equals(curr.next.get(i).val)) {
						curr = curr.next.get(i);
						prefix = prefix.substring(1);
						continue outer;
					}
				}
	    		return false;
	    	}
	    	return true;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

}
