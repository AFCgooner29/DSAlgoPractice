package hard;
/*
 * 995. Minimum Number of K Consecutive Bit Flips
Hard

229

28

Add to List

Share
In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.

Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.

 

Example 1:

Input: A = [0,1,0], K = 1
Output: 2
Explanation: Flip A[0], then flip A[2].
Example 2:

Input: A = [1,1,0], K = 2
Output: -1
Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
Example 3:

Input: A = [0,0,0,1,0,1,1,0], K = 3
Output: 3
Explanation:
Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]
 

Note:

1 <= A.length <= 30000
1 <= K <= A.length
 */
public class MinKBitFlips_995 {
    public static int minKBitFlips(int[] A, int K) {
        int L = 0;
        int count = 0;
        while(L<A.length) {
        	//we can only flip if the current bit is 0
        	if(A[L]==0) {
        		//go on flipping till k elements if we go out of range then we need to return -1
        		//else we increase counter
        		int newL = L;
        		boolean found = false;
        		for (int i = L; i < L+K; i++) {
					if(i>=A.length) {
						return -1;//as we are going out of range while setting this zero to one
					}
					if(A[i]==0) {
						A[i] = 1;
					}
					else {
						A[i] = 0;
						if(!found) {
							newL = i;
							found = true;
						}
					}
				}
        		count++;
        		L = newL;
        	}
        	else {
        		L++;
        	}
		}
        return count;
        //complexity us O(N*K)
    }
    public static int minKBitFlipsFast(int[] A, int K) {
        //plan is to maintain till where we need to flip and we go on flipping in same
    	//loop so trying to make complexity O(N)j
    	int fliptill = -1;//-1 means we dont have to flip yet
    	//we are not able to handle multiple flips
    	int count = 0;
    	int curr = 0;
    	for (int i = 0; i < A.length; i++) {
    		if(fliptill<i) {
    			fliptill = -1;
    			curr = Math.max(0, curr-1);
    		}
			if(A[i]==0 && fliptill==-1 && curr%2==0) {
				fliptill = i+K-1;
				curr++;
				if(fliptill>=A.length) {
					return -1;
				}
				else {
					count++;
				}
			}
			else if(A[i]==1 && fliptill>=i && curr%2!=0) {
				fliptill = i+K-1;
				curr++;
				if(fliptill>=A.length) {
					return -1;
				}
				else {
					count++;
				}
			}
		}
    	return count;
    }
    public static int minKBitFlipsFastest(int[] A, int K) {
    	//approach is to maintain a window of K length
    	//curr will hold how many flips has happend for current window
    	//1 will be flipped if curr is odd , 0 will be flipped if curr is even
    	//from where ever we start flipping we are adding 2 to it
    	// we will know flipping started because the number is > 1
    	//if we cross that window we will decrease curr count
    	int cur = 0, res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                cur--;
                A[i - K] -= 2;
            }
            if (cur % 2 == A[i]) {
                if (i + K > n) return -1;
                A[i] += 2;
                cur++;
                res++;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,0,0,1,0,1,1,0};
	//	System.out.println(minKBitFlips(A, 3));
		System.out.println(minKBitFlipsFastest(A, 3));
	}

}
