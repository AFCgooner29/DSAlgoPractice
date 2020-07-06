package graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
Note : Save the input graph in Adjacency Matrix.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
Line (E+2) : Two integers v1 and v2 (separated by space)
Output Format :
Path from v1 to v2 in reverse order (separated by space)
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
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
 */
public class Code_Get_Path_BFS {
	public static void BFS(int[][] graph,int start,int end) {
		int[] parentVertice = new int[graph.length];
		Queue<Integer> qu = new LinkedList<Integer>();
		int[] visited = new int[graph.length];
		Arrays.fill(visited, 0);
		qu.add(start);
		visited[start] = 1;
		while(!qu.isEmpty()) {
			int s = qu.poll();
			visited[s] = 1;
			for (int i = 0; i < visited.length; i++) {
				if(graph[s][i]==1 && visited[i]==0) {
					visited[i] = 1;
					qu.add(i);
					parentVertice[i] = s;
					if(i==end) {
						int j = i;
						System.out.print(i+" ");
						while (j!=start) {
							System.out.print(parentVertice[j]+" ");
							j = parentVertice[j];
						}
						break;
					}
				}
			}
			/*
			 * if(qu.isEmpty()) { for (int i = 0; i < visited.length; i++) {
			 * if(visited[i]==0) { qu.add(i); visited[i] = 1; break; } } }
			 */
		}
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
		sf.close();
	}

}
