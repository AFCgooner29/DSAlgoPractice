package math;
/*
 * 
Asked in:  
HCL
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */
public class Palindrome_number {
	public static int isPalindrome(int A) {
		int reversed = 0;
		if(A<0 ||(A%10==0 && A!=0)){
            return 0;
        }
		while(A>reversed) {
			int rem = A%10;
			A=A/10;
			reversed=reversed*10+rem;
		}
		if(reversed==A || reversed/10==A) {
			return 1;
		}
		return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(20));
	}

}
