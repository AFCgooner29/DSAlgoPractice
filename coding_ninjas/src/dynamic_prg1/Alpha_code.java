package dynamic_prg1;

import java.util.Scanner;
/*
 * AlphaCode-Question
Send Feedback
Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:
Alice: “Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26.”

Bob: “That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!”

Alice: “Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?”

Bob: “OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense.”

Alice: “How many different decodings?”

Bob: “Jillions!”
For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
Input
Input will consist of multiple input sets. Each set will consist of a single line of at most 5000 digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of ‘0’ will terminate the input and should not be processed.
Output
For each input set, output the number of possible decodings for the input string. Print your answer taking modulo "10^9+7"
Sample Input:
25114
1111111111
3333333333
0
Sample Output:
6
89
1
 */
public class Alpha_code {
	public static long finder(long num) {
		if(num<=9) {
			return 1;
		}
		long out = finder(num/10);
		if(num%100<26) {
			out+=finder(num/100);
		}
		long mod = (long)Math.pow(10, 9) +7;
		return out%mod;
	}
	public static long finder2(String num,long[] arr) {
		if(num.length()<=1) {
			if(num.length()==1 && Integer.parseInt(num)<1) {
				return 0;
			}
			return 1;
		}
		if(arr[num.length()]>0) {
			return arr[num.length()];
		}
		if(!num.substring(0,1).equals("0")) {
			long out = finder2(num.substring(1),arr);
			if(Integer.parseInt(num.substring(0,2))<=26 ) {
				out+=finder2(num.substring(2),arr);
			}
			long mod = (long)Math.pow(10, 9) +7;
			arr[num.length()]=out%mod;
			return arr[num.length()];
		}
		else {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int flag = 0;
		while(flag!=1) {
			String num = sf.next();
			if(num.equals("0")) {
				break;
			}
			long[] arr = new long[num.length()+1];
			//System.out.println(finder(num));
			System.out.println(finder2(num,arr));
		}
		
		sf.close();
	}

}
