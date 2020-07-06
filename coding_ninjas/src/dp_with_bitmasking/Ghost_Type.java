package dp_with_bitmasking;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Ghost Type
Send Feedback
Gengar has got an integer N. Now using his ghostly powers, he can create the permutation from 1 to N of this given number.
Since, he's a special kind of Poke'mon, so he thinks he deserves special permutations. He wants to find the total number of special permutations of length N, consisting of the integers from 1 to N
.

A permutation is called special if it satisfies following condition:
If Ap & Aq == Ap, then p < q, where p and q are two distinct indices of permutation and A is the permutation itself. "&" denotes the bitwise and operation.
Help Gengar in finding the number of such permutations.
Input format:
The only line of input will consist of a single integer N denoting the length of the permutation.
Output format:
Output the total number of special permutations of length N
.

Constraints:
1 ≤ N ≤ 20

SAMPLE INPUT
4

SAMPLE OUTPUT
8

Explanation
All the special permutations of length 4 are: 
1 2 3 4

1 2 4 3

1 4 2 3

2 1 3 4

2 1 4 3

2 4 1 3

4 1 2 3

4 2 1 3
 */
public class Ghost_Type {
	public static void checker(char[] init,int j) {
		boolean flag = false;
		for (int i = 0; i < init.length; i++) {
			if(i<j) {
				//if(init[i]!='0' && ())
			}
			else if(j<i) {
				
			}
		}
		
	}
	public static int finder(int bit,char[] init,int n) {
		if(1==1) {
			
			return 1;
		}
		for (int i = 0; i < n; i++) {
			if((bit&(1<<n))==0) {
				//now this bit we can set
				for (int j = 0; j < init.length; j++) {
					
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		char[] temp1 = new char[n];
		char[] temp2 = new char[n];
		int[] arr  = new int[1];
		Arrays.stream(arr).min().getAsInt();
		Arrays.fill(temp1, '0');
		Arrays.fill(temp2, '1');
		
		sf.close();
	}

}
