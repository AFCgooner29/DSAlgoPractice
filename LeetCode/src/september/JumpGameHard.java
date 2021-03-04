package september;

import java.util.HashMap;

public class JumpGameHard {
	public static int jump(int[] nums) {
		if(nums.length==0) {return 0;}
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		hp.put(nums.length-1, 0);
        for(int i = nums.length-2;i>-1;i--) {
        	int minJumps = Integer.MAX_VALUE;
        	for (int j = i; j < nums.length && j<=i+nums[i]; j++) {
				if(hp.containsKey(j)) {
					minJumps = Math.min(minJumps, hp.get(j)+1);
				}
			}
        	if(minJumps!=Integer.MAX_VALUE) {
        		hp.put(i,minJumps);
        	}
        }
        return hp.get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,1,4};
		System.out.println(jump(arr));
	}

}
