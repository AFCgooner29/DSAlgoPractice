package strings;

public class Longest_Palin_substring {
	public static String longestPalindrome(String A) {
		String max_str = "";
		int max =1;
		for (int i = 0; i < A.length(); i++) {
			if(i==0) {
				max_str = A.substring(0,1);
				if(i!=A.length()-1 && A.charAt(i)==A.charAt(i+1)) {
					int curr = 2;
					int l = i-1;
					int r = i+2;
					//check odd length substrings
					while(l>=0 && r<A.length()) {
						if(A.charAt(l)==A.charAt(r)) {
							curr+=2;
							if(curr>max) {
								max = curr;
								max_str = A.substring(l,r+1);
							}
							l--;
							r++;
						}
						else {
							break;
						}
					}
					if(curr>max) {
						max = curr;
						max_str = A.substring(l+1,r);
					}
				}
			}
			else {
				int l = i-1;
				int r = i+1;
				int curr = 1;
				//check odd length substrings
				while(l>=0 && r<A.length()) {
					if(A.charAt(l)==A.charAt(r)) {
						curr+=2;
						if(curr>max) {
							max = curr;
							max_str = A.substring(l,r+1);
						}
						l--;
						r++;
					}
					else {
						break;
					}
				}
				if(curr>max) {
					max = curr;
					max_str = A.substring(l+1,r);
				}
				//check even length
				if(i!=A.length()-1 && A.charAt(i)==A.charAt(i+1)) {
					curr = 2;
					l = i-1;
					r = i+2;
					//check odd length substrings
					while(l>=0 && r<A.length()) {
						if(A.charAt(l)==A.charAt(r)) {
							curr+=2;
							if(curr>max) {
								max = curr;
								max_str = A.substring(l,r+1);
							}
							l--;
							r++;
						}
						else {
							break;
						}
					}
					if(curr>max) {
						max = curr;
						max_str = A.substring(l+1,r);
					}
				}
				
			}
			
		}
		return max_str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("caba"));
	}

}
