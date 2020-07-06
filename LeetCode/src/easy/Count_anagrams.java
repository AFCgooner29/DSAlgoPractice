package easy;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
/*
 * We can sort each string and then traverse the trie, if path is there then this is a anagram
 * otherwise add this to the trie
 */
public class Count_anagrams {
	public static class node{
		char value;
		ArrayList<node> children;
		HashSet<String> allAnagrams;
	}
	public static void createTree(node head,String s1,String orig) {
		node curr = head;
		for (int i = 0; i < s1.length(); i++) {
			int found = 0;
			for (int j = 0; j < curr.children.size(); j++) {
				if(curr.children.get(j).value==s1.charAt(i)) {
					curr = curr.children.get(j);
					if(i == s1.length()-1) {
					//	curr.allAnagrams = new HashSet<String>();
						curr.allAnagrams.add(orig);
					}
					found = 1;
				}
			}
			if(found==0) {
				curr.children.add(new node());
				curr = curr.children.get(curr.children.size()-1);
				curr.value = s1.charAt(i);
				if(i == s1.length()-1) {
					curr.allAnagrams = new HashSet<String>();
					curr.allAnagrams.add(orig);
				}
			}
		}
	}
	public static void finder(node head,ArrayList<ArrayList<String>> ans){
		if(head.children.isEmpty()) {
			ArrayList<String> temp = new ArrayList<String>();
			for (String s : head.allAnagrams) {
				temp.add(s);
			}
			ans.add(temp);
			return;
		}
		for (int i = 0; i < head.children.size(); i++) {
			finder(head.children.get(i), ans);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
