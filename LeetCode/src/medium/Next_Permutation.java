package medium;
import java.util.ArrayList;
/*
 * Approach
 * According to Wikipedia, a man named Narayana Pandita presented the following simple algorithm to solve this problem in the 14th century.

Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
Find the largest index l > k such that nums[k] < nums[l].
Swap nums[k] and nums[l].
Reverse the sub-array nums[k + 1:].
 */
/*
 * Leetcode approach explain
 * Approach 2: Single Pass Approach
Algorithm

First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. For example, no next permutation is possible for the following array: [9, 5, 4, 3, 1]

We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right, which satisfy a[i] > a[i-1]a[i]>a[i−1]. Now, no rearrangements to the right of a[i-1]a[i−1] can create a larger permutation since that subarray consists of numbers in descending order. Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.

Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just larger than the current one. Therefore, we need to replace the number a[i-1]a[i−1] with the number which is just larger than itself among the numbers lying to its right section, say a[j]a[j].
We swap the numbers a[i-1]a[i−1] and a[j]a[j]. We now have the correct number at index i-1i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i-1]a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.

But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]. Thus, all numbers to the right of a[i-1]a[i−1] were already sorted in descending order. Furthermore, swapping a[i-1]a[i−1] and a[j]a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i-1]a[i−1] to get the next smallest lexicographic permutation.

The following animation will make things clearer:

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
 */

public class Next_Permutation {
	public void nextPermutation1(int[] A) {
		int n = A.length;
        int k,j;
        for (k = n-2; k>=0 ; k--) {
			if(A[k]<A[k+1]) {
				break;//found largest k where num[k]<num[k+1]
			}
		}
        j = k+1;
        while(j<n) {
        	if(A[k]<A[j]) {
        		j++;
        	}
        }
        j--;
        swap1(A, k, j);
        reverse1(A, k+1, j-1);
    }
	public static void swap(ArrayList<Integer> A, int start,int end) {
		int temp = A.get(start);
		A.set(start, A.get(end));
		A.set(end, temp);
	}
	public static void reverse(ArrayList<Integer> A, int start,int end) {
		while(start<end) {
			swap(A, start, end);
			start++;
			end--;
		}
	}
	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        int k,j;
        for (k = n-2; k>=0 ; k--) {
			if(A.get(k)<A.get(k+1)) {
				break;//found largest k where num[k]<num[k+1]
			}
		}
        j = k+1;
        while(j<n) {
        	if(A.get(k)<A.get(j)) {
        		j++;
        	}
        }
        j--;
        swap(A, k, j);
        reverse(A, k+1, j-1);
        return A;
        
    }
	public static void swap1(int[] A, int start,int end) {
		int temp = A[start];
		A[start]= A[end];
		A[end]= temp;
	}
	public static void reverse1(int[] A, int start,int end) {
		while(start<end) {
			swap1(A, start, end);
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
