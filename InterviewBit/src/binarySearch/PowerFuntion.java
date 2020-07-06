package binarySearch;

public class PowerFuntion {
	public static long pow(int x, int n, int d) {
		if(n==0) {
			return 1;
		}
        long temp = pow(x, n/2, d);
        if(n%2==0) {
        	return (temp%d*temp%d)%d;
        }
        else {
        	return (temp%d*temp%d*x%d)%d;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2,4,100000003));
	}

}
