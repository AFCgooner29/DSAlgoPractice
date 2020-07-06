package coding_ninjas;

import java.util.Scanner;

public class Momos_market {
	public static void mom_buyer(int[] arr,int rem_money) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			rem_money-=arr[i];
			if(rem_money>=0) {
				count++;
			}
			else {
				rem_money+=arr[i];
				break;
			}
		}
		System.out.println(count+" "+rem_money);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int total_shops = sf.nextInt();
		int[] al = new int[total_shops];
		for (int i = 0; i < total_shops; i++) {
			al[i]=sf.nextInt();
		}
		
		int no_of_days = sf.nextInt();
		int[] rem_mon = new int[no_of_days];
		for (int i = 0; i < no_of_days; i++) {
			rem_mon[i]=sf.nextInt();
		}
		for (int i = 0; i < no_of_days; i++) {
			mom_buyer(al, rem_mon[i]);
		}
		sf.close();
	}

}
