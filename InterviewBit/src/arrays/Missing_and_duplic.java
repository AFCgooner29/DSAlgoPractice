package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Missing_and_duplic {
	public static ArrayList<Integer> repeatedNumber(final ArrayList<Integer> A) {
		//we can use this if changing the given list is allowed
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0;i<A.size();i++){
        	int curr = Math.abs(A.get(i));
            if(A.get(curr-1)<0){
                ans.add(curr);
            }
            A.set(curr-1, -1*Math.abs(A.get(curr-1)));
        }
        for(int i = 0;i<A.size();i++){
            if(A.get(i)>0){
                ans.add(i);
            }
        }
        return ans;
    }
	public static void repeatedNumber2(final ArrayList<Integer> A) {
		//we can use maths here we can have summ of all elements in sum
		//ideally this array should be AP of difference 1 so sum is n/2(2*a + (n-1)d) = n(n+1)/2
		//we need hashmap to find duplucate then we can subtract duplicate from diff of sums 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(repeatedNumber(A));
	}

}
