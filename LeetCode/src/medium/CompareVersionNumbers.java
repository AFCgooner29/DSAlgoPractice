package medium;
/*
 * 165. Compare Version Numbers
Medium

447

1368

Add to List

Share
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.

 

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 

Note:

Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
/*
 * Approach
 * We split string based on "."
 * Then if some arr1 is smaller than arr2 we consider missing numbers as 0
 * then compare each character to check which is bigger we are doing each character to avoid integer overflow
 */
public class CompareVersionNumbers {
	 public int compareVersion(String A, String B) {
	        String[] temp1 = A.split("\\.");
			String[] temp2 = B.split("\\.");
			int max_len = Math.max(temp1.length, temp2.length);
			for (int i = 0; i < max_len; i++) {
				String v1 = (i>=temp1.length) ? "0": temp1[i];
				String v2 = (i>=temp2.length) ? "0": temp2[i];
				while(v1.charAt(0)=='0' && v1.length()>1) {
					v1 = v1.substring(1);
				}
				while(v2.charAt(0)=='0' && v2.length()>1) {
					v2 = v2.substring(1);
				}
				if(v1.length()<v2.length()) {
					return -1;
				}
				else if(v1.length()>v2.length()) {
					return 1;
				}
				else {
					for (int j = 0; j < v1.length(); j++) {
						if(v1.charAt(j)>v2.charAt(j)) {
							return 1;
						}
						else if(v1.charAt(j)<v2.charAt(j)) {
							return -1;
						}
					}
				}
			}
			return 0;
	    }
}
