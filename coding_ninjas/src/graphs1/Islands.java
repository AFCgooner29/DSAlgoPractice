package graphs1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Islands
Send Feedback
An island is a small piece of land surrounded by water . 
A group of islands is said to be connected if we can reach from any given island to 
any other island in the same group . Given N islands (numbered from 1 to N) and two lists 
of size M (u and v) denoting island u[i] is connected to island v[i] and vice versa . 
Can you count the number of connected groups of islands.
Constraints :
1<=N<=100
1<=M<=(N*(N-1))/2
1<=u[i],v[i]<=N
Input Format :
Line 1 : Two integers N and M
Line 2 : List u of size of M
Line 3 : List v of size of M
Output Return Format :
The count the number of connected groups of islands
Sample Input :
2 1
1
2
Sample Output :
1 
 */
public class Islands {
	public static void DFS(int[][] graph,int start,int[] visited) {
		visited[start] = 1;
		for (int i = 1; i < visited.length; i++) {
			if(graph[start][i]==1 && visited[i]==0) {
				DFS(graph, i, visited);
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		int[] visited = new int[n+1];
		Arrays.fill(visited, 0);
		int[][] graph = new int[n+1][n+1];
		int[][] M = new int[m][2];
		for (int i = 0; i < M.length; i++) {
			M[i][0] = sf.nextInt();
		}
		for (int i = 0; i < M.length; i++) {
			M[i][1] = sf.nextInt();
		}
		for (int i = 0; i < M.length; i++) {
			graph[M[i][0]][M[i][1]] = 1;
			graph[M[i][1]][M[i][0]] = 1;
		}
		int count = 0;
		for (int i = 1; i < visited.length; i++) {
			if(visited[i]==0) {
				DFS(graph, i, visited);
				count++;
			}
		}
		System.out.println(count);
		sf.close();
	}

}
