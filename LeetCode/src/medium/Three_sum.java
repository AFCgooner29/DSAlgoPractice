package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 * 3Sum
Medium

6016

733

Add to List

Share
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Three_sum {
	public static ArrayList<ArrayList<Integer>> simple(ArrayList<Integer> arr){
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i+1; j < arr.size(); j++) {
				outer : for (int j2 = j+1; j2 < arr.size(); j2++) {
					if(arr.get(i)+arr.get(j)+arr.get(j2)==0) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(arr.get(i));
						temp.add(arr.get(j));
						temp.add(arr.get(j2));
						Collections.sort(temp);
						for (int k = 0; k < ans.size(); k++) {
							if(ans.get(k).get(0)==temp.get(0) && ans.get(k).get(1)==temp.get(1) && ans.get(k).get(2)==temp.get(2)) {
								continue outer;
							}
						}
						ans.add(temp);
					}
				}
			}
		}
		//this approach is slowest and we need to add code for not adding duplicate triplets also
		return ans;
	}
	public static ArrayList<ArrayList<Integer>> faster(int[] arr){
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length && arr[i]<=0; i++) {
			if(i==0 || arr[i]!=arr[i-1]) {
				HashSet<Integer> hp = new HashSet<Integer>();
				int to_find = 0 - arr[i];
				outer : for (int j = i+1; j < arr.length; j++) {
					if(hp.contains(to_find-arr[j])) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(arr[i]);
						temp.add(arr[j]);
						temp.add(to_find-arr[j]);
						Collections.sort(temp);
						for (int k = 0; k < ans.size(); k++) {
							if(ans.get(k).get(0)==temp.get(0) && ans.get(k).get(1)==temp.get(1) && ans.get(k).get(2)==temp.get(2)) {
								continue outer;
							}
						}
						ans.add(temp);
					}
					hp.add(arr[j]);
				}
			}
		}
		//this approach is faster we will store all data in hashmap then
		return ans;
	}
	public static ArrayList<ArrayList<Integer>> two_point(int[] arr){
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length && arr[i]<=0; i++) {
			if(i==0 || arr[i]!=arr[i-1]) {
			//	HashSet<Integer> hp = new HashSet<Integer>();
				int to_find = 0 - arr[i];
				int low = i+1;
				int hi = arr.length-1;
				while(low<hi) {
					if(arr[low]+arr[hi]+arr[i]==0) {
						ans.add((ArrayList<Integer>) Arrays.asList(arr[low],arr[hi],arr[i]));
						while (low < hi && arr[low] == arr[low+1]) {low++;}
                        while (low < hi && arr[hi] == arr[hi-1]) {hi--;}
                        low++;
                        hi--;
					}
					else if(arr[low]+arr[hi]<to_find) {
						low++;
					}
					else {
						hi--;
					}
				}
			}
		}
		//this approach is faster we will store all data in hashmap then
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
