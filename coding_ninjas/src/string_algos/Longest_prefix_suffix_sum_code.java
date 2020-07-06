package string_algos;

public class Longest_prefix_suffix_sum_code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcabc";
		int i = 0;
		int j = 1;
		int[] lps = new int[s1.length()];
		lps[0] = 0;
		while (j<s1.length()) {
			if(s1.charAt(i) == s1.charAt(j)) {
				lps[j] = i+1;
				j++;
				i++;
			}
			else {
				if(i!=0) {
					i = lps[i-1];
				}
				else {
					lps[j] = 0;
					j++;
				}
			}
		}
		for (int k = 0; k < lps.length; k++) {
			System.out.print(lps[k]+" ");
		}
	}

}
