package strings;

import java.util.Arrays;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.s
 */
public class Count_and_say {
	public static String update_and_tell(String num) {
		int[] freq = {0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i < num.length(); i++) {
			freq[Integer.valueOf(num.substring(i,i+1))]++;
		}
		StringBuilder ss = new StringBuilder();
		for (int i = 0; i < num.length(); i++) {
			int idx = Integer.valueOf(num.substring(i, i+1));
			if(freq[idx]==0)continue;
			ss.append(freq[idx]);
			ss.append(idx);
			freq[idx]=0;
		}
		/*
		 * for (int i = 0; i < freq.length; i++) { if(freq[i]>0) { ss.append(freq[i]);
		 * ss.append(i); } }
		 */
		return new String(ss);
	}
	public static String countAndSay(int A) {
		String num = "1";
		for (int i = 1; i <A; i++) {
			int count = 0;
			String new_str = "";
			String val = num.substring(0,1);
			for (int j = 0; j < num.length(); j++) {
				if(!val.equals(num.substring(j, j+1))) {
					new_str+=String.valueOf(count);
					new_str+=val; 
					val = num.substring(j, j+1);
					count = 0;
					j--;
				}
				else {
					count++;
					if(j+1==num.length()) {
						new_str+=String.valueOf(count);
						new_str+=val; 
					}
				}
			}
			num = new_str;
		}
		return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(2));
	}

}
