package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Min_steps_in_infinite_grid {
	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int tot_steps = 0;
		for (int i = 0; i < A.size()-1; i++) {
			int x = Math.abs(A.get(i)-A.get(i+1));
			int y = Math.abs(B.get(i)-B.get(i+1));
			int dist = Math.max(x, y);//we are doing max because we can move diagonal as well
			//so if we move diagonal we can reach till min of x and y then we are left with remaining
			//horizontal and veritcal steps total steps are equal to Max(x,y)
			tot_steps+=dist;
		}
		return tot_steps;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf  = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			A.add(sf.nextInt());
			B.add(sf.nextInt());
		}
		System.out.println(coverPoints(A, B));
		sf.close();
	}

}
