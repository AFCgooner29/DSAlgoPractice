package august;

import java.util.HashMap;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		HashMap<Character, Integer> store = new HashMap<Character, Integer>();
		for (int i = 1; i <= 26; i++) {
			char c = (char) ('A' + i - 1);
			store.put(c, i);
		}
		int ans = 0;
		for (int i = s.length()-1; i >=0; i--) {
			ans+=Math.pow(26,s.length()-1-i)*store.get(s.charAt(i));
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AB"));
	}

}
