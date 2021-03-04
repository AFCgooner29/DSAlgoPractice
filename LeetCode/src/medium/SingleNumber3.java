package medium;
//https://leetcode.com/problems/single-number-iii/submissions/
public class SingleNumber3 {
	public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        for(int i : nums){
            xor^=i;
        }
        if(xor==0)return ans;
        int i = 1;
        while(true){
            if((xor & i) == i){
                break;
            }
            i = i<<1;
        }
        int xor1 = 0;
        xor = 0;
        for(int j : nums){
            if((j & i)==0){ //bit different
                xor1^=j;
            }
            else{
                xor^=j;
            }
        }
        ans[0] = xor1;
        ans[1] = xor;
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
