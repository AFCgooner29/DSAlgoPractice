package binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixMedian {
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.size(); i++) {
			min = Math.min(min, A.get(i).get(0));
			max = Math.max(max, A.get(i).get(A.get(0).size()-1));
		}
		int start = min;
		int end = max;
		int tot = (A.size()*A.get(0).size()+1)/2;
		int found=0;
		while(start<=end) {
			int mid = start + (end-start)/2;
			for (int i = 0; i < A.size(); i++) {
				int get;
				get=Collections.binarySearch(A.get(i),mid);
				if(get<0) {
					found+=Math.abs(get)-1;
				}
				else {
					found+=get;
				}
			}
			if(found>tot) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return found;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
