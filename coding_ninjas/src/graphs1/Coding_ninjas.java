package graphs1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Coding Ninjas
Send Feedback
Given a NxM matrix containing Uppercase English Alphabets only. 
Your task is to tell if there is a path in the given matrix which makes the 
sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. 
A neighbour may share an edge or a corner.
Input Format :
Line 1 : Two space separated integers N  and M, where N is number of rows and 
M is number of columns in the matrix.
Next N lines : N rows of the matrix. First line of these N line will contain 
0th row of matrix, second line will contain 1st row and so on
Assume input to be 0-indexed based
Output Format :
Return 1 if there is a path which makes the sentence “CODINGNINJA” else return 0.
Constraints :
1 <= N <= 100
1 <= M <= 100
Sample Input :
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output :
1       
 */
public class Coding_ninjas {
	public static void finder(String[][] s1, String s2,int x,int y, int[][] visited) {
		if(s2.isEmpty()) {
			s1[0][0] = "1";
			return;
		}
		if(x<0 || x==s1.length || y<0 || y==s1[0].length || visited[x][y]==1 ) {
			return;
		}
		else if(s2.substring(0,1).equals(s1[x][y])) {
			visited[x][y] = 1;
			finder(s1, s2.substring(1), x+1, y, visited);
			finder(s1, s2.substring(1), x, y+1, visited);
			finder(s1, s2.substring(1), x, y-1, visited);
			finder(s1, s2.substring(1), x-1, y, visited);
			finder(s1, s2.substring(1), x+1, y+1, visited);
			finder(s1, s2.substring(1), x-1, y-1, visited);
			finder(s1, s2.substring(1), x+1, y-1, visited);
			finder(s1, s2.substring(1), x-1, y+1, visited);
		}
     return;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		String[][] graph = new String[n][m];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = sf.next().split("");
		}
		int[][] visited = new int[n][m];
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i],0);
		}
		int x = 0;
		int y = 0;
		outer : for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j].equals("C")) {
					x = i;
					y = j;
					finder(graph, "CODINGNINJA", x, y, visited);//because if we can't make string using first C found
					//then we should look for other C in graph and try out with that
					if(graph[0][0].equals("1")) {
						break outer;
					}
				}
			}
		}
		if(graph[0][0].equals("1")) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		sf.close();
	}

}
