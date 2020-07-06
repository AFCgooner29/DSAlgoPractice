package dp_with_bitmasking;
/*
 * Dilemma
Send Feedback
Abhishek, a blind man recently bought N binary strings all of equal length .A binary string only contains '0's and '1's . The strings are numbered from 1 to N and all are distinct, but Abhishek can only differentiate between these strings by touching them. In one touch Abhishek can identify one character at a position of a string from the set. Find the minimum number of touches T Abhishek has to make so that he learn that all strings are different .
Constraints :
2<=N<=10
1<=|L|<=100 , L is length of the strings .
Input Format:
Line 1 : An Integer N, denoting the number of binary strings .
Next N lines : strings of equal length
Output Format:
Return the minimum number of touches
Sample Input :
2
111010
100100
Sample Output :
2
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Diellema {
	public static class node{
		node right;
		node left;
		ArrayList<String> lot = new ArrayList<String>();
	}
	public static int finder(node head) {
		if(head.lot.size()<2 || head.lot.get(0).isEmpty()) {
			return 0;
		}
		int ans = 0;
		int ans2 = 0;
		for (int i = 0; i < head.lot.size(); i++) {
			if(head.lot.get(i).charAt(0)=='0') {
				if(head.right==null) {
					head.right = new node();
					head.right.lot.add(head.lot.get(i).substring(1));
				}
				else {
					head.right.lot.add(head.lot.get(i).substring(1));
				}
			}
			else {
				if(head.left==null) {
					head.left = new node();
					head.left.lot.add(head.lot.get(i).substring(1));
				}
				else {
					head.left.lot.add(head.lot.get(i).substring(1));
				}
			}
		}
		if(head.right!=null && head.left!=null) {
			ans+=finder(head.right);
			ans2+=1+finder(head.left);
		}
		else if(head.right!=null) {
			ans+=1+finder(head.right);
		}
		else if(head.left!=null) {
			ans2+=1+finder(head.left);
		}
		return ans + ans2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		node head = new node();
		for (int i = 0; i < n; i++) {
			head.lot.add(sf.next());
		}
		System.out.println(finder(head));
		sf.close();
	}

}
