package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Flip {
	public static ArrayList<Integer> flip(String A) {
		int L = 0;
		int R = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(0);
		ans.add(0);
		int maxL = 0;
		int maxR = 0;
		int max = 0;
		int curr_max = 0;
		boolean isfound = false;
		while(R<A.length()) {
			if(A.charAt(R)=='0') {
				isfound = true;
				curr_max++;
				if(max<curr_max) {
					maxL = L;
					maxR = R;
					max = curr_max;
				}
				R++;
			}
			else {
				curr_max--;
				if(curr_max<0) {
					curr_max = 0;
					L = R+1;
					R++;
				}
				else {
					R++;
				}
			}
		}
		ans.set(0, maxL);
		ans.set(1, maxR);
		if(isfound) {
			return ans;
		}
		else {
			ans.clear();
			return ans;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		//int n = sf.nextInt();
		String A = "010";
		System.out.println(flip(A));
		sf.close();
	}

}
