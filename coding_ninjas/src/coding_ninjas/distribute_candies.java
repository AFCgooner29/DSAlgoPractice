package coding_ninjas;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Distribute Candies
Send Feedback
Shaky has N (1<=N<=50000) candy boxes each of them contains a non-zero number of candies (between 1 and 1000000000). Shaky want to distibute these candies among his K (1<=K<=1000000000) IIIT-Delhi students. He want to distibute them in a way such that:
1. All students get equal number of candies.
2. All the candies which a student get must be from a single box only.
As he want to make all of them happy so he want to give as many candies as possible. Help Shaky in finding out what is the maximum number of candies which a student can get.
Input
First line contains 1<=T<=20 the number of test cases. Then T test cases follow. First line of each test case contains N and K. Next line contains N integers, ith of which is the number of candies in ith box.
Output
For each test case print the required answer in a seperate line.
Sample Input:
2
3 2 
3 1 4
4 1
3 2 3 9
Sample Output:
3
9

 */
public class distribute_candies {
	public static void distributer(long[] arr,int no_of_students) {
		long result = 0;
		if(arr.length==1) {
			result = arr[0]/no_of_students;
			System.out.println(result);
		}
		else if(no_of_students==1) {
			result = Arrays.stream(arr).max().getAsLong();
			System.out.println(result);
		}
		else {
			Arrays.parallelSort(arr);
			long[] needed_arr = Arrays.copyOfRange(arr, arr.length-no_of_students, arr.length);
			result = needed_arr[0];
			System.out.println(result);
		}
	}
	public static boolean checker(long[] arr,int no_of_students,long check) {
		int stu = 0;// this function is checking for the check value if that 
					//number of candies can be distributed to children or not
		for (int i = 0; i < arr.length; i++) {
			stu+=arr[i]/check;
			if(stu>=no_of_students) {
				return true;
			}
		}
		return false;
	}
	public static void dist_2(long[] arr,int no_of_students) {
		long end = Arrays.stream(arr).max().getAsLong();
		long start = 0;
		long res = 0;
		/*
		 * whenever there is a distribution problem always look for binary search solutions
		 * this is the solution 
		 * we are checking for 0 to max of arr
		 * we use binary search to search to check if mid number of toffees can be distributed
		 * then we use binary search to find the best option
		 */
		while(start<end) {
			long mid = (start+end)/2;
			if(checker(arr, no_of_students, mid)) {
				start = mid+1;
				res = mid;
			}
			else {
				end = mid;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf =new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 0; i < tot; i++) {
			int no_of_boxes = 0;
			int no_of_students = 0;
			no_of_boxes = sf.nextInt();
			no_of_students =sf.nextInt();
			long[] al = new long[no_of_boxes];
			for (int j = 0; j < no_of_boxes; j++) {
				al[j]=sf.nextLong();
			}
			dist_2(al, no_of_students);	
			
		}
		
		sf.close();
	}

}
