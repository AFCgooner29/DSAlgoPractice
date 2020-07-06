package coding_ninjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class chef_rest {

	public static int finder(ArrayList<ArrayList<Long>> A,int point) {
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		Long[][] al =new Long[3][2];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				al[i][j] = sf.nextLong();
			}
		}
		Arrays.sort(al,new Comparator<Long[]>(){
			public int compare(Long[] a,Long[] b) {
				return a[0]<b[0]?-1:1;
			}
		});
		//Arrays.binarySearch(a, key);
		sf.close();}	

}
