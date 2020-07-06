package greedy_approach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Interval_merging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		ArrayList<ArrayList<Integer>> intervals = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(sf.nextInt());
			temp.add(sf.nextInt());
			intervals.add(temp);
		}
		Collections.sort(intervals,new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> arg0, ArrayList<Integer> arg1) {
				// TODO Auto-generated method stub
				if(arg0.get(0)<arg1.get(0) && arg0.get(1)>=arg1.get(0)) {
					return -1;
				}
				else if(arg0.get(0)>arg1.get(0)) {
					return 1;
				}
				return 0;
			}
		});
		int start = -1;
		int end = 0;
		System.out.println(intervals);
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>(); 
		for (int i = 0; i < intervals.size()-1; i++) {
			if(intervals.get(i).get(1)>intervals.get(i+1).get(0) && i+1<intervals.size()-1) {
				if(start==-1) {
					start = i;
				}
				end = i+1;
				if(intervals.get(i).get(1)>intervals.get(i+1).get(1)) {
					intervals.get(i+1).set(1, intervals.get(i).get(1));
				}
			}
			else {
				if(start!=-1 && end!=0) {
					intervals.get(start).set(1,intervals.get(end).get(1));
					result.add(intervals.get(start));
				}
				start = -1;
				end = 0;
			}
			
			//update
			
			
		}
		System.out.println(result);
		sf.close();
	}

}
