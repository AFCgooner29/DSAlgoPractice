package dynamic_prg1;

public class Adjacent_Bit_Counts {
	public static int finder(int n,int k,int bit) {
		if(n==1) {
			if(k==1) {
				return 1;
			}
			return 0;
		}
		if(k<0) {
			return 0;
		}
		
		if(bit==0) {
			return finder(n-1, k, 1)+finder(n-1, k, 0);
		}
		else {
			return finder(n-1, k-1, 1)+finder(n-1, k, 0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(finder(5, 2, 0)+finder(5, 2, 1));
	}

}
