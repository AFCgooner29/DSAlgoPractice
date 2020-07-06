package math;
/*
 * we use higher order base conversion to lower order base conversion
 * check hexadecimal to decimal conversion
 */
public class Excel_column {
	public int titleToNumber(String A) {
        int num = A.length()-1;
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
			int curr = A.charAt(i)-'A'+1;
			ans+=curr*Math.pow(26, num-i);
		}
        return ans;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
