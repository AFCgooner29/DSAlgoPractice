package strings;

/*
 * 
Asked in:  
Intuit
Amazon
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
/*
 * Approach
 * We split string based on "."
 * Then if some arr1 is smaller than arr2 we consider missing numbers as 0
 * then compare each character to check which is bigger we are doing each character to avoid integer overflow
 */
public class CompareVersion {
	public static int compareVersion(String A, String B) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareVersion("4444371174137455", "5.168"));
	}

}
