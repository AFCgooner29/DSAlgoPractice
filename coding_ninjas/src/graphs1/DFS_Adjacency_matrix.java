package graphs1;

import java.util.Arrays;
import java.util.Scanner;
/*
 * We will make a matrix that will contain data for 
 * form current node which node is connected using edge
 * then we go to that node
 * to avoid making cyclic graph we store which nodes are visited and
 * we do not go that node again
 */
public class DFS_Adjacency_matrix {
	public static void print(int[][] graph,int n,int curr,int[] visited) {
		System.out.print(curr+" ");
		visited[curr]=1;
		for (int i = 0; i < graph.length; i++) {
			if(graph[curr][i]==1 && visited[i]==0) {
				print(graph, n, i,visited);
			}
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
		int[] visited = new int[n];
		Arrays.fill(visited, 0);
		print(graph,n,0,visited);
		sf.close();
	}

}
