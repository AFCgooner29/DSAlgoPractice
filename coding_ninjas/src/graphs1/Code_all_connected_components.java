package graphs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * Code : All connected components
Send Feedback
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.
Output Format :
Different components in new line
Constraints :
2 <= V <= 1000
1 <= E <= 1000
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1 
2 3 
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
0 1 3 
2
 */
public class Code_all_connected_components {
	public static void DFS(int[][] graph,int start,int[] visited, ArrayList<Integer> to_fill) {
		visited[start] = 1;
		to_fill.add(start);
		for (int i = 0; i < visited.length; i++) {
			if(graph[start][i]==1 && visited[i]==0) {
				//System.out.print(i+" ");
				DFS(graph, i, visited,to_fill);
			}
		}
	}
	public static void listprinter(ArrayList<Integer> al) {
		if(al!=null) {
			for (int i = 0; i < al.size(); i++) {
				System.out.print(al.get(i)+" ");
			}
			System.out.println();
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
		int[] visited = new int[graph.length];
		Arrays.fill(visited, 0);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		DFS(graph, 0, visited,temp);
		Collections.sort(temp);
		listprinter(temp);
		temp.clear();
		System.out.println();
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]==0) {
				DFS(graph, i, visited,temp);
				Collections.sort(temp);
				listprinter(temp);
				temp.clear();;
			}
		}
		sf.close();
	}

}
