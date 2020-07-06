package advanced_recursion;

import java.util.ArrayList;

public class subsequence_string {
	public static int find(String s1,ArrayList<String> al) {
		if(s1.length()==0) {
			al.add("");
			return 1;
		}
		int tot = find(s1.substring(1),al);
		for (int i = 0; i < tot; i++) {
			al.add(s1.substring(0,1)+al.get(i));
		}
		return 2 * tot;
		 
	}
	public static String subst(String s1,int start,int end){
		if(start==s1.length()-1) {
			System.out.println(s1.substring(start));
			return "";
		}
		if(end<s1.length()-1) {
			System.out.println(s1.substring(start,end+1));
			return subst(s1,start,end+1);
		}
		else {
			System.out.println(s1.substring(start));
			System.out.println(s1.substring(start,start+1));
			return subst(s1, start+1, end+2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		ArrayList<String> subs =new ArrayList<String>();
		find(s1,subs);
		//System.out.println(subst(s1,0,1));
		System.out.println(subs);
	}

}
