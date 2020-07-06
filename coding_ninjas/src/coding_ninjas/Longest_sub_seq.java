package coding_ninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Longest_sub_seq {
	/*
	 * Longest consecutive Sequence
Send Feedback
You are given with an array of integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
Best solution takes O(n) time.
If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 50000
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 
9 
10 
11 
12
Sample Input 2 :
7
3 7 2 1 9 8 1
Sample Output 2 :
7
8
9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but output should be [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 
16

	 */
	public static ArrayList<Integer> longest(int[] arr){
		/*
		 * accoding to hint video
		 * not working
		 */
		int end = 0 ;
		int start = 0;
		int max = 0;
		int right = Arrays.stream(arr).max().getAsInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		for (int i : arr) {
			hp.put(i,0);
		}
		for(int i : hp.keySet()) {
			if(hp.get(i)!=1) {
				hp.put(i,1);
				start = i;
				for (int j = i+1; j <=right; j++) {
					if(hp.containsKey(j)) {
						hp.put(j,1);
						end = j;
						if(end-start>max) {
							max=end-start;
							al.clear();
							for(int k = start; k<=end;k++) {
								al.add(k);
							}
						}
					
					}
					else {
						break;
					}
				}
				for (int j = i-1; j > 0; j--) {
					
					if(hp.containsKey(j)) {
						hp.put(j,1);
						start = j;
						if(end-start>max) {
							max=end-start;
							al.clear();
							for(int k = start; k<=end;k++) {
								al.add(k);
							}
						}
					
					}
					else {
						break;
					}
				}
			}
			
		}
		return al;
	}
	public static ArrayList<Integer> longestConsecutiveSequenceHashmap(int[] arr){
		/*
		 * This is still not optimal
		 * but this can check for unordered sequences also
		 */
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		int current = 0 ;
		int start = 0;
		int end = 0;
		int max = 0;
		int flag = 0;
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		for (int i : arr) {
			hp.put(i,1);
		}
		for (int i = 0; i < arr.length; i++) {
			
			start = arr[i];
			current = arr[i];
			flag=1;
			
			while(flag!=0) {
				if(hp.containsKey(current+1)) {
					current+=1;
					end = current;
					if(end-start>max) {
						max = end-start;
						al.clear();
						for(int k = start; k<=end;k++) {
							al.add(k);
						}
					}
				
				}
				else {
					flag=0;
				}
			}
		}
		if(al.size()==0 ||arr.length==1) {
			al.add(arr[0]);
		}
		return al;
	}
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		int start =	0;
		int end = 	0;
		int current = 0;
		int max = 0;
		ArrayList<Integer> al = new ArrayList<Integer>(); 
		/*
		 * we are starting from first value
		 * and find next value this is only works
		 * when next increment value is after the 
		 * selected number
		 * because of this we are failing some test cases
		 * plus TLE is coming because its O(n^2)
		 * need to try impementing using hashmap
		 */
		for(int i=0;i<arr.length; i++) {
			start = arr[i];
			current = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]-current==1) {
					current = arr[j];
					end = arr[j];
					
					if(end-start>max) {
						max = end-start;
						al.clear();
						for(int k = start; k<=end;k++) {
							al.add(k);
						}
					}
				}
				
			}
			
		}
		if(al.size()==0 ||arr.length==1) {
			al.add(arr[0]);
		}
		
		return al;
		
	}
	public static void main(String[] args) {
		int[] inp = {55};
		System.out.println(longest(inp));
		System.out.println(longestConsecutiveIncreasingSequence(inp));
		System.out.println(longestConsecutiveSequenceHashmap(inp));
		

	}

}
