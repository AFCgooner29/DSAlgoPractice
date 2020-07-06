package adhoc_problems;

import java.util.Scanner;

// Code forces Equalize problem
/*
 * You are given two binary strings a and b of the same length. You can perform the following two operations on the string a:

Swap any two bits at indices i and j respectively (1≤i,j≤n), the cost of this operation is |i−j|, that is, the absolute difference between i and j.
Select any arbitrary index i (1≤i≤n) and flip (change 0 to 1 or 1 to 0) the bit at this index. The cost of this operation is 1.
Find the minimum cost to make the string a equal to b. It is not allowed to modify string b.

Input
The first line contains a single integer n (1≤n≤106) — the length of the strings a and b.

The second and third lines contain strings a and b respectively.

Both strings a and b have length n and contain only '0' and '1'.

Output
Output the minimum cost to make the string a equal to b.

Examples
inputCopy
3
100
001
outputCopy
2
inputCopy
4
0101
0011
outputCopy
1
 */
public class Live_problem_1 {
	public static String swap(String s1,int i) {
		//to swap i and i+1 in s1
		if(s1.substring(i,i+1)=="0") {
			if(i!=s1.length()-2) {
				s1 = s1.substring(0,i)+"10"+s1.substring(i+2);
			}
			else {
				s1 = s1.substring(0,i)+"10";
			}
		}
		else {
			if(i!=s1.length()-2) {
				s1 = s1.substring(0,i)+"01"+s1.substring(i+2);
			}
			else {
				s1 = s1.substring(0,i)+"01";
			}
		}
		return s1;
	}
	public static String flip(String s1,int i) {
		//to flip i in s1
		if(s1.substring(i,i+1)=="0") {
			s1 = s1.substring(0,i)+"1"+s1.substring(i+1);
		}
		else {
			s1 = s1.substring(0,i)+"0"+s1.substring(i+1);
		}
		return s1;
	}
	public static int costfinder(String s1,String s2) {
		int cost = 0;
		for (int i = 1; i < s1.length(); i++) {
			if(!s1.substring(i-1,i).equals(s2.substring(i-1,i))) {
				if(i!=s1.length()-1 
						&& s1.substring(i-1,i)!=s1.substring(i,i+1) 
						&& s2.substring(i,i+1)!=s1.substring(i,i+1)) {
					s1 = swap(s1,i-1);
					cost++;
				}
				else {
					s1 = flip(s1,i-1);
					cost++;
				}
			}
		}
		
		return cost;
	}
	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		String s1 = sf.next();
		String s2 = sf.next();
		System.out.println(costfinder(s1, s2));
		sf.close();
	}

}
