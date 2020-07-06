package greedy_approach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Activity_Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tot = sf.nextInt();
		ArrayList<ArrayList<Integer>> inp = new ArrayList<ArrayList<Integer>>(); 
		for (int i = 0; i < tot; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(sf.nextInt());
			temp.add(sf.nextInt());
			inp.add(temp);
		}
		Collections.sort(inp,new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				if(o1.get(1)>o2.get(1)) {
					return 1;
				}
				else if(o1.get(1)<o2.get(1)) {
					return -1;
				}
				return 0;
			}
			
		});
		int ans = 1;
		for (int i = 0; i < inp.size()-1; i++) {
			if(inp.get(i).get(1)<=inp.get(i+1).get(0)) {
				ans++;
			}
			else {
				inp.get(i+1).add(1, inp.get(i).get(1));
			}
		}
		System.out.println(ans);
		sf.close();
	}

}
