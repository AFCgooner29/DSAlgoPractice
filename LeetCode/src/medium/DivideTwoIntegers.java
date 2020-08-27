package medium;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		int start = Math.min(0,divisor);
        boolean isNeg = false;
        if(dividend<0) {
        	isNeg = true;
        	dividend = dividend*-1;
        }
        int end = dividend*divisor;
        while(start<end) {
        	int mid = start + (end-start)/2;
        	if(mid*divisor>dividend) {
        		end = mid-1;
        	}
        	else if(mid*divisor<dividend) {
        		start=mid+1;
        	}
        	else {
        		if(isNeg) {
                	return -1*(mid);
                }
        		return mid;
        	}
        }
        if(isNeg) {
        	return -1*(start-1);
        }
        return start-1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(7,-3));
	}

}
