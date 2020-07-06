package graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), check if there exists any path between them or not. Print true or false.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
Line (E+2) : Two integers v1 and v2 (separated by space)
Output Format :
true or false
Constraints :
2 <= V <= 1000
1 <= E <= 1000
0 <= v1, v2 <= V-1
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false
 */
public class Code_Has_Path {
	public static void DFS(int[][] graph,int start,int end,int[] visited, String[] ans) {
		visited[start] = 1;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]==0 && graph[start][i]==1) {
				if(end==i) {
					ans[0] = "true";
					return;
				}
				DFS(graph, i, end, visited,ans);
			}
		}
		return;
	}
	public static void BFS(int[][] graph,int start,int end) {
		int[] visited =new  int[graph.length];
		Arrays.fill(visited, 0);
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(start);
		visited[start] = 1;
		String ans = "false";
		while(!qu.isEmpty()) {
			int i = qu.poll();
			visited[i] = 1;
			for (int j = 0; j < visited.length; j++) {
				if(graph[i][j]==1 && visited[j]!=1) {
					qu.add(j);
					visited[j] = 1;
					if(j==end) {
						ans = "true";
						break;
					}
				}
			}
			if(ans.equals("true")) {
				break;
			}
			/*
			 * else if(qu.isEmpty()) { for (int j = 0; j < visited.length; j++) {
			 * if(visited[j]==0) { qu.add(j); visited[j] = 1; break; } } }
			 */
		}
		System.out.println(ans);
		
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int e = sf.nextInt();
		int[][] graph = new int[n][n];
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}
		for (int i = 0; i < e; i++) {
			int from = sf.nextInt();
			int to = sf.nextInt();
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		int start = sf.nextInt();
		int end = sf.nextInt();
		BFS(graph, start, end);
		/*
		 * int[] visited =new int[graph.length]; Arrays.fill(visited, 0); String[] ans =
		 * new String[1]; ans[0] = "false"; DFS(graph, start, end, visited, ans);
		 * System.out.println(ans[0]);
		 */
		sf.close();
	}

}
