package bit_manipulation;

public class Odd_one_out {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,2,2,1,555556,1,55555,55555,55555};
		String[] bitwise = new String[10];
		for (int i = 0; i < arr.length; i++) {
			String s1 = Integer.toBinaryString(arr[i]);
			bitwise[i] = "00000000000000000000000000000000".substring(s1.length())+s1;
		}
		String ans = new String();
		for (int i = 0; i < 32; i++) {
			int noof0 = 0;
 			for (int j = 0; j < bitwise.length; j++) {
				if(bitwise[j].substring(i, i+1).equals("0")) {
					noof0++;
				}
			}
 			if(noof0%3!=0) {
 				ans = ans+"0";
 			}
 			else {
 				ans = ans+"1";
 			}
		}
		System.out.println(Integer.parseInt(ans, 2));
	}

}
