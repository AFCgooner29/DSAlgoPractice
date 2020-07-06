package codejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Alica_and_bob {
	public static class freq_idx{
		int freq = 1;
		int idx = 0;
		public freq_idx(int fr,int pos) {
			freq = fr;
			idx = pos;
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int no_of_test = sf.nextInt();
		for (int i = 0; i < no_of_test; i++) {
			int n = sf.nextInt();
			int k = sf.nextInt();
			ArrayList<Long> alic = new ArrayList<Long>();
			ArrayList<Long> bob = new ArrayList<Long>();
			for (int j = 0; j < n; j++) {
				long val = sf.nextInt();
				alic.add(val);
				bob.add(val);
			}
			Collections.sort(bob);
			for (int j = 1; j < n; j++) {
				//bob.set(j, bob.get(j)+bob.get(j-1));
				alic.set(j, alic.get(j)+alic.get(j-1));
			}
			ArrayList<freq_idx> freq_arr = new ArrayList<freq_idx>();
			for (int j = 0; j < n; j++) {
				freq_arr.add(new freq_idx(0, j));
			}
			long bob_sum = 0;
			long alic_sum = 0;
			int[][] all_freq = new int[k][2];
			for (int j = 0; j < k; j++) {
				int start = sf.nextInt();
				int end = sf.nextInt();
				all_freq[j][0]=start;
				all_freq[j][1]=end;
				freq_arr.get(start - 1).freq++;
				if (end != n) 
					freq_arr.get(end).freq--;
				start-=2;
				end-=1;
				if(start>=0) {
				//	bob_sum+= bob.get(end)-bob.get(start);
					alic_sum+= alic.get(end)-alic.get(start);
				}
				else {
				//	bob_sum+= bob.get(end);
					alic_sum+= alic.get(end);
				}
			}
			for (int j = 1; j < n; j++) {
				freq_arr.get(j).freq = freq_arr.get(j).freq + freq_arr.get(j - 1).freq;
			}
			Collections.sort(freq_arr,new Comparator<freq_idx>() {
				@Override
				public int compare(freq_idx o1, freq_idx o2) {
					// TODO Auto-generated method stub
					if(o1.freq>o2.freq) {
						return 1;
					}
					else if(o1.freq<o2.freq) {
						return -1;
					}
					return 0;
				}
			});
			ArrayList<Long> new_bob = new ArrayList<Long>();
			for (int j = 0; j < n; j++) {
				new_bob.add((long) -1);
			}
			for (int j = freq_arr.size()-1; j >=0; j--) {
				new_bob.set(freq_arr.get(j).idx, bob.get(j));
			}
			for (int j = 1; j < n; j++) {
				//bob.set(j, bob.get(j)+bob.get(j-1));
				new_bob.set(j, new_bob.get(j)+new_bob.get(j-1));
			}
			for (int j = 0; j < all_freq.length; j++) {
				int start = all_freq[j][0]-2;
				int end = all_freq[j][1]-1;
				if(start>=0) {
						bob_sum+= new_bob.get(end)-new_bob.get(start);
					//	alic_sum+= alic.get(end)-alic.get(start);
					}
					else {
						bob_sum+= new_bob.get(end);
					//	alic_sum+= alic.get(end);
					}
			}
			System.out.println(bob_sum-alic_sum);
		}
		sf.close();
	}

}
