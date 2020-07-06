package easy;

import java.util.ArrayList;
import java.util.HashMap;

/*
 *   First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class First_unique_char_in_string {
	public int firstUniqChar(String s) {
        HashMap<String,ArrayList<Integer>> hp = new HashMap<String,ArrayList<Integer>>();
        for(int i =0;i<s.length();i++){
        	String curr = s.substring(i,i+1);
            if(hp.containsKey(curr)) {
            	hp.get(curr).add(i);
            }
            else {
            	hp.put(curr, new ArrayList<Integer>());
            	hp.get(curr).add(i);
            }
        }
        for(int i =0;i<s.length();i++){
        	String curr = s.substring(i,i+1);
        	if(hp.get(curr).size()==1) {
        		return hp.get(curr).get(0);
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
