package bitmanipulation;
/*
 * https://leetcode.com/problems/single-number-ii/submissions/
 */
public class SingleNumber2 {
	public static int singleNumber(int[] A) {
        String res = "";
        for(int i=0;i<32;i++){
            //go for all the bits
            int count_0 = 0;
            for(int j = 0;j<A.length;j++){
                
                if((1 & (A[j]>>i))==1){
                    count_0++;
                }
            }
            System.out.println(count_0);
            if(count_0%3==0){
                res = "0"+res;
            }
            else{
                res = "1"+res;
            }
        }
        return Integer.parseInt(res,2);
    }
	public static int singleNumber2(int[] nums) {
	    int ans = 0;
	    for(int i = 0; i < 32; i++) {
	        int sum = 0;
	        for(int j = 0; j < nums.length; j++) {
	            if(((nums[j] >> i) & 1) == 1) {
	                sum++;
	                //sum %= 3;
	            }
	        }
	        System.out.println(sum);
	        System.out.println("ans "+ans);
	        if(sum%3 != 0) {
	            ans |= sum%3 << i;
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(singleNumber2(arr));
 	}

}
