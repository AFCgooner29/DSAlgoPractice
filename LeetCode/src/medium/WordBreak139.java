package medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
	public static int[] generateKMPArr(String subs) {
		int[] zarr = new int[subs.length()];
		int i =0;
		int j =1;
		while(j!=subs.length()) {
			if(subs.charAt(i)==subs.charAt(j)) {
				zarr[j] = i+1;
				i++;
				j++;
			}
			else {
				if(i==0) {
					zarr[j] = 0;
					j++;
				}
				else {
					i = zarr[i-1];
				}
			}
		}
		return zarr;
		
	}
	public static String kmpSearch(String dict,String word) {
		int[] lps = generateKMPArr(dict);
		int j = 0;
		int i = 0;
		while (i!=word.length() ) {
			if(j==dict.length()) {
				j=0;
				word = word.substring(0,i-dict.length())+word.substring(i); 
				i=i-dict.length();
			}
			if(dict.charAt(j)==word.charAt(i)) {
				j++;
			}
			else {
				if(j!=0) {
					j = lps[j-1];
				}
			}
			i++;
			if(j==dict.length()) {
				j=0;
				word = word.substring(0,i-dict.length())+word.substring(i); 
				i=i-dict.length();
			}
		}
		return word;
	}
    public static boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
			s = kmpSearch(wordDict.get(i), s);
		}
        if(s.isEmpty())return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordBreak("leetcode", wordDict));
	}

}
 