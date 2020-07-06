package medium;

public class LongestPalinSub5 {
    public static String longestPalindrome(String s) {
        int i = 0;
        if(s.isEmpty())return "";
        String maxSub = s.substring(0,1);
        int maxLen = 1;
        while(i<s.length()) {
        	int j = i-1;
        	int k = i+1;
        	int currLen = 1;
        	String currStr = s.substring(i,i+1);
        	while(j>=0 && k<s.length()) {
        		if(s.charAt(j)==s.charAt(k)) {
        			currLen = k-j+1;
        			currStr = s.substring(j,j+1)+currStr+s.substring(k,k+1);
        			if(currLen>maxLen) {
        				maxLen = currLen;
        				maxSub = currStr;
        			}
        			j--;
        			k++;
        		}
        		else {break;}
        	}
        	j = i-1;
        	k = i+1;
        	if(k<s.length() && s.charAt(i)==s.charAt(k)) {
        		//even len possible
        		currStr = s.substring(i,i+2);
        		currLen = 2;
        		if(currLen>maxLen) {
    				maxLen = currLen;
    				maxSub = currStr;
    			}
        		k++;
        		while(j>=0 && k<s.length()) {
            		if(s.charAt(j)==s.charAt(k)) {
            			currLen = k-j+1;
            			currStr = s.substring(j,j+1)+currStr+s.substring(k,k+1);
            			if(currLen>maxLen) {
            				maxLen = currLen;
            				maxSub = currStr;
            			}
            			j--;
            			k++;
            		}
            		else {break;}
            	}
        	}
        	i++;
        }
        return maxSub;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aaaa"));
	}

}
