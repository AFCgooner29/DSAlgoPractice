package arrays;

public class Jumpgame1 {
	public static boolean canJump(int[] nums) {
		int lastIdx = nums.length-1;
		for(int i = nums.length-2; i>-1;i--) {
			if(i+nums[i]>=lastIdx)lastIdx = i;
		}
		if(lastIdx==0)return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,1,0,4};
		System.out.println(canJump(arr));
	}

}
