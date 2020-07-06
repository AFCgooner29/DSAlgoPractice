package coding_ninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


/*
 * Murder
Once detective Saikat was solving a murder case. While going to the crime scene he took the stairs and saw that a number is written on every stair. He found it suspicious and decides to remember all the numbers that he has seen till now. While remembering the numbers he found that he can find some pattern in those numbers. So he decides that for each number on the stairs he will note down the sum of all the numbers previously seen on the stairs which are smaller than the present number. Calculate the sum of all the numbers written on his notes diary.
Answer may not fit in integer . You have to take long.
Input
First line gives T, number of test cases.

2T lines follow.

First line gives you the number of stairs N

Next line gives you N numbers written on the stairs.
Output
For each test case output one line giving the final sum for each test case.
Constraints
T<=10

1<=N<=10^5

All numbers will be between 0 and 10^6.
Sample Input:
1
5
1 5 3 6 4
Sample Output:
15
Explanation:
For the first number, the contribution to the sum is 0.
For the second number, the contribution to the sum is 1.
For the third number, the contribution to the sum is 1.
For the fourth number, the contribution to the sum is 9 (1+5+3).
For the fifth number, the contribution to the sum is 4 (1+3).
Hence the sum is 15 (0+1+1+9+4).

 */




public class Murder {
	public static long summer(int[] arr,HashMap<Integer, Long> hp,int len) {
		//wrong approach
		long counter = 0;
		ArrayList<Integer> search_arr = new ArrayList<Integer>();
		search_arr.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j>=0; j--) {
				if(search_arr.get(j)<arr[i]) {
					if(hp.get(search_arr.get(j))!=0) {
						counter+=hp.get(search_arr.get(j));
						break;
					}
					else {
						counter+=search_arr.get(j);
					}
				}
				hp.put(arr[i], counter);
				search_arr.add(arr[i]);
				Collections.sort(search_arr);
			}
		}
		return counter;
	}
	
	public static long merge_sort_usecase(int[] arr,int len) {
		long count = 0;
		if(arr.length>1) {
			int mid = arr.length/2;
			int[] L = Arrays.copyOfRange(arr, 0, mid);
			int[] R = Arrays.copyOfRange(arr,mid,arr.length);
			count+=merge_sort_usecase(L, L.length);
			count+=merge_sort_usecase(R, R.length);
			int j=0,k=0,i=0;
			while(i<L.length && j<R.length) {
				if(L[i]<R[j]) {
					count+=L[i]*(R.length-j);
					arr[k]=L[i];
					i++;
					k++;
				}
				else {
					arr[k]=R[j];
					j++;
					k++;
				}}
				while(i<L.length) {
					arr[k]=L[i];
					i++;
					k++;
					
				}
				while(j<R.length) {
					arr[k]=R[j];
					j++;
					k++;
				}
			
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sf =new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 0; i < tot; i++) {
			int num = sf.nextInt();
			int[] al = new int[num];
			for (int j = 0; j < num; j++) {
				al[j]=sf.nextInt();
			}
			System.out.println(merge_sort_usecase(al,num));
		} 
		sf.close();
	}

}
