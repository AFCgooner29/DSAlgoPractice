package advanced_recursion;

public class find_length_of_char_arr {
	public static int len_finder(String arr) {
		if(arr.equals("")) {
			return 0;
		}
		return 1+len_finder(arr.substring(1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		System.out.println(len_finder(s1));
		
	}

}
