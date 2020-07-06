package easy;

import java.util.HashMap;

/*
 * 242. Valid Anagram
Easy

1273

131

Add to List

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Is_valid_anagram {
	 public static boolean isAnagram(String s, String t) {
	        if(s.length()!=t.length()){
	            return false;
	        }
	        HashMap<String,Integer> hp = new HashMap<String,Integer>();
	        for(int i= 0;i<s.length();i++){
	            if(hp.containsKey(s.substring(i,i+1))){
	            	int val = hp.get(s.substring(i,i+1));
	                hp.put(s.substring(i,i+1),val+1);
	            }
	            else{
	                hp.put(s.substring(i,i+1),1);
	            }
	        }
	        for(int i= 0;i<t.length();i++){
	            if(hp.containsKey(t.substring(i,i+1))){
	            	int val = hp.get(t.substring(i,i+1));
	                hp.put(t.substring(i,i+1),val-1);
	            }
	            else{
	                return false;
	            }
	        }
	        for(int i= 0;i<s.length();i++){
	            
	          	if(hp.get(s.substring(i,i+1))!=0)
	          		return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("anagram","nagaram"));
	}

}
