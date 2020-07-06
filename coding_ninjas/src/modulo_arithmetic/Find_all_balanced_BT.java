package modulo_arithmetic;

public class Find_all_balanced_BT {
	public static long find(long h,int mod) {
		if(h<=1) {
			return 1;
		}
		long resx = find(h-1,mod);
		long res1 = (resx*resx)%mod;
		long res2 = (2*resx*find(h-2,mod))%mod;
		return (res1 + res2)%mod;
				}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mod = (int)Math.pow(10, 9)+7;
		System.out.println(find(6,mod));
	}

}
