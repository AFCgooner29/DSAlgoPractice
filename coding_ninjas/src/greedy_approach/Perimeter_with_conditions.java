package greedy_approach;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Perimeter with conditions
Send Feedback
Aahad gives an array of integers and asks Harshit to find which three elements form a triangle (non-degenerate). The task seems easy to Harshit.
So, Aahad adds some conditions to this task -
1. Find the triangle with maximum perimeter
2. If there are two or more combinations with same value of maximum perimeter, then find the one with the longest side.
3.If there are more than one combinations which satisfy all the above conditions the find with maximum longest minimum side.
Input Format
The First line contains no of elements of array: N
Each T lines contains N space-separated integers: A [i]
Output Format
The output contains three space-separated elements that denote the length of the sides of triangle. If no such triangle is possible, then print -1.
Constraints
1 =< N <= 10^5 
1 <= A[i] <= 10^9
Time Limit: 1 second
Sample Input1:
5
1 1 1 3 3
Sample Output1:
1 3 3 
Sample Input2:
3
2 2 4
Sample Output3:
-1 
Explaination
In the First Sample case, the elements that form a triangle with maximum perimeter is 1,3,3.
In the Second Sample case, the elements that can form a triangle are degenerate, so, we printed -1.
 */
public class Perimeter_with_conditions {
	public static boolean is_triange_possible(int x, int y, int z) {
		if (x + y > z && y + z > x && z + x > y) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[] cor = new int[tot];
		for (int i = 0; i < cor.length; i++) {
			cor[i] = sf.nextInt();
		}
		int[] dp = new int[tot];
		Arrays.fill(dp, 0);
		Arrays.parallelSort(cor);
		//as we are checking from back of sorted array the first possible answer will be the 
		//best answer
		for (int i = cor.length-1; i >= 2; i--) {
			for (int j = i-1; j >= 1; j--) {
				for (int j2 = j-1; j2 >=0; j2--) {
					if(is_triange_possible(cor[i], cor[j], cor[j2])) {
						System.out.println(cor[j2]+" "+cor[j]+" "+cor[i]);
						sf.close();
						return;
					}
				}
			}
		}
		System.out.println(-1);
		sf.close();
	}

}
