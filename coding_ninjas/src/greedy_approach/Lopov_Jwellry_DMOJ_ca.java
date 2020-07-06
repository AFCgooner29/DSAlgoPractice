package greedy_approach;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lopov_Jwellry_DMOJ_ca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int k = sf.nextInt();
		int[][] store = new int[n][2];
		
		int[]  bags_temp = new int[k];
		for (int i = 0; i < store.length; i++) {
			store[i][0] = sf.nextInt();
			store[i][1] = sf.nextInt();
		}
		int max_bag = 0;
		for (int i = 0; i < k; i++) {
			bags_temp[i] = sf.nextInt();
			max_bag = Math.max(max_bag, bags_temp[i]);
		}
		int[] bags = new int[max_bag+1];
		Arrays.fill(bags, 0);
		for (int i = 0; i < bags_temp.length; i++) {
			bags[bags_temp[i]]++;
		}
		bags_temp = null;
		sf.close();
		Arrays.parallelSort(store, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				if(arg0[1]<arg1[1]) {
					return 1;
				}
				else if(arg0[1]>arg1[1]) {
					return -1;
				}
				return 0;
			}
		});
		int val =0;
		//sort the bags by size and use binary search to find upper bound value in bags arr
		//fill that bag  we should use multi set read online and implement
		for (int i = 0; i < store.length; i++) {
			for (int j = store[i][0]; j < bags.length; j++) {//instead of this we can do binary search
				if(bags[j]>0) {
					bags[j]--;
					val=store[i][1];
				}
			}
		}
		System.out.println(val);
	}

}
