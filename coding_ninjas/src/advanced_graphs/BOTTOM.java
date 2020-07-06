package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * BOTTOM
Send Feedback
We will use the following (standard) definitions from graph theory.
 Let V be a non-empty and finite set, its elements being called vertices (or nodes).
  Let E be a subset of the Cartesian product V×V, its elements being called edges.
   Then G=(V,E) is called a directed graph.

Let n be a positive integer, and let p=(e1,…,en) be a sequence of length 
n of edges ei∈E such that ei=(vi,vi+1)for a sequence of vertices (v1,…,vn+1).
 Then p is called a path from vertex v1 to vertex vn+1 in G and we say that vn+1 
 is reachable from v1, writing (v1→vn+1).

Here are some new definitions. A node v in a graph G=(V,E) is called 
a sink, if for every node w in G that is reachable from v, v is also reachable from w.
 The bottom of a graph is the subset of all nodes that are sinks, i.e.,
  bottom(G)={v∈V∣∀w∈V:(v→w)⇒(w→v)}. You have to calculate the bottom of certain graphs.
Input Specification
The input contains several test cases, each of which corresponds to a directed graph G. 
Each test case starts with an integer number v, denoting the number of vertices 
of G=(V,E) where the vertices will be identified by the integer numbers in the 
set V={1,…,v}. You may assume that 1≤v≤5000. That is followed by a non-negative 
integer e and, thereafter, e pairs of vertex identifiers v1,w1,…,ve,we with the 
meaning that (vi,wi)∈E. There are no edges other than specified by these pairs. 
The last test case is followed by a zero.
Output Specification
For each test case output the bottom of the specified graph on a single line. 
To this end, print the numbers of all nodes that are sinks in sorted order 
separated by a single space character. If the bottom is empty, print an empty line.
Sample Input
3 3
1 3 2 3 3 1
2 1
1 2
0
Sample Output
1 3
2
 */
/*
 * Approach is to find all the strongly connected components and then in each component
 * all vertices will be bottom except which has a edge going out to some other component
 * Note if there's any vertices which goes out some other component then that whole component 
 * elements can't be bottom
 */

public class BOTTOM {
	public static void DFS(int[][] edges, int start, int[] visited, Stack<Integer> holder) {
		visited[start] = 1;
		for (int i = 1; i < edges[start].length; i++) {
			if (edges[start][i] == 1 && visited[i] == 0) {
				DFS(edges, i, visited, holder);
			}
		}
		holder.push(start);
	}
	public static void DFS2(int[][] edges, int start, int[] visited, ArrayList<Integer> comp) {
		visited[start] = 1;
		comp.add(start);
		for (int i = 1; i < edges[start].length; i++) {
			if (edges[start][i] == 1 && visited[i] == 0) {
				DFS2(edges, i, visited, comp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		while(true) {
			int N = sf.nextInt();
			if(N==0) {
				break;
			}
			int E = sf.nextInt();
			int[][] edges = new int[N+1][N+1];
			int[][] edges_t = new int[N+1][N+1];
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
			int[] visited = new int[N+1];
			Arrays.fill(visited, 0);
			for (int i = 1; i < visited.length; i++) {
				if (visited[i] == 0) {
					DFS(edges, i, visited, holder);
				}
			} // we are DFS on one side of graph
				// now will work on transpose of graph
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
			Arrays.fill(visited, 0);
			ArrayList<Integer> ans = new ArrayList<Integer>();
			
			for (int i = 0; i < all_comp.size(); i++) {
				int flag = 1;
				component : for (int j = 0; j < all_comp.get(i).size(); j++) {
					for (int j2 = 1; j2 < edges[all_comp.get(i).get(j)].length; j2++) {
						if(edges[all_comp.get(i).get(j)][j2]==1) {
							if(!all_comp.get(i).contains(j2)) {
								flag = 0;
								break component;
								//ans.add(all_comp.get(i).get(j));
							}
						}
					}
				}
				if(flag==1) {
					for (int j = 0; j < all_comp.get(i).size(); j++) {
						ans.add(all_comp.get(i).get(j));
					}
				}
			}
			Collections.sort(ans);
			for (int z = 0; z < ans.size(); z++) {
				System.out.print(ans.get(z)+" ");
			}
			ans.clear();
			System.out.println();
			
		}
		sf.close();
	}

}
