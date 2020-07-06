package arrays;

import java.util.ArrayList;

public class Spatial_matrix_2 {
	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < A; j++) {
				matrix.get(i).add(0);
			}
		}
		int rmax = A-1;
		int rmin = 0;
		int cmax = A-1;
		int cmin = 0;
		int num = 1;
		while(num!=(A*A)+1 && rmax>=rmin && cmax>=cmin) {
			//right
			for (int i = cmin; i <=cmax; i++) {
				matrix.get(rmin).set(i, num++);
			}
			rmin++;
			//down
			for (int i = rmin; i <=rmax; i++) {
				matrix.get(i).set(cmax, num++);
			}
			cmax--;
			//left
			for (int i = cmax; i >=cmin; i--) {
				matrix.get(rmax).set(i, num++);
			}
			rmax--;
			//up
			for (int i = rmax; i >=rmin; i--) {
				matrix.get(i).set(cmin, num++);
			}
			cmin++;
		}
		return matrix;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> matrix = generateMatrix(4);
		for (int i = 0; i < matrix.size(); i++) {
			System.out.println(matrix.get(i));
		}
	}

}
