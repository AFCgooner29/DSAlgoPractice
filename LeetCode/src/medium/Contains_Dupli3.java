package medium;

import java.util.HashMap;

public class Contains_Dupli3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			for (int j = nums[i]-t; j <=nums[i]+t; j++) {
				if(hp.containsKey(j) && i - hp.get(j)<=k) {
					return true;
				}
			}
			hp.put(nums[i], i);
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
