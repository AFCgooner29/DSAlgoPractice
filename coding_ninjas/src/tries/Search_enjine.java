package tries;

import java.util.ArrayList;
/*
 * Search Engine
Send Feedback
Let us see how search engines work. Consider the following simple auto complete feature. When you type some characters in the text bar, the engine automatically gives best matching options among it's database. Your job is simple. Given an incomplete search text, output the best search result.
Each entry in engine's database has a priority factor attached to it. We consider a result / search suggestion best if it has maximum weight and completes the given incomplete search query. For each query in the input, print the maximum weight of the string in the database, that completes the given incomplete search string. In case no such string exists, print -1.
INPUT
First line contains two integers n and q, which represent number of database entries and number of search queries need to be completed. Next n lines contain a string s and an integer weight, which are the database entry and it's corresponding priority.

Next q lines follow, each line having a string t, which needs to be completed.
OUTPUT
Output q lines, each line containing the maximum possible weight of the match for given query, else -1, in case no valid result is obtained.
CONSTRAINTS
1 ≤ n, weight, len(s), len(t) ≤ 10^6
1 ≤ q ≤ 10^5
total length of all strings in database entries ≤ 10^6
total length of all query strings ≤ 10^6
SAMPLE INPUT
2 1
hackerearth 10
hackerrank 9
hacker
SAMPLE OUTPUT
10
 */
/*
 * Approach 
 * create tree for all the given trainer text
 * if the text is partially matching then we use updateTree method to update till it matches
 * when it stops matching we create a new branch from there using createTree method
 * then for quering we use query method which goes on and finds matching path till string is read fully
 * at each step we pass maxwt in ans variable ans we return ans when string length is 0
 */
import java.util.Scanner;

public class Search_enjine {
	public static class node {
		node left = null;
		node right = null;
		ArrayList<node> children = new ArrayList<node>();
		char value = '*';
		int maxwt = 0;
	}
	public static void createTree(String s1,int wt,node head) {
		if(s1.isEmpty()) {
			return;
		}
		
		node curr = head;
		curr.children.add(new node());
		curr.children.get(curr.children.size()-1).value = s1.charAt(0);
		curr.children.get(curr.children.size()-1).maxwt = wt;
		createTree(s1.substring(1), wt, curr.children.get(curr.children.size()-1));
	}
	public static void updateTree(String s1,int wt,node head) {
		if(s1.isEmpty()) {
			return;
		}
		node curr = head;
		int flag = 0;
		for (int i = 0; i < curr.children.size(); i++) {
			if(curr.children.get(i).value==s1.charAt(0)) {
				flag = 1;
				curr.children.get(i).maxwt = Math.max(curr.children.get(i).maxwt, wt);
				updateTree(s1.substring(1), wt, curr.children.get(i));
			}
		}
		if(flag==0) {
			createTree(s1, wt, curr);
		}
		
	}
	public static int query(node head,String s1,int ans) {
		if(s1.isEmpty()) {
			return ans;
		}
		node curr = head;
		for (int i = 0; i < curr.children.size(); i++) {
			if(curr.children.get(i).value==s1.charAt(0)) {
				return query(curr.children.get(i), s1.substring(1), curr.children.get(i).maxwt);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int train = sf.nextInt();
		int query = sf.nextInt();
		node head = new node();
		for (int i = 0; i < train; i++) {
			String s1 = sf.next();
			int vl = sf.nextInt();
			int flag = 0;
			if(head.children!=null) {
				for (int j = 0; j < head.children.size(); j++) {
					if(head.children.get(j)!=null && head.children.get(j).value==s1.charAt(0)) {
						flag = 1;
						updateTree(s1, vl, head);
					}
				}
			}
			if(flag==0) {
				createTree(s1, vl, head);
			}
		}
		for (int i = 0; i < query; i++) {
			String s1 = sf.next();
			System.out.println(query(head, s1, -1));
		}
		sf.close();
	}

}
