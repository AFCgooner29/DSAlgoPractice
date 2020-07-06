package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_one {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 0;
        while(A.size()>1 && A.get(0)==0) {
        	A.remove(0);
        }
        for(int i = A.size()-1;i>=0;i--){
            if(i==A.size()-1){
                int dig = A.get(i);
                dig++;
                if(dig>9){
                    dig = 0;
                    carry = 1;
                }
                A.set(i, dig);
            }
            else{
                int dig = A.get(i);
                dig = dig + carry;
                carry = 0;
                if(dig>9){
                    dig = 0;
                    carry = 1;
                }
                A.set(i, dig);
            }
        }
        if(carry>0){
            A.add(0,carry);
        }
        return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		for (int i = 0; i < n; i++) {
			A.add(sf.nextInt());
		}
		System.out.println(plusOne(A));
		sf.close();
	}

}
