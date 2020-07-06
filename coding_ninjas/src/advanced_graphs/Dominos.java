package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * Dominos
Send Feedback
Domino
Dominos are lots of fun. Children like to stand the tiles on 
their side in long lines. When one domino falls, it knocks down the next one, 
which knocks down the one after that, all the way down the line.
However, sometimes a domino fails to knock the next one down. 
In that case, we have to knock it down by hand to get the dominos falling again.
Your task is to determine, given the layout of some domino tiles, 
the minimum number of dominos that must be knocked down by hand in order for all 
of the dominos to fall.
Input
The first line of input contains one integer specifying the number of 
test cases to follow.Each test case begins with a line containing two integers,
each no larger than 100 000. The first integer n is the number of domino tiles and 
the second integer m is the number of lines to follow in the test case. 
The domino tiles are numbered from 1 to n.
Each of the following lines contains two integers x and y indicating that 
if domino number x falls, it will cause domino number y to fall as well.
Output
For each test case, output a line containing one integer, the minimum number 
812345`9of dominos that must be knocked over by hand in order for all the dominos to fall.
Sample Input
1
3 2
1 2
2 3
Sample Output
1
 */
/*
 * we find all the connected component in the graph
 * the number of the components is the answer
 * 
 * this is a Undirected graph as dominos can form chain from both sides
 */
//this is wrong we have directed graph please change it
/*
 * This is a special case where we are using modified kosaraju
 * i.e. we will not be using Graph transpose here as we do not care about connected component here
 * but this graph is directed
 * so what we will do 
 * we will run DFS and fill holder stack
 * then we will come to know which all Dominos will form longest chain
 * then the starting point of chain will be inserted at last in stack
 * so if we push that domino then all joined dominos will fall
 * 
 * This way when we run DFS2 we will hit all the starting points first and will give exact count
 * DFS2 will be run on same graph only as there is no concept of Connected component here
 */
public class Dominos {
	public static void DFS(ArrayList<ArrayList<Integer>> edges, int start, int[] visited, Stack<Integer> holder) {
		visited[start] = 1;
		for (int i = 0; i < edges.get(start).size(); i++) {
			if (visited[edges.get(start).get(i)] == 0) {
				DFS(edges, edges.get(start).get(i), visited, holder);
			}
		}
		holder.push(start);
	}

	public static void DFS2(ArrayList<ArrayList<Integer>> edges, int start, int[] visited) {
		visited[start] = 1;
		for (int i = 0; i < edges.get(start).size(); i++) {
			if (visited[edges.get(start).get(i)] == 0) {
				DFS2(edges, edges.get(start).get(i), visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test_case = sf.nextInt();
		for (int i = 0; i < test_case; i++) {
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
			}
			int[] visited = new int[N];
			Arrays.fill(visited, 0);
			long no_of_comp = 0;
			Stack<Integer> holder = new Stack<Integer>();
			for (int j = 0; j < visited.length; j++) {
				if(visited[j]==0) {
					DFS(graph, j, visited, holder);
				//	DFS2(graph, j, visited);
				}
			}
			
			Arrays.fill(visited, 0);
			while(!holder.isEmpty()) {
				int temp = holder.pop();
				if(visited[temp]==0) {
					DFS2(graph, temp, visited);
					no_of_comp++;
				}
			}
			System.out.println(no_of_comp);
		}
		sf.close();
	}

}
