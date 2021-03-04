package september;

import java.util.Arrays;

public class MaxProductArr {
    public static int maxProduct(int[] nums) {
    	if(nums.length==1)return nums[0];
        int maxProd = 0;
        int minProdCurr = 0;
        int maxProdCurr = 0;
        for (int i = 0; i < nums.length; i++) {
        	/* we need to handle every element value differently*/
			if(nums[i]<0) {
				int temp = minProdCurr;
				minProdCurr = Math.min(maxProdCurr*nums[i], nums[i]);
				maxProdCurr = Math.max(temp*nums[i], nums[i]);
			}
			else if(nums[i]>0) {
				minProdCurr = Math.min(minProdCurr*nums[i], nums[i]);
				maxProdCurr = Math.max(maxProdCurr*nums[i], nums[i]);
			}
			else {
				maxProd = Math.max(maxProd, maxProdCurr);
				minProdCurr = nums[i];
				maxProdCurr = nums[i];
			}
			maxProd = Math.max(maxProd, maxProdCurr);
		}
        return maxProd;
    }
    public static int maxProduct2(int[] nums) {
    	if(nums.length==1)return nums[0];
        int maxProd = 0;
        int minProdCurr = 0;
        int maxProdCurr = 0;
        for (int i : nums) {
        	/*
        	 * We basically need to fix max current with current value or just set current value
        	 * Min current with using current value or just current value
        	 * then set the maxProd
        	 */
        	int tmp = minProdCurr;
        	minProdCurr = Math.min(i, Math.min(maxProdCurr*i, minProdCurr*i));
        	maxProdCurr = Math.max(i, Math.max(maxProdCurr*i, tmp*i));
        	maxProd = Math.max(maxProd, maxProdCurr);
		}
        return maxProd;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,-1,-1,-1};
		System.out.println(maxProduct(arr));
	}

}
