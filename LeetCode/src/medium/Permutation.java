package medium;

import java.util.ArrayList;

/*
 * Find Permutation
Asked in:  
Goldman Sachs
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]
 */
/*
 * https://leetcode.com/articles/find-permutation/
 */
public class Permutation {
	public static void swap(ArrayList<Integer> A, int start,int end) {
		int temp = A.get(start);
		A.set(start, A.get(end));
		A.set(end, temp);
	}
	public static void reverse(ArrayList<Integer> A, int start,int end) {
		while(start<end) {
			swap(A, start, end);
			start++;
			end--;
		}
	}
	public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <=B; i++) {
			ans.add(i);
		}
        int i=0,j=0;
        while(i<A.length() && j<A.length()) {
        	while(j<A.length() && A.charAt(j)=='D') {
        		j++;
        	}
        	reverse(ans,i,j);
        	i = j;
        	i++;
        	j++;
        }
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
