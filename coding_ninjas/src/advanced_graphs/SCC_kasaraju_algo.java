package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
/*
 * Approach to Find Strongly Connected Components
 * First we run DFS on Directed graph
 * We store the Vertices in Stack once all the posiblities to go to other verices are explored
 * we continue to do this till all the vertices are visited
 * then we need the transpose of the graph i.e. all the edges are reversed now
 * then we run DFS again starting from the elements in stack, if the element is not visited
 * in DFS function we continue to store the Connected component in ArrayList
 * we run this till stack empty
 */
public class SCC_kasaraju_algo {
	public static void DFS(int[][] edges, int start, int[] visited, Stack<Integer> holder) {
		visited[start] = 1;
		for (int i = 0; i < edges[start].length; i++) {
			if (edges[start][i] == 1 && visited[i] == 0) {
				DFS(edges, i, visited, holder);
			}
		}
		holder.push(start);
	}

	public static void DFS2(int[][] edges, int start, int[] visited, ArrayList<Integer> comp) {
		visited[start] = 1;
		comp.add(start);
		for (int i = 0; i < edges[start].length; i++) {
			if (edges[start][i] == 1 && visited[i] == 0) {
				DFS2(edges, i, visited, comp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		int E = sf.nextInt();
		int[][] edges = new int[N][N];
		int[][] edges_t = new int[N][N];
		for (int i = 0; i < edges_t.length; i++) {
			Arrays.fill(edges[i], 0);
			Arrays.fill(edges_t[i], 0);
		}
		for (int i = 0; i < E; i++) {
			int x = sf.nextInt();
			int y = sf.nextInt();
			edges[x][y] = 1;
			edges_t[y][x] = 1;
		}
		Stack<Integer> holder = new Stack<Integer>();
		int[] visited = new int[N];
		Arrays.fill(visited, 0);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				DFS(edges, i, visited, holder);
			}
		} // we are DFS on one side of graph
			// now will work on transpose of graph
		edges = null;
		Arrays.fill(visited, 0);
		ArrayList<ArrayList<Integer>> all_comp = new ArrayList<ArrayList<Integer>>();
		while (!holder.isEmpty()) {
			int temp = holder.pop();
			if (visited[temp] == 0) {
				ArrayList<Integer> temp_1 = new ArrayList<Integer>();
				DFS2(edges_t, temp, visited, temp_1);
				all_comp.add(temp_1);
			}
		}
		edges_t = null;
		visited = null;
		for (int i = 0; i < all_comp.size(); i++) {
			Collections.sort(all_comp.get(i));
			for (int j = 0; j < all_comp.get(i).size(); j++) {
				
				System.out.print(all_comp.get(i).get(j) + 1 + " ");
			}
			System.out.println();
		}
		all_comp = null;
		sf.close();
	}

}
