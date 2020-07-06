package dynamic_prg1;

import java.util.Scanner;

public class Fibo_series {
	public static long fibo(int num,long[] ans) {
		if(num==1) {
			ans[1] = 1;
			return 1;
		}
		else if(num==0) {
			ans[0] = 0;
			return 0;
		}
		if(ans[num]>0) {
			return ans[num];
		}
		ans[num] = fibo(num-1,ans)+fibo(num-2,ans);
		return ans[num];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int num = sf.nextInt();
		long[] ans = new long[num+1];
		System.out.println(fibo(num,ans));
		sf.close();
	}

}
