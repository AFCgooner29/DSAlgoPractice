package advanced_recursion;
/*
 * remember this
 */
public class print_all_subseq {
	public static void printer_sub_seq(String input,String output) {
		if(input.length()==0) {
			if(output.length()!=0) {
			System.out.println(output);}
			return;
		}
		printer_sub_seq(input.substring(1), output);
		printer_sub_seq(input.substring(1), output+input.substring(0,1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc";
		printer_sub_seq(s1, "");
	}

}
