package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Hotel Bookings Possible
Asked in:  
Goldman Sachs
Microsoft
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
Example :

Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room. 

 */
public class Hotel_booking_possible {
	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		/*ArrayList<ArrayList<Integer>> F = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> book = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < arrive.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(arrive.get(i));
			temp.add(depart.get(i));
			book.add(temp);
		}
		Collections.sort(book,new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.get(0)>o2.get(0)) {
					return 1;
				}
				return 0;
			}
		});*/
		Collections.sort(arrive);
		Collections.sort(depart);
		int L = 0;
		for (int i = 0; i <arrive.size(); i++) {
			System.out.println("People stauing currently "+(i+1-L));
			while(i!=L && depart.get(L)<=arrive.get(i)) {
				L++;
			}
			if(i+1-L>K) {
				return false;
			}
			
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> ARR = new ArrayList<Integer>();
		ArrayList<Integer> DEP = new ArrayList<Integer>();
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			ARR.add(sf.nextInt());
		}
		for (int i = 0; i < n; i++) {
			DEP.add(sf.nextInt());
		}
		System.out.println(hotel(ARR, DEP, sf.nextInt()));
		sf.close();
	}

}
