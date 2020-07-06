package graphs2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Dijkstra's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
Print the ith vertex number and the distance from source in one line separated by space. Print different vertices in different lines.
Note : Order of vertices in output doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
In different lines, ith vertex number and its distance from source (separated by space)
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 0
1 3
2 4
3 5

 */
/*
 * We will find min distance algo
 */
public class Dijkstra_algo {
	public static int getMinVer(int[] dist,int[] visited,int i) {
		int min = -1;
		for (int j = 0; j < visited.length; j++) {
			if(visited[j]==0 && ((min==-1) || dist[j]<dist[min])) {
				min = j;
			}
		}
		return min;
	}
	public static void djkistra(int[][] graph,int[] visited) {
		int[] dist = new int[graph.length];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		for (int i = 0; i < graph.length; i++) {
			int min_ver = getMinVer(dist, visited, i);
			visited[min_ver] = 1;
			for (int j = 0; j < graph.length; j++) {
				if(graph[min_ver][j]!=0 && visited[j]==0) {
					if(dist[min_ver]+graph[min_ver][j]<dist[j]) {
						dist[j] = dist[min_ver]+graph[min_ver][j];
					}
				}
			}
		}
		for (int i = 0; i < dist.length; i++) {
			System.out.println(i+" "+dist[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int V = sf.nextInt();
		int E = sf.nextInt();
		int[][] edges = new int[V][V];
		for (int i = 0; i < edges.length; i++) {
			Arrays.fill(edges[i],0);
		}
		for (int i = 0; i < E; i++) {
			int x = sf.nextInt();
			int y = sf.nextInt();
			int w = sf.nextInt();
			edges[x][y] = w;
			edges[y][x] = w;//intitailizing Adjacecncy matrix
		}
		int[] visited = new int[V];
		Arrays.fill(visited, 0);
		djkistra(edges,visited);
		sf.close();
	}

}
