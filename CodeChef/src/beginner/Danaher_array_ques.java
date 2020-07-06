package beginner;


import java.util.Scanner;

public class Danaher_array_ques {
	public static void right_rotate(int[] arr) {
		for (int i = arr.length-1; i >0; i--) {
			int temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void left_rotate(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sf.nextInt();
		}
		int q = sf.nextInt();
		for (int i = 0; i < q; i++) {
			String s1 = sf.next();
			int sec = 0;
			int thi = 0;
			if(s1.equals("Increment")) {
				sec = sf.nextInt();
				arr[sec]++;
			}
			else if(s1.equals("Left")) {
				left_rotate(arr);
			}
			else if(s1.equals("Right")) {
				right_rotate(arr);
			}
			else if(s1.equals("?")) {
				sec = sf.nextInt();
				System.out.println(arr[sec]);
			}
			else if(s1.equals("Update")) {
				sec = sf.nextInt();
				thi = sf.nextInt();
				arr[sec]  = thi;
			}
		}
		sf.close();
	}

}
