package advanced_recursion;

import java.util.Scanner;

public class quick_sort {
	public static int partitioner(int[] input,int start,int end) {
		int pivot = input[start];
		int counter = start;
		for (int i = start+1; i < end; i++) {
			if(input[i]<pivot) {
				counter++;
				int temp = input[i];
				input[i]=input[counter];
				input[counter] = temp;
			}
		}
		int temp = pivot;
		input[start]=input[counter];
		input[counter] = temp;
		return counter;
	}
	public static void quickSort1(int[] input,int start,int end) {
		
		if(start<end-1) {
			int counter  = partitioner(input, start, end);
			quickSort1(input,start,counter);
			quickSort1(input,counter,end);
		}
		return;
	}
	public static void quickSort(int[] arr) {
		quickSort1(arr, 0, arr.length);
	}
	public static int[] takeInput(){
		Scanner s =new Scanner(System.in);
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		s.close();
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = takeInput();
		//quickSort(input);
		quickSort1(input, 0, input.length);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	}


