package math;
/*
 * Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {
	public static int reverse(int A) {
		long rev = 0;
		boolean negFlag =false;
		if(A<0) {
			negFlag=true;
		}
		A = Math.abs(A);
		while(A>0) {
			rev = rev*10+A%10;
			A = A/10;
			if(rev>Integer.MAX_VALUE) {
				return 0;
			}
		}
		if(negFlag) {
			return (int)(rev - 2*rev);
		}
		return (int)rev;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
