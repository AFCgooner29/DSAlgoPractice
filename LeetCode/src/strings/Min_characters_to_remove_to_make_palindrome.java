package strings;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a string say “ABAABCD”. Calculate minimum number of letters to be removed such that remaining letters can form a palindrome string.
Answer for “ABAABCD” is : 2
Explanation : Remove C and D, remaining string is : “ABAAB” which can form a palindrome(BAAAB)
Approach : Simply count the number of odd characters. Since you can keep one character of odd count hence answer will be odd character -1. I used HashMap for storing characters and their count.
if(odd_characters==0) return 0;
return odd_characters-1;
 */
public class Min_characters_to_remove_to_make_palindrome {
	public static int finder(String s1) {
		//a palindrome is there if all characters are having even count
		//or if only one character is having odd count and if there are rest and those should have even count
		int[][] counter = new int[26][2];
		for(char s : s1.toCharArray()) {
			counter[s-'a'][0] = s-'a';
			counter[s-'a'][1]++;
		}
		Arrays.parallelSort(counter,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]<o2[1]) {
					return 1;
				}
				else if(o1[1]>o2[1]) {
					return -1;
				}
				return 0;
			}
		});
		int odd_count = 0;
		for (int i = 0; i < counter.length; i++) {
			if(counter[i][1]%2!=0 && odd_count==0) {
				odd_count++;
			}
			else if(counter[i][1]%2!=0 && odd_count>0) {
				char temp = (char) ('a'+counter[i][0]);
				System.out.println("removing "+temp);
				odd_count++;
			}
		}
		if(odd_count==0) {
			return 0;
		}
		else {
			return odd_count-1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(finder("abaabcd"));
	}

}
