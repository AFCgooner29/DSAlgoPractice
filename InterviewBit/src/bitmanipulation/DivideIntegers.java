package bitmanipulation;
/*
 * Divide Integers
Asked in:  
Microsoft
Amazon
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

Note: INT_MAX = 2^31 - 1
 */
public class DivideIntegers {
    public static int divide(int A, int B) {
    	int sign = ((A<0 || B<0) &&!(A<0 && B<0)) ? -1: 1;
    	A = Math.abs(A);
    	B = Math.abs(B);
    	int Z = B;
    	//if(B==1)return sign*A;
    	int res = -1;
    	while(A>=B) {
    		B = (B<<1);
    		res++;
    	}
    	res = (int)Math.pow(2, res);
    	if(A-(Z+B)>=0) {
    		res++;
    	}
    	return sign*res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(24, -1));
	}

}
