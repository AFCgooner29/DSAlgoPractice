package binarySearch;
/*
 * Approach check tushar roy's video on youtube
 * 
 * we have to split the small array such that we find the median
 * if we find some thing in first array
 * if we have arr1 has all big items we move the partX to left to the start of arr1
 * if we have arr1 has all small items we move the partX to right to the end of arr1
 * partY can be calculated partX+partY = (a.size()+b.size()+1)/2
 * check this video https://www.youtube.com/watch?v=LPFhl65R7ww
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Median_of_Arr {
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(b.size()<a.size()){
            return findMedianSortedArrays(b,a);
        }
        int tot = (a.size()+b.size()+1)/2;
        int start = 0;
        int end = a.size();
        int partX = 0;
        int partY = 0;
        while(start<=end) {
        	partX = start + (end-start)/2;
        	partY = tot-partX;
        	int leftX = (partX==0) ? Integer.MIN_VALUE : a.get(partX-1);
        	int rightX = (partX==a.size()) ? Integer.MAX_VALUE : a.get(partX);
        	int leftY = (partY==0) ? Integer.MIN_VALUE : b.get(partY-1);
        	int rightY = (partY==b.size()) ? Integer.MAX_VALUE : b.get(partY);
        	if(leftX<=rightY && leftY<=rightX) {
        		if((a.size()+b.size())%2==0) {
        			return ((double)Math.max(leftX,leftY)+Math.min(rightX, rightY))/2;
        		}
        		else {
        			return (double)Math.max(leftX, leftY);
        		}
        	}
        	else if(leftX>rightY) {
        		end = partX -1;
        	}
        	else {
        		start =  partX+1;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(sf.nextInt());
		}
		for (int i = 0; i < m; i++) {
			b.add(sf.nextInt());
		}
		System.out.println(findMedianSortedArrays(a, b));
	}

}
