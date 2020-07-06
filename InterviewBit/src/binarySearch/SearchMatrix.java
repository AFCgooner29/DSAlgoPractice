package binarySearch;

import java.util.ArrayList;

public class SearchMatrix {
	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
		int start = 0;
        int end = A.get(0).size()*A.size()-1;
        while(start<=end) {
        	int mid = start+(end-start)/2;
        	int val = A.get(mid/A.get(0).size()).get(mid%A.get(0).size());
        	if(val>B) {
        		end = mid-1;
        	}
        	else if(val<B) {
        		start = mid+1;
        	}
        	else {
        		return 1;
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
