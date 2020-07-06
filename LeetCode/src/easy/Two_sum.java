package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/*
 * 1. Two Sum
Easy

14221

521

Add to List

Share
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
/* 
 * We use two pointer approach
 */
/*
 * Fastest approach is to fill data in hashmap and then check for every i if target-nums[i] is in hashmap then return indexes
 * this is O(n) approach
 */
public class Two_sum {
	public static class node{
        int val;
        int pos;
        node(int v1,int v2){
            this.val = v1;
            this.pos = v2;
        }
    }
	public static int[] twoSum_fast(int[] nums, int target) {
		int[] ans = new int[2]; 
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(hp.containsKey(target - nums[i])) {
			    ans[0] = i;
                ans[1] = hp.get(target - nums[i]);
            }
			hp.put(nums[i], i);
		}
        return ans;
        /*
		for (int i = 0; i < nums.length; i++) {
			if(hp.containsKey(target-nums[i])) {
				if(nums[i]!=target-nums[i]) {
					ans[0] = i;
					ans[1] = hp.get(target-nums[i]).get(0);
					return ans;
				}
				else {
					if(hp.get(target-nums[i]).size()>1) {
						ans[0] = i;
						ans[1] = hp.get(target-nums[i]).get(1);
						return ans;
					}
				}
			}
		}
		return ans;*/
	}
	public static int[] twoSum(int[] nums, int target) {
		
	//	HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		node[] new_arr = new node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			new_arr[i] = new node(nums[i],i);
		}
        Arrays.sort(new_arr,new Comparator<node>() {

			@Override
			public int compare(node o1, node o2) {
				if(o1.val>o2.val) {
					return 1;
				}
				else if(o1.val<o2.val) {
					return -1;
				}
				return 0;
			}
        	
		});
      //  Arrays.sort(nums);
        int i =0;
        int j = nums.length-1;
        int[] ans = new int[2];
        while(new_arr[i].val+new_arr[j].val!=target && j<nums.length && i>-1) {
        	if(new_arr[i].val+new_arr[j].val<target) {
        		if(j<nums.length-1) {
        			j++;
        		}
        		else {
        			i++;
        		}
        	}
        	else if(new_arr[i].val+new_arr[j].val>target) {
        		if(i>0) {
        			i--;
        		}
        		else {
        			j--;
        		}
        	}
        }
        ans[0] = new_arr[i].pos;
        ans[1] = new_arr[j].pos;/*
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					ans[0] = i;
					ans[1] = j;
				}
			}
		}*/
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dum = {3,2,4};
		//twoSum(dum, 6);
		int[] ans = twoSum_fast(dum, 6);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
