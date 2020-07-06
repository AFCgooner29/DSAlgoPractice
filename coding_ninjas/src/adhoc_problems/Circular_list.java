package adhoc_problems;

import java.util.Scanner;

public class Circular_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		for (int i = 0; i < tot; i++) {
			int count = 0;
			int start = sf.nextInt();
			if(start==11) {
				start = 0;
			}
			else {
				start++;
			}
			int end = sf.nextInt();
			int flag = 1;
			while (flag!=0) {
				count++;
				if(count==end) {
					System.out.println(start);
					break;
				}
				if(start==11) {
					start=0;
					continue;
				}
				start++;
			}
		}
		sf.close();
	}

}
