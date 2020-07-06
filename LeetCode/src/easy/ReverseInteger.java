package easy;
/*
 * https://leetcode.com/problems/reverse-integer/solution/
 */
public class ReverseInteger {
    public static int reverse(int x) {
    	int val = 0;
    	boolean isNeg = false;
    	if(x<0) {
    		isNeg = true;
    		x = Math.abs(x);
    	}
    	while(x!=0) {
    		int pop = x%10;
    		if(val>Integer.MAX_VALUE/10) {
    			return 0;
    		}
    		val = val*10+pop;
    		x/=10;
    	}
    	if(isNeg)return -1*val;
    	return val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(147483648));
	}

}
