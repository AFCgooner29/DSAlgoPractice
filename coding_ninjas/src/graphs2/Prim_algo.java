package graphs2;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Prim's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format -
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
MST
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 1 3
1 2 1
0 3 5
 */
/*
 * Approach
 * from every vertice we are finding the minimum edge which we can reach in min_ver
 * from that min_ver we find what all places can be reached which are not visited
 * then to reach that vertice from min_ver if the wieght is less than already calculated
 * then we update the wieght to reach that j vertice and update the parent to min_ver
 * as from min_ver we can reach j in less wieght
 * calclulate for all the vertices like this
 */
public class Prim_algo {
	public static int getMinVer(int[] wieght,int[] visited,int i) {
		int min = -1;
		for (int j = 0; j < visited.length; j++) {
			if(visited[j]==0 && ((min==-1) || wieght[j]<wieght[min] && visited[j]==0)) {
				min = j;
			}
		}
		return min;
	}
	public static void prims(int[][] graph,int[] visited) {
		int[] parent = new int[graph.length];
		int[] wieght = new int[graph.length];
		Arrays.fill(wieght, Integer.MAX_VALUE);
		parent[0] = -1;
		wieght[0] = 0;
		for (int i = 0; i < graph.length; i++) {
			//get min vertex from ith vertex which is unvisited
			int min_ver = getMinVer(wieght,visited,i);
			visited[min_ver] = 1;// we are finding the minimum cost unvisited vertice from the current i
			// and we make sure that vertice will be part of the MST
			for (int j = 0; j < graph.length; j++) {//this can be replaced with adjacency list that will imporve the eficiency
				if(graph[min_ver][j]!=0 && visited[j]==0) {
					if(wieght[j]>graph[min_ver][j]) {
						wieght[j] = graph[min_ver][j];
						parent[j] = min_ver;
					}
				}
			}
			
		}
		for (int i = 1; i < wieght.length; i++) {
			if(parent[i]<i) {
				System.out.println(parent[i]+" "+i+" "+wieght[i]);
			}
			else {
				System.out.println(i+" "+parent[i]+" "+wieght[i]);
			}
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
		prims(edges,visited);
		sf.close();
	}

}
