package dynamic_prg1; 

import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change_Problem {
	public static long countWaysToMakeChange3(int denominations[], int value,long[][] store){
		if(value==0) {
			return 1;
		}
		else if(value<0) {
			return 0;
		}
		else if(denominations.length==0) {
			return 0;
		}
		if(store[denominations[0]][value]>0) {
			return store[denominations[0]][value];
		}
		long fir = countWaysToMakeChange3(denominations, value-denominations[0], store);
		long sec = countWaysToMakeChange3(Arrays.copyOfRange(denominations,1,denominations.length), value, store);
		store[denominations[0]][value]=fir+sec;
		return fir+sec;
	}
	public static void countWaysToMakeChange2(int denominations[], int value,int[] num_of_ways){
		if(value==0) {
			num_of_ways[0]++;
			return;
		}
		else if(value<0) {
			return;
		}
		else if(denominations.length==0) {
			return;
		}
		countWaysToMakeChange2(denominations, value-denominations[0], num_of_ways);
		countWaysToMakeChange2(Arrays.copyOfRange(denominations,1,denominations.length), value, num_of_ways);
		
	}
	public static void countWaysToMakeChange(int denominations[], int value,int[] num_of_ways){

		/*Your class should be named Solution.
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Don’t print output, instead return it.
		*/			
		if(value==0) {
			num_of_ways[0]++;
			return;
		}
		else if(value<0) {
			return;
		}
		for (int i = 0; i < denominations.length; i++) {
			countWaysToMakeChange(denominations, value-denominations[i], num_of_ways);
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		int[] den = new int[tot];
		
		for (int i = 0; i < den.length; i++) {
			den[i] = sf.nextInt();
		}
		int value = sf.nextInt();
		long[][] store = new long[Arrays.stream(den).max().getAsInt()+1][value+1];
		//int[] numofways = {0};
		//countWaysToMakeChange2(den,value,numofways);
		System.out.println(countWaysToMakeChange3(den, value, store));
		//System.out.println(numofways[0]);
		sf.close();
	}

}
