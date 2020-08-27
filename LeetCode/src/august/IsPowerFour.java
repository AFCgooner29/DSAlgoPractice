package august;

public class IsPowerFour {
	public static boolean isPowerOfFour(int num) {
        int number = 0;
        int lastFound = -1;
		for (int i = 0; i <32; i++) {
			if(((num)&(1<<i))==(1<<i)) {
				number++;
				lastFound = i;
			}
		}
		if(number==1 && lastFound!=-1) {
			if(lastFound%2==0) {
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(1));
	}

}
