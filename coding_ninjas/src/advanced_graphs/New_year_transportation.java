package advanced_graphs;


import java.util.Arrays;
import java.util.Scanner;

/*
 * New Year Transportation
Send Feedback
New Year Transportation
New Year is coming in Line World! In this world, there are n cells numbered 
by integers from 1 to n, as a 1 × n board. People live in cells. However, 
it was hard to move between distinct cells, because of the difficulty of escaping the cell. 
People wanted to meet people who live in other cells.

 So, user tncks0121 has made a transportation system to move between these cells, 
 to celebrate the New Year. First, he thought of n - 1 
 positive integers a1, a2, ..., an - 1. For every integer i where 1 ≤ i ≤ n - 1 
 the condition 1 ≤ ai ≤ n - i holds. Next, he made n - 1 portals, numbered by 
 integers from 1 to n - 1. The i-th (1 ≤ i ≤ n - 1) portal connects cell i 
 and cell (i + ai), and one can travel from cell i to cell (i + ai) using the i-th portal. 
 Unfortunately, one cannot use the portal backwards, which means one cannot move 
 from cell (i + ai) to cell i using the i-th portal. It is easy to see that because 
 of condition 1 ≤ ai ≤ n - i one can't leave the Line World using portals.

Currently, I am standing at cell 1, and I want to go to cell t. However, 
I don't know whether it is possible to go there. Please determine whether 
I can go to cell t by only using the construted transportation system.
Input
The first line contains two space-separated integers n (3 ≤ n ≤ 3 × 104) 
and t (2 ≤ t ≤ n) — the number of cells, and the index of the cell which I want to go to.

The second line contains n - 1 space-separated integers a1, a2, ..., an - 1 (1 ≤ ai ≤ n - i). It is guaranteed, that using the given transportation system, one cannot leave the Line World.
Output
If I can go to cell t using the transportation system, print "YES". Otherwise, print "NO".
Sample input 1
8 4
1 2 1 2 1 2 1
Sample output 1
YES
Sample input 2
8 5 1 2 1 2 1 1 1

Sample output 2
NO
Note
In the first sample, the visited cells are: 1, 2, 4; so we can successfully visit the cell 4.

In the second sample, the possible cells to visit are: 1, 2, 4, 6, 7, 8; so we can't visit the cell 5, which we want to visit.
 */
public class New_year_transportation {
	public static void DFS(int[][] graph,int start,int end,int[] visited,String[] vis) {
		visited[start] = 1;
		if(start == end) {
			visited[start] = 0;
			vis[0] = "YES";
			return;
		}
		for (int i = 1; i < graph.length; i++) {
			if(graph[start][i]!=0 && visited[i]==0) {
				DFS(graph, i, end, visited,vis);
			}
		}
		visited[start] = 0;//backtracking 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		int t = sf.nextInt();
		int[][] graph = new int[N+1][N+1];
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}
		for (int i = 1; i < N; i++) {
			int z = sf.nextInt();
			graph[i][z+i] = 1;
		}
		int[] visited = new int[N+1];
		Arrays.fill(visited, 0);
		String[] vis = {"NO"};
		DFS(graph, 1, t,visited, vis);
		System.out.println(vis[0]);
		sf.close();
	}

}
