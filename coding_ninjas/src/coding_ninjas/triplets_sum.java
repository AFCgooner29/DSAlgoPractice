package coding_ninjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class triplets_sum {
	public static void find_triplets_trivial(ArrayList<Integer> arr,int to_find) {
		int tot = arr.size();
		for(int i = 0 ; i<tot-2;i++) {
			for(int j = i+1;j<tot;j++) {
				for(int k = j+1;k<tot;k++) {
					if(arr.get(i)+arr.get(j)+arr.get(k)==to_find) {
						System.out.println(arr.get(i)+" "+arr.get(j)+" "+arr.get(k));
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sf = new Scanner(System.in);
		int tot= sf.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(tot);
		for(int i = 0; i<tot;i++) {
			arr.add(sf.nextInt());
		}
		Collections.sort(arr);
		int to_find = sf.nextInt();
		sf.close();
		find_triplets_trivial(arr,to_find);
	}

}


