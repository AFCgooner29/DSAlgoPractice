package easy;
/*
 * one more way of doing this is by doing n & (n-1) == 0 or not
 * as power of 2 will only have one bit set n-1 will have just but old bit unset
 */
public class PowerOf2 {
    public static boolean isPowerOfTwo(int n) {
    	if(n<0)return false;
        int count = 0;
        for (int i = 0; i < 32; i++) {
			if((n & (1<<i))==n) {
				count++;
			}
		}
        if(count==1)return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(218));
		//-2147483648
	}

}
