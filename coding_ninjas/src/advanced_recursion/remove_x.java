package advanced_recursion;

public class remove_x {
	public static String remover(String s1) {
		if(s1.equals("")) {
			return "";
		}
		if(s1.charAt(0)=='x') {
			if(s1.length()>1) {
			s1 = s1.substring(1);
			if(s1.charAt(0)!='x') {
			return s1.substring(0,1)+remover(s1.substring(1));
				}
			else {
				return remover(s1.substring(1));
			}
			}
			else {return "";}
			
		}
		else {
			return s1.substring(0,1)+remover(s1.substring(1));
		}
	}
	public static void main(String[] args) {
		
		String s1 = "aaa";
		s1 =remover(s1);
		
		System.out.println(s1);
	}

}
