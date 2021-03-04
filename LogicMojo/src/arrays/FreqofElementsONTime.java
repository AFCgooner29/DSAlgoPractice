package arrays;

/*Trick ques do check*/
public class FreqofElementsONTime {
	public static void freqCalculator(int[] arr) {
		int len = arr.length;
		for(int i = 0; i<len; i++) {
			int idx = (arr[i]%len)-1;
			arr[idx]+=len;
		}
		for(int i = 0; i<len; i++) {
			System.out.print("Number "+(i+1)+" is "+(arr[i]/len));
			arr[i] = arr[i]%len;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 1, 2, 5, 5, 5, 1, 1, 2, 2};
		freqCalculator(arr);
	}

}
