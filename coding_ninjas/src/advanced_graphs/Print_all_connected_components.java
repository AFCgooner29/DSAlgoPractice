package advanced_graphs;

import java.util.Arrays;
import java.util.Scanner;

public class Print_all_connected_components {
	public static void DFS(int[][] graph,int start,int[] visited) {
		visited[start] = 1;
		System.out.print(start+" ");
		for (int i = 0; i < graph[start].length; i++) {
			if(graph[start][i]!=0 && visited[i]==0) {
				DFS(graph, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		int E = sf.nextInt();
		int[][] graph = new int[N][N];
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}
		for (int i = 0; i < E; i++) {
			int x = sf.nextInt();
			int y = sf.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		int[] visited = new int[N];
		Arrays.fill(visited, 0);
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]==0) {
				DFS(graph, i, visited);
				System.out.println();
			}
		}
		sf.close();
	}

}
