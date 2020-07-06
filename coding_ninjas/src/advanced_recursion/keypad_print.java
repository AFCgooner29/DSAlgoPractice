package advanced_recursion;

import java.util.HashMap;
import java.util.Scanner;

public class keypad_print {
	public static void printer(String input,String output,HashMap<String, String> hp) {
		if(input.length()==0) {
			System.out.println(output);
			return;
		}
		String next = hp.get(input.substring(0,1));
		int start = 0;
		for (int i = 0; i < next.length(); i++) {
			printer(input.substring(1), output+next.substring(start,start+1), hp);
			start++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hp =new HashMap<String, String>();
		hp.put("2","abc");
		hp.put("3", "def");
		hp.put("4", "ghi");
		hp.put("5", "jkl");
		hp.put("6","mno");
		hp.put("7", "pqrs");
		hp.put("8", "tuv");
		hp.put("9", "wxyz");
		Scanner sf =new Scanner(System.in);
		String s1  = sf.next();
		printer(s1, "", hp);
		sf.close();
	}

}
