package medium;

import java.util.ArrayList;
/*
 * 22. Generate Parentheses
Medium

4663

248

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
/*
 * Approach we have to maintain count of open and closed brackets 
 * always open bracket should be grater or equal to closed brackets
 */
public class GenerateParenthisis {
	public static ArrayList<String> get(int n,int prevopen,int prevclose,ArrayList<String> list,String s1){
		if(prevopen>n || prevclose>n) {
			return null;
		}
		if(n==prevopen && n==prevclose) {
			list.add(s1);
		}
		if(prevopen==prevclose) {
			get(n, prevopen+1, prevclose, list, s1+"(");
		}
		else {
			get(n, prevopen+1, prevclose, list, s1+"(");
			get(n, prevopen, prevclose+1, list, s1+")");
		}
		return null;
	}
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		get(n, 0, 0, ans, "");
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(3));
	}

}
