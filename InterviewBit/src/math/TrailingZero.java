package math;
/*
 * 
Asked in:  
Microsoft
Jabong
Zillow
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1
 */
/*
 * https://www.purplemath.com/modules/factzero.htm
 */
public class TrailingZero {
	public static int trailingZeroes(int A) {
        if(A<5){
            return 0;
        }
        int count = 0; 
        for(int i=5;A/i>=1;i*=5){
            count+=A/i;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
