package hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length==0) {return ans;}
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        ans.add(0,0);
        sorted.add(nums[nums.length-1]);
        for (int i = nums.length-2; i >=0; i--) {
        	int pos = Collections.binarySearch(sorted, nums[i]);
        	if(pos<0) {
        		ans.add(0,-1*(pos+1)-1);
        		sorted.add(-1*(pos+1),nums[i]);
        	}
        	else {
        		ans.add(0,-1*(pos+1));
        		sorted.add(pos,nums[i]);
        	}
		}
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,2};
		System.out.println(countSmaller(nums));
	}

}
