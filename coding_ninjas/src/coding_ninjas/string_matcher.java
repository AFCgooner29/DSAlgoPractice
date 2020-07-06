package coding_ninjas;

import java.util.HashMap;

public class string_matcher {

	public static void main(String[] args) {
		String s1 = "zsABc";
		String s2 = "ABC";
		HashMap<Character, Integer> hp = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if(Character.isLowerCase(s1.charAt(i))) {
				hp.put(s1.charAt(i), 1);
			}
			else {
				hp.put(Character.toLowerCase(s1.charAt(i)), 0);
			}
		}
		
		String res = "YES";
		s1 = s1.toLowerCase();
		for (int i = 0; i < s2.length(); i++) {
			if(!s1.contains(s2.substring(i, i+1).toLowerCase())) {
				res = "NO";
			}
			else {
				if(hp.get(Character.toLowerCase(s2.charAt(i)))==1) {
					res = "YES";
				}
				else {
				res = "NO";}
			}
		}
		System.out.println(res);
		
	}
	

}
