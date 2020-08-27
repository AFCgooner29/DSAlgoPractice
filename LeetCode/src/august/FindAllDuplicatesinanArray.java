package august;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindAllDuplicatesinanArray {
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int curr = Math.abs(nums[i]);
			if(nums[curr-1]>0) {
				nums[curr - 1] = -1*nums[curr - 1];
			}
			else {
				ans.add(curr);
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,5,1,3};
		System.out.println(findDuplicates(nums));
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
