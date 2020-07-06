package binarySearch;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Painter's Partition Problem
Asked in:  
Google
Codenation
Given 2 integers A and B and an array of integars C of size N.

Element C[i] represents length of ith board.

You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003



Input Format

The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.
Output Format

Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
Constraints

1 <=A <= 1000
1 <= B <= 10^6
1 <= C.size() <= 10^5
1 <= C[i] <= 10^6
For Example

Input 1:
    A = 2
    B = 5
    C = [1, 10]
Output 1:
    50
Explanation 1:
    Possibility 1:- same painter paints both blocks, time taken = 55units
    Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
    There are no other distinct ways to paint boards.
    ans = 50%10000003

Input 2:
    A = 10
    B = 1
    C = [1, 8, 11, 3]
Output 2:
    11
 */
public class PainterPartition {
	public static boolean isPossible(ArrayList<Integer> A, long max,int B,int cost) {
		int i = 0;
		long curr_sum =0;
		int no_of_s= 1;
		for(i=0;i<A.size();i++) {
			if(A.get(i)*cost>max) {
				return false;
			}
			if(curr_sum+(A.get(i)*cost)>max) {
				curr_sum = A.get(i)*cost;
				no_of_s++;
				if(no_of_s>B) {
					return false;
				}
			}
			else {
				curr_sum+=(long)A.get(i)*cost;
			}
		}
		if(curr_sum>max)return false;
		return true;
	}
	public static int paint(int A, int B, ArrayList<Integer> C) {
		long min =0;
		long max = 0;
		for (int i = 0; i < C.size(); i++) {
			max+=C.get(i);
		}
		max=max*B;
		long ans = -1;
		while(min<=max) {
			long mid = min + (max-min)/2;
			if(isPossible(C,mid,A,B)) {
				max = mid-1;
				ans = mid;
			}
			else {
				min = mid+1;
			}
		}
		return (int)ans%10000003;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(paint(1, 1000000, A));
	}

}
