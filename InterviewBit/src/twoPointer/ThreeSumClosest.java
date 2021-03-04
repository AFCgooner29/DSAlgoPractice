package twoPointer;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {
	public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int nearest = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size()-2; i++) {
        	int j = i+1;
            int k = A.size()-1;
            while(j<k) {
            	int sum = A.get(i)+A.get(k)+A.get(k);
            	if(Math.abs(sum-B)<min) {
            		min = Math.abs(sum-B);
            		nearest = sum;
            	}
            	if(sum<B) {
            		j++;
            	}
            	else if(sum>B) {
            		k--;
            	}
            	else {
            		return B;
            	}
            }
		}
        return nearest;
    }
	public static void main(String[] args) {
		
	}
}
