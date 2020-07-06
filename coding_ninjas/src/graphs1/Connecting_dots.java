package graphs1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Connecting Dots
Send Feedback
Gary has a board of size NxM. Each cell in the board is a coloured dot. 
There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). 
Now Gary is getting bore and wants to play a game. The key of this game is to find 
a cycle that contain dots of same colour. Formally, we call a sequence of
 dots d1, d2, ..., dk a cycle if and only if it meets the following condition:
1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task is to determine if there 
exists a cycle on the board.
Assume input to be 0-indexed based.
Input Format :
Line 1 : Two integers N and M, the number of rows and columns of the board
Next N lines : a string consisting of M characters, expressing colors of dots in 
each line. Each character is an uppercase Latin letter.
Output Format :
Return 1 if there is a cycle else return 0
Constraints :
2 ≤ N, M ≤ 50
Sample Input :
3 4
AAAA
ABCA
AAAA
Sample Output :
1
 */
public class Connecting_dots {
	/*
	 * Approach is to go from start point and go on checking for same letter
	 * at adjacent nodes but we wont go back to initx and intity but
	 * if we have found at least four 4 elements then we cang go to initx and intiy or we can move further
	 * till we find some node which is adjacent to initx and inity
	 * we unmark every node in visited array so that future iterations can use that node
	 * to find answer
	 */
	public static void finder(String[][] graph,int x,int y,int initx,int inity,int k,String s1,int[][] visited) {
		if(x==initx && y==inity && k==0) {
			graph[0][0] = "1";
			visited[x][y] = 0;
			return;
		}
		if(x<0 || x==graph.length || y<0 || y==graph[0].length || visited[x][y]==1) {
			return;
		}
		if(k!=0) {
			if(graph[x][y].equals(s1) && visited[x][y] == 0) {
				visited[x][y] = 1;
				finder(graph, x+1, y,initx,inity, k-1, s1, visited);
				finder(graph, x, y+1,initx,inity, k-1, s1, visited);
				finder(graph, x, y-1,initx,inity, k-1, s1, visited);
				finder(graph, x-1, y,initx,inity, k-1, s1, visited);
				visited[x][y] = 0;//we are doing this because we can use this index for future findings
				//but for current iteration we should not come back to this point
			}
		}
		else {
			if(x==initx && y==inity) {
				graph[0][0] = "1";
				visited[x][y] = 0;
				return;
			}
			else if(graph[x][y].equals(s1) && visited[x][y] == 0) {
				visited[x][y] = 1;
				finder(graph, x+1, y,initx,inity, k, s1, visited);
				finder(graph, x, y+1,initx,inity, k, s1, visited);
				finder(graph, x, y-1,initx,inity, k, s1, visited);
				finder(graph, x-1, y,initx,inity, k, s1, visited);
				visited[x][y] = 0;//we are doing this because we can use this index for future findings
				//but for current iteration we should not come back to this point
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		String[][] graph= new String[n][m];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = sf.next().split("");
		}
		int[][] visited = new int[n][m];
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], 0);
		}
		outer: for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if(visited[i][j]==0) {
					finder(graph, i, j, i, j, 4,graph[i][j], visited);
				}
				if(graph[0][0].equals("1")) {
					break outer;
				}
			}
		}
		if(graph[0][0].equals("1")) {
			System.out.println(1);
		}
		else {
			System.out.println("0");
		}
		sf.close();

	}

}
