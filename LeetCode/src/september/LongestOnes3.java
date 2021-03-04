package september;
//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
public class LongestOnes3 {
	public int longestOnes(int[] A, int K) {
        int j = 0;
        int i = 0;
        while(i<A.length){
            if(A[i]==0){
                K--;
            }
            if(K<0){
                if(A[j]==0){
                    K++;
                }
                j++;
            }
            i++;
        }
        return i-j;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
