package medium;
/*
 * 137. Single Number II
Medium

1708

340

Add to List

Share
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
public class SingleNumber2 {
	public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < bitCount.length; j++) {
				int z = i<<j;
				if((nums[i]&z)==z) {
					bitCount[j]++;
				}
			}
		}
        String num = "";
        for (int i = 0; i < bitCount.length; i++) {
			if(bitCount[i]%3==0) {
				num = "0"+num;
			}
			else {
				num = "1"+num;
			}
		}
        return Integer.parseInt(num, 2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
