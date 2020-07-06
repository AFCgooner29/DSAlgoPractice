package advanced_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Return Keypad Code
Send Feedback
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : The order of strings are not important.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf

 */



public class keypad_problem {
	//explain
	public static int finder1(String s1,HashMap<String, String> hp,ArrayList<String> al) {
		if(s1.length()==1) {
			String s2 = hp.get(s1);
			for (int i = 0; i < s2.length(); i++) {
				al.add(s2.substring(i,i+1));
			}
			return s2.length();
		}
		int tot = finder1(s1.substring(1),hp,al);
		String s2 = hp.get(s1.substring(0,1));
		for (int j = 0; j < tot; j++) {
			for (int i = 0; i < s2.length(); i++) {
				al.add(s2.substring(i,i+1)+al.get(j));
			}
		}
		for (int i = 0; i < tot; i++) {
			al.remove(0);
		}
		return s2.length()*tot;
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
		Scanner sf = new Scanner(System.in);
		String num = sf.next();
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < num.length(); i++) {
			
		}
		finder1(num,hp,al);
		for (int i = 0; i < al.size(); i++) {
		
			System.out.println(al.get(i));}
		
		sf.close();
	}

}
