package string_algos;

public class Z_arr_pattern_search {
	public static void builder(int[] Z,String full) {
		
	}
	public static int finder(String s1,String pat) {
		String full = pat+"$"+s1;
		int[] Z = new int[full.length()];
		builder(Z,full);
		for (int i = 0; i < Z.length; i++) {
			if(Z[i]==pat.length()) {
				return Z[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
