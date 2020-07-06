package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * 49. Group Anagrams
Medium

3449

182

Add to List

Share
Given an array of strings, group anagrams together.

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
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<String>> holder = new HashMap<String, ArrayList<String>>();
		List<List<String>> result = new ArrayList<List<String>>(); 
		for (int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.parallelSort(temp);
			String temp_s = new String(temp);
			if(holder.containsKey(temp_s)) {
				holder.get(temp_s).add(strs[i]);
			}
			else {
				holder.put(temp_s, new ArrayList<String>());
				holder.get(temp_s).add(strs[i]);
			}
		}
		holder.forEach((k,v) -> result.add(v));
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
