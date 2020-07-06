package advanced_recursion;

public class replace_with {
	public static String replacer(String s1,char c1,char c2) {
		if(s1.equals("")) {
			return "";
		}
		if(s1.charAt(0)==c1) {
			return c2+replacer(s1.substring(1),c1,c2);
		}
		return s1.substring(0,1)+replacer(s1.substring(1),c1,c2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1  = "abacd";
		char c1 = 'a';
		char c2 = 'x';
		s1 = replacer(s1, c1, c2);
		System.out.println(s1);
	}

}
