package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		HashMap<Integer, ArrayList<ArrayList<Integer>>> hp = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(!hp.containsKey(nums[i]+nums[j])) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					ArrayList<ArrayList<Integer>> tempMaster =  new ArrayList<ArrayList<Integer>>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					tempMaster.add(temp);
					hp.put(nums[i]+nums[j],tempMaster);
				}
				else {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					hp.get(nums[i]+nums[j]).add(temp);
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				int toFind = target - (nums[i]+nums[j]);
				if(hp.containsKey(toFind)) {
					for (int k = 0; k < hp.get(toFind).size(); k++) {
						if(hp.get(toFind).get(k).get(0)!=nums[i] && hp.get(toFind).get(k).get(1)!=nums[i] && hp.get(toFind).get(k).get(0)!=nums[j] && hp.get(toFind).get(k).get(1)!=nums[j]) {
							List<Integer> temp = new ArrayList<Integer>();
							temp.add(nums[i]);
							temp.add(nums[j]);
							temp.add(hp.get(toFind).get(k).get(0));
							temp.add(hp.get(toFind).get(k).get(1));
							if(checDupli(ans,temp)) {
								ans.add(temp);
							}
						}
					}
					hp.remove(toFind);
				}
			}
		}
		return ans;
		
    }
	public static boolean checDupli(List<List<Integer>> ans,List<Integer> temp) {
		Collections.sort(temp);
		for (int i = 0; i < ans.size(); i++) {
			boolean toggle = true;
			Collections.sort(ans.get(i));
			for (int j = 0; j < temp.size(); j++) {
				if(ans.get(i).get(j)!=temp.get(j)) {
					toggle = false;
				}
			}
			if(toggle) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0));
	}

}
