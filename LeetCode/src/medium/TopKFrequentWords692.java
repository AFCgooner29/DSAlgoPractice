package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords692 {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hp = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
			hp.put(words[i], hp.getOrDefault(words[i], 0)+1);
		}
        Arrays.parallelSort(words,new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO Auto-generated method stub
        		if(hp.get(o1)<hp.get(o2)) {
        			return 1;
        		}
        		else if(hp.get(o1)>hp.get(o2)) {
        			return -1;
        		}
        		else {
        			return o1.compareTo(o2);
        		}
        	}
		});
        List<String> ans = new ArrayList<String>();
        int i = 0;
        int j = 0;
        while (j<k) {
			ans.add(words[i]);
			while(i<words.length && words[i].equals(ans.get(j)))i++;
			j++;
		}
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println(topKFrequent(words, 2));
	}

}
