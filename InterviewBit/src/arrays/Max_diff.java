package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Max_diff {
	public static int maximumGap(final ArrayList<Integer> A) {
        if(A.size()<2){
            return 0;
        }
        else if(A.size()==2){
            return Math.abs(A.get(0)-A.get(1));
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<A.size();i++){
            min = Math.min(A.get(i),min);
            max = Math.max(A.get(i),max);
        }
        int[] range = new int[max-min+1];
        Arrays.fill(range,0);
        for(int i = 0;i<A.size();i++){
            range[A.get(i)-min]++;
        }
        int max_diff = Integer.MIN_VALUE;
        int pre = -1;
        for(int i = 0;i<range.length;i++){
            if(range[i]>0 && pre==-1){
                pre = i;
            }
            else if(range[i]>0){
                max_diff = Math.max(i-pre,max_diff);
                pre = i;
            }
        }
        return max_diff;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(maximumGap(A));
		sf.close();
	}

}
