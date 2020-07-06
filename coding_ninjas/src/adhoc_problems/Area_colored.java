package adhoc_problems;

import java.util.Scanner;

public class Area_colored {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[] al = new int[10000];
		for (int i = 0; i < tot; i++) {
			int breadth = sf.nextInt();
			int hght = sf.nextInt();
			for (int j = 0; j < breadth; j++) {
					if(al[j]<hght) {
						al[j]=hght;
					}
				}
			}
		int sum = 0;
		for (int i = 0; i < al.length; i++) {
			if(al[i]>0) {
			sum=sum+al[i];}
		}
		System.out.println(sum);
		sf.close();
			//we will create a hiegt array and then 
		}
	}


