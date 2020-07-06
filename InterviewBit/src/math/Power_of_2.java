package math;

public class Power_of_2 {
	public static int isPower(int A) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			int num = 1<<i;
			if((A&num)==A) {
				count++;
			}
		}
		if(count==1) {
			return 1;
		}
		return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPower(4));
	}

}
