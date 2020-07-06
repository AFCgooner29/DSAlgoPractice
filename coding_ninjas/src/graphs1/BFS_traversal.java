package graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Code : BFS Traversal
Send Feedback
Given an undirected and connected graph G(V, E), print its BFS traversal.
Here you need to consider that you need to print BFS path starting from vertex 0 only.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Note : 1. Take graph input in the adjacency matrix.
2. Handle for Disconnected Graphs as well
Input Format :
Line 1: Two Integers V and E (separated by space)
Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.
Output Format :
BFS Traversal (separated by space)
Constraints :
2 <= V <= 1000
1 <= E <= 1000
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2
 */
public class BFS_traversal {
	public static void main(String[] args) {
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
		int[] visited = new int[n];
		Arrays.fill(visited, 0);
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(0);
		int i = 0;
		while(!qu.isEmpty()) {
			i = qu.poll();
			System.out.println(i);
			visited[i]=1;
			int j = 0;
			while(j<n) {
				if(graph[i][j]==1 && visited[j]!=1) {
					qu.add(j);
					visited[j] = 1;
				}
				j++;
			}
			if(qu.isEmpty()) {
				for (int j2 = 0; j2 < visited.length; j2++) {
					if(visited[j2]==0) {
						qu.add(j2);
						visited[j2] = 1;
						break;
					}
				}
			}
		}
		sf.close();
	}
}
