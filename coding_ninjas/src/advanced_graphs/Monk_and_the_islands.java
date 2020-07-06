package advanced_graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * Monk and the Islands
Send Feedback
MONK AND THE ISLAND
Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. 
Some pairs of islands are connected to each other by Bidirectional bridges 
running over water.
Monk hates to cross these bridges as they require a lot of efforts.
 He is standing at Island #1 and wants to reach the Island #N. Find the minimum the 
 number of bridges that he shall have to cross, if he takes the optimal route.
Input:
First line contains T. T testcases follow.
First line of each test case contains two space-separated integers N, M.
Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.
Output:
Print the answer to each test case in a new line.
Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 10000
1 ≤ M ≤ 100000
1 ≤ X, Y ≤ N
SAMPLE INPUT
2
3 2
1 2
2 3
4 4
1 2
2 3
3 4
4 2
SAMPLE OUTPUT
2
2
 */
public class Monk_and_the_islands {
	public static void DFS(int[][] graph,int start,int[] visited,int[] min_val,int dist) {
		visited[start] = 1;
		if(start == graph.length-1) {
			min_val[0] = Math.min(min_val[0], dist);
			visited[start] = 0;
			return;
		}
		for (int i = 0; i < graph.length; i++) {
			if(graph[start][i]!=0 && visited[i]==0) {
				DFS(graph, i, visited,min_val,dist+1);
			}
		}
		visited[start] = 0;//backtracking 
	}
	public static int BFS(ArrayList<ArrayList<Integer>> graph,int start,int[] visited) {
		int level = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(start);
		outer : while(!qu.isEmpty()) {
			int temp = qu.poll();
			visited[temp] = 1;
			level++;
			for (int i = 0; i < graph.get(temp).size(); i++) {
				if(visited[graph.get(temp).get(i)]==0) {
					if(graph.get(temp).get(i)==graph.size()-1) {
						break outer;
					}
					qu.add(graph.get(temp).get(i));
				}
			}
			
		}
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int tests = sf.nextInt();
		for (int i = 0; i < tests; i++) {
			int N = sf.nextInt();
			int E = sf.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < N; j++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int j = 0; j < E; j++) {
				int x = sf.nextInt();
				int y = sf.nextInt();
				graph.get(x-1).add(y-1);
				graph.get(y-1).add(x-1);
			}
			int[] visited = new int[N];
			Arrays.fill(visited, 0);
		//	int[] min_val = {Integer.MAX_VALUE};
			
		//	DFS(graph,0,visited,min_val,0);
			
		//	System.out.println(min_val[0]);
			System.out.println(BFS(graph, 0, visited));
			
		}
		sf.close();
	}

}
