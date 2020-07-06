package coding_ninjas;

import java.util.Scanner;

public class taj_mahal_entry {
	/*
	 * Taj Mahal Entry
Send Feedback
Taj Mahal is one of the seven wonders of the world. Aahad loves to travel places and wants to visit Taj Mahal. He visited Agra to view Taj Mahal. There is a ticketing system at Taj Mahal. There are total ‘n’ windows which provide the tickets to get entry into Taj Mahal. There are ‘Ai’ people already present at each window to get the tickets. Each window gives ticket to one person in one minute. Initially, Aahad stands in front of the first window. After each minute, if he didn’t get the ticket, he moves on to the next window to get the ticket. If he is at window 1, he will move to 2. If at 2nd, he will move to 3rd. If he is at last window, he will move to 1st again and so on. Find the window number at which he will get the ticket.
Input Format:
First line contains a single integer ‘n’ denoting the no. of windows.
Next line contains ‘n’ space separated integers denoting the no. of people already standing in front of the ith window. (1 <= i <= n)
Output Format:
Print a single integer denoting the window number that Aahad will get ticket from.
Constraints:
1 <= n <= 10^5
1 <= Ai <= 10^9
Sample Input:
4
2 3 2 0
Sample Output:
3
Explanation:
Aahad at Window 1: [2, 3, 2, 0]
Aahad at Window 2: [1, 2, 1, 0]
Aahad at Window 3: [0, 1, 0, 0]
So, when Aahad is at window 3, he got zero people before him. Hence, he will get the ticket at window 3.

	 */
	public static void binary_search_app(long[] arr) {
		/*
		 * in this approach we will use binary search
		 * for every arr[i] we can reach there in i + n*arr.lenth times 
		 * n can range from 0 onwards
		 * if for some n , i + n*arr> arr[i] that means we have got a 
		 * chance to get through this window
		 * so we will find the i + n*arr value for all the values in arr
		 * we will chose the minimum as that will show that is the minimum
		 * time to get at that position
		 */
		int min_i = 0;
		long min_val = 0;
		for (int i = 0; i < arr.length; i++) {
			long start = 0;
			long end = 1000000000;
			while(start<end) {
				long mid = (start+end)/2;
				if(i+mid*arr.length>=arr[i]) {
					end = mid-1;
					if(i==0) {
						min_i = i;
						min_val = i+mid*arr.length;
					}
					if(min_val>i+mid*arr.length) {
						min_i = i;
						min_val = i+mid*arr.length;
					}
					
				}
				else {
					start = mid+1;
				}
			}
		}
		System.out.println(min_i+1);
	}
	
	public static void find_w_zero(long[] arr) {
		int start = 0;
		int flag = 1;
		int min = 0;
		while(flag==1) {//looping till the arr-minutes <=0 this will give when he'll get chance
			if(arr[start]-min<=0) {
				System.out.println(start+1); 
				flag=0;
				break;
			}
			else {
				start++;
				if(start==arr.length) {
					start = 0;
				}
			}
			min++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int total = sf.nextInt();
		long[] list = new long[total];
		long min = 0;
		for (int i = 0; i < total; i++) {
			list[i]=sf.nextLong();
			if(i==0) {
				min = list[i];
			}
			if(list[i]<min) {
				min = list[i];
			}
		}
		if(min>0 && min>=total) {//this was added for optimization but for some cases it does not work when
			for (int i = 0; i < list.length; i++) {
				list[i] = list[i]-min;//we are subtracting minimum value as it will same number(min) iterations
			}
		}
		find_w_zero(list);
		binary_search_app(list);
		sf.close();
		
	}

}
