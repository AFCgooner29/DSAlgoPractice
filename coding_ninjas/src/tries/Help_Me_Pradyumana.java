package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
 * Help Me Pradyumana!
Send Feedback
Pradyumn is tired of using auto - correct feature in his smartphone. He needs to correct his auto - correct more times than the auto - correct corrects him. Pradyumn is thinking to make his own app for mobile which will restrict auto - correct feature, instead it will provide auto - completion. Whenever Pradyumn types factorial, auto - correct changes it to fact. Pradyumn's App will show options such as fact, factorial, factory. Now, he can chose from any of these options. As Pradyumn is busy with his front - end work of his App. He asks you to help him. He said "You will be given set of words(words may repeat too but counted as one only). Now, as user starts the app, he will make queries(in lowercase letters only). So, you have to print all the words of dictionary which have the prefix same as given by user as input. And if no such words are available, add this word to your dictionary." As you know, Pradyumn want this app to be as smart as him :P So, implement a program for him such that he can release it on Fun Store.
INPUT CONSTRAINTS
1≤N≤30000
sum(len(string[i]))≤2∗10^5
1≤Q≤10^3
INPUT FORMAT
Single integer N which denotes the size of words which are input as dictionary
N lines of input, where each line is a string of consisting lowercase letter
Single integer Q which denotes the number of queries.
Q number of lines describing the query string on each line given by user
OUTPUT FORMAT
If auto - completions exists, output all of them in lexicographical order else output "No suggestions" without quotes

NOTE: All strings are lowercase
SAMPLE INPUT
3
fact
factorial
factory
2
fact
pradyumn
SAMPLE OUTPUT
fact
factorial
factory
No suggestions
 */
/*
 * need to change the code
 */
public class Help_Me_Pradyumana {

	public static class node {
		node left = null;
		node right = null;
		ArrayList<node> children = new ArrayList<node>();
		char value = '*';
		boolean endsHere = false;
	//	int maxwt = 0;
	}
	public static void createTree(String s1,node head) {
		if(s1.isEmpty()) {
			head.endsHere = true;
			return;
		}
		
		node curr = head;
		curr.children.add(new node());
		curr.children.get(curr.children.size()-1).value = s1.charAt(0);
	//	curr.children.get(curr.children.size()-1).maxwt = wt;
		createTree(s1.substring(1), curr.children.get(curr.children.size()-1));
	}
	public static void updateTree(String s1,node head) {
		if(s1.isEmpty()) {
			return;
		}
		node curr = head;
		int flag = 0;
		for (int i = 0; i < curr.children.size(); i++) {
			if(curr.children.get(i).value==s1.charAt(0)) {
				flag = 1;
		//		curr.children.get(i).maxwt = Math.max(curr.children.get(i).maxwt, wt);
				updateTree(s1.substring(1), curr.children.get(i));
			}
		}
		if(flag==0) {
			createTree(s1, curr);
		}
		
	}
	public static void query(String s1,node head,int flag,String ans,ArrayList<String> filler) {
		if(head.children.isEmpty()) {
			if(s1.isEmpty()) {
				filler.add(ans);
			}
			return;
		}
		if(s1.isEmpty() && flag==0) {
			if(head.endsHere) {
				filler.add(ans);
			}
			query(s1, head, 1, ans, filler);
			return;
		}
		if(flag==0) {
			for (int i = 0; i < head.children.size(); i++) {
				if(s1.length()>0 && head.children.get(i).value == s1.charAt(0)) {
					query(s1.substring(1), head.children.get(i), flag, ans+s1.substring(0,1),filler);
				}
			}
		}
		else {
			//we need to traverse all the trees that can be formed from here
			for (int i = 0; i < head.children.size(); i++) {
				query(s1, head.children.get(i), flag, ans+head.children.get(i).value, filler);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int train = sf.nextInt();
		node head = new node();
		for (int i = 0; i < train; i++) {
			String s1 = sf.next();
		//	int vl = sf.nextInt();
			int flag = 0;
			if(head.children!=null) {
				for (int j = 0; j < head.children.size(); j++) {
					if(head.children.get(j)!=null && head.children.get(j).value==s1.charAt(0)) {
						flag = 1;
						updateTree(s1, head);
					}
				}
			}
			if(flag==0) {
				createTree(s1, head);
			}
		}
		int query = sf.nextInt();
		for (int i = 0; i < query; i++) {
			String s1 = sf.next();
			int flag = 0;
			for (int j = 0; j < head.children.size(); j++) {
				if(head.children.get(j).value == s1.charAt(0)) {
					flag = 1;
					break;
				}
			}
			ArrayList<String> ans = new ArrayList<String>();
			if(flag==1) {
				query(s1, head, 0, "", ans);
			}
			else {
				System.out.println("No suggestions");
				createTree(s1, head);
				continue;
			}
			Collections.sort(ans);
			for (int j = 0; j < ans.size(); j++) {
				System.out.println(ans.get(j));
			}
		}
		sf.close();
	}

}
