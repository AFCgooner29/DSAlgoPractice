package coding_ninjas;

import java.util.Arrays;
import java.util.Scanner;

public class inversion_count {
	public static long solve(int[] A,int n){
		long counter = 0;
		if(n>1) {
			int mid = n/2;
			int[] L = Arrays.copyOfRange(A,0,mid);
			int[] R = Arrays.copyOfRange(A,mid,A.length);
			counter+= solve(L,L.length);
			counter+= solve(R,R.length);
			int i=0,j=0,k = 0;
			while(i<L.length && j<R.length) {
				if(L[i]<=R[j]) {
					A[k]=L[i];
					i++;
					k++;	
				}
				else {
					A[k]=R[j];
					j++;
					k++;
					counter+=mid-i;
				}
			}
			while(i<L.length) {
				A[k]=L[i];
				i++;
				k++;
				
			}
			while(j<R.length) {
				A[k]=R[j];
				j++;
				k++;
				//counter++;
			}
			return counter;
		}
		return counter;
	}
	static int MAXN = 30;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {289837621,687176338,941575810,783231857,462056296,172999051,971906113,684533604,75682691,685306490,23633765,964542384,343752255,157473882,520596748,781207617,58240683,604998138,941111217,536943549,585033793,16112334,146772209,628477534,168738081,358041337,3914733,663306853,335392934,786330443};
		System.out.println(solve(ar, ar.length));
		
		Scanner scan = new Scanner(System.in);
		int n;
		int[] A = new int[MAXN];
		n = scan.nextInt();
		for(int i = 0; i < n ; i++){
			A[i] = scan.nextInt();
		}
		System.out.println(solve(A,n));

	}
	}


