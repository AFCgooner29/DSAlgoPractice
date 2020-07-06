package adhoc_problems;

import java.util.Scanner;
/*
 * Approach
 */
public class Replace_0_with_1_k_times {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		int k = sf.nextInt();
		int start = 0;
		int end = 0;
		int max = 0;
		int curr_max = 0;
		while(end<s1.length()) {
			while(k!=0) {
				if(s1.substring(end,end+1).equals("0")) {
					k--;
				}
				end++;
				curr_max++;
				if(end==s1.length()) {
					break;
				}
			}
			//move window forward
			for (int i = start+1; i < end; i++) {
				if(s1.substring(i,i+1).equals("0")) {
					start = i;
					break;
				}
			}
			for (int i = end; i < s1.length(); i++) {
				if(s1.substring(i,i+1).equals("0")) {
					end = i;
					break;
				}
				curr_max++;
			}
			max = Math.max(curr_max, max);
			k++;
			curr_max = 0;
		}
		System.out.println(max);
		sf.close();
	}

}
