package dynamic_prg1;

import java.util.Arrays;
import java.util.Scanner;

public class Roy_and_Coin_Boxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf =new Scanner(System.in);
		int num_of_box = sf.nextInt();
		int num_days = sf.nextInt();
		int[] boxes = new int[num_of_box];
		Arrays.fill(boxes, 0);
		for (int i = 0; i < num_days; i++) {
			int start = sf.nextInt();
			int end = sf.nextInt();
			for (int j = start-1; j <end; j++) {
				boxes[j]++;
			}
		}
		int[] exact = new int[Arrays.stream(boxes).max().getAsInt()+1];
		for (int i = 0; i < boxes.length; i++) {
			exact[boxes[i]]++;
		}
		int[] atleast = new int[Arrays.stream(boxes).max().getAsInt()+1];
		for (int i = exact.length-1; i >0; i--) {
			if(i==exact.length-1) {
				atleast[i]=exact[i];
			}
			else {
				atleast[i] = exact[i]+atleast[i+1];
			}
		}
		int queries = sf.nextInt();
		Arrays.parallelSort(boxes);
		for (int i = 0; i < queries; i++) {
			int check = sf.nextInt();
			if(check>=atleast.length) {
				System.out.println(0);
			}
			else {
				System.out.println(atleast[check]);
			}
		}
		sf.close();
	}

}
