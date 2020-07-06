package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Rotate_matrix {
	
	public static void rotateFaster(ArrayList<ArrayList<Integer>> a) {
		int y = a.size()-1;
		int x = 0;
		while(y>=0 && x<a.size()) {
			int tempy = y-1;
			int tempx = x+1;
			while(tempx!=a.size()&& tempy!=-1) {
				//we need to swap x,tempy and tempx,y
				int temp = a.get(x).get(tempy);
				a.get(x).set(tempy, a.get(tempx).get(y));
				a.get(tempx).set(y,temp);
				tempx++;
				tempy--;
			}
			y--;
			x++;
 		}
	}
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		for (int i = 0; i < a.size()/2; i++) {
			//these are the number of cycle in Matrix we have to rotate through these cycles
			int row_max = a.size()-i;
			int row_start = i;
			int col_start = i;
			int col_end = a.size()-i;
			int mid = row_max - row_start;
			for (int z = 0; z < mid-1; z++) {
				//right
				int temp = a.get(row_start).get(col_start);
				for (int j = col_start+1; j < col_end; j++) {
					int emp = a.get(row_start).get(j);
					a.get(row_start).set(j,temp);
					temp = emp;
				}
				//down
				for (int j = row_start+1; j < row_max; j++) {
					int emp = a.get(j).get(col_end-1);
					a.get(j).set(col_end-1,temp);
					temp = emp;
				}
				//left
				for (int j = col_end-2; j >=col_start; j--) {
					int emp = a.get(row_max-1).get(j);
					a.get(row_max-1).set(j,temp);
					temp = emp;
				}
				//up
				for (int j = row_max-2; j >= row_start; j--) {
					int emp = a.get(j).get(col_start);
					a.get(j).set(col_start,temp);
					temp = emp;
				}
		}
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			a.add(new ArrayList<Integer>());
			for (int j = 0; j < m; j++) {
				a.get(i).add(sf.nextInt());
			}
		}
		rotateFaster(a);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a.get(i).get(j)+" ");
			}
			System.out.println();
		}
		sf.close();
	}

}
