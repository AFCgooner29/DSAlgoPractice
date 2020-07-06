package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Largest_number_Amazon {
	public static String largestNumber(final ArrayList<Integer> A) {
		
		Collections.sort(A, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				/*
				if(o1.isEmpty()) {
					return -1;
				}
				if(o2.isEmpty()) {
					return 1;
				}
				if(o1.charAt(0)>o2.charAt(0)) {
					return -1;
				}
				else if(o1.charAt(0)<o2.charAt(0)) {
					return 1;
				}
				else {
					if(o1.length()==1) {
						return compare(o1, o2.substring(1));
					}
					else if(o2.length()==1) {
						return compare(o1.substring(1), o2);
					}
					return compare(o1.substring(1), o2.substring(1));
				}
				//return 0;
				 */
				String new_str1 = String.valueOf(o1)+String.valueOf(o2);//we are comparing which string attached first will be more benificial
				String new_str2 = String.valueOf(o2)+String.valueOf(o1);
				return new_str1.compareTo(new_str2) > 0 ? -1:1;
			}
		});
		String ans1 = "";
		for (int i = 0; i < A.size(); i++) {
			ans1+=String.valueOf(A.get(i));
		}
		while(ans1.charAt(0)=='0' && ans1.length()>1) {
			ans1 = ans1.substring(1);
		}
		return ans1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(0);
		A.add(0);
		A.add(5);
		A.add(0);
		System.out.println(largestNumber(A));
	}

}
