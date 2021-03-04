package arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {
	public static int divideHelper(int[] arr,int left,int right) {
		int pivot = arr[right];
		int i = left;
		int j = right-1;
		boolean change = false;
		while(i<j) {
			while(i<j && arr[i]<=pivot)i++;
			while(i<j && arr[j]>pivot)j--;
			if(i<j) {
				change = true;
				swap(arr,i,j);
			}
		}
		if(change)
			swap(arr,j,right);
		
		return j;
	}
	public static void swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void quickSort(int[] arr,int left, int right) {
		if(left>=right)return;
		int idx = divideHelper(arr, left, right);
		quickSort(arr, left, idx-1);
		quickSort(arr, idx+1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  arr = {1,5,12,1,23,4,5,6,12,3,53,234,23,54,123,2,6,62,2,2321,21,3,341};
		quickSort(arr, 0, arr.length-1);
		for(int i : arr) {
			System.out.print(i+" ");
		}
		try {
			System.out.println();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		List<Object> hp = new LinkedList<Object>();
		Collection<Integer> hel = Collections.synchronizedCollection(new ArrayList<Integer>());
	}

}
