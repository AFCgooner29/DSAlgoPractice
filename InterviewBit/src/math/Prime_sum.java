package math;

import java.util.ArrayList;

public class Prime_sum {
	public ArrayList<Integer> primesum(int A) {
        int[] arr = new int[A];
        for (int i = 2; i < arr.length; i++) {
        	if(arr[i]==0) {
        		for (int j = i+i; j < arr.length; j=j+i) {
        			arr[j] = 1;
    			}
        	}
		}
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < arr.length; i++) {
			if(arr[i]==0) {
				primes.add(i);
			}
		}
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int j = primes.size()-1;
        while(i<=j) {
        	int sum = primes.get(i)+primes.get(j);
        	if(sum<A) {
        		i++;
        	}
        	else if(sum>A){
        		j--;
        	}
        	else {
        		ans.add(primes.get(i));
        		ans.add(primes.get(j));
        		break;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
