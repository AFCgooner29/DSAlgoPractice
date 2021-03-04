package september;
//https://leetcode.com/problems/jump-game/solution/
/*
 * Approach thought initially is
 * start from last index
 * and start marking indexes from which we can reach last index or 
 * any sub index which can take us to last index
 * 
 * second else loop can be optimized as we are searching for the last -1 is accessible from current position or not
 * 
 * Better approach
 * Approach 4: Greedy
Once we have our code in the bottom-up state, we can make one final, important observation. From a given position, when we try to see if we can jump to a GOOD position, we only ever use one - the first one (see the break statement). In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.

Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.

To illustrate this scenario, we will use the diagram below, for input array nums = [9, 4, 2, 1, 0, 2, 0]. We write G for GOOD, B for BAD and U for UNKNOWN. Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD. Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6. It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.

Index	0	1	2	3	4	5	6
nums	9	4	2	1	0	2	0
memo	U	G	B	B	B	G	G
Complexity Analysis
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
Time complexity : O(n)
 */
public class Jumpgame {
	public boolean canJump2(int[] nums) {
		if(nums.length==1)return true;
		int lastIdx = nums.length-1;
		for(int i=nums.length-1;i>=0;i--){
			if(nums[i]+i>=lastIdx) {
				lastIdx = i;
			}
		}
		return lastIdx==0;
	}
	 public boolean canJump1(int[] nums) {
	        if(nums.length==1)return true;
	        for(int i=nums.length-1;i>=0;i--){
	            if(i+nums[i]>=nums.length-1){
	                    nums[i]=-1;   
	                
	            }
	            else{
	                for(int j = i;j<nums.length && j<=i+nums[i];j++){
	                    if(nums[j]==-1){
	                        nums[i] = -1;
	                        break;
	                    } 
	                }
	            }
	        }
	        if(nums[0]==-1)return true;
	        return false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
