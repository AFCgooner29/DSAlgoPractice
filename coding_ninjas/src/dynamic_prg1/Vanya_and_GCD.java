package dynamic_prg1;

import java.util.ArrayList;
import java.util.Scanner;

public class Vanya_and_GCD {
	public static void checker(int[] input,int index, ArrayList<ArrayList<Integer>> ans) {
		if(index==input.length) {
			return;
		}
		checker(input, index + 1, ans);
		int sel = input[index];
		if(!ans.isEmpty()) {
			int size  = ans.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp = ans.get(i);
				temp.add(sel);
				ans.add(temp);
			}
		}
		else {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(sel);
			ans.add(temp);
		}
		checker(input, index+1, ans);
		return;
	} 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] input= new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sf.nextInt();
		}
		checker(input, 0 ,ans);
		System.out.println(ans);
		sf.close();
	}

}
