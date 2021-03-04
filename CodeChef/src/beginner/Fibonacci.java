package beginner;

public class Fibonacci {
	static long[] fib;
	public static long fiboRec(int n) {
		if(n==1) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		if(fib[n]!=0)return fib[n];
		long val = fiboRec(n-1)+fiboRec(n-2);
		fib[n] = val;
		return val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib = new long[51];
		System.out.println(fiboRec(50));
	}

}
