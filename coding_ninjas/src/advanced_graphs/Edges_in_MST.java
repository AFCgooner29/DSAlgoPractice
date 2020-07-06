package advanced_graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Edges in MST
Send Feedback
Edges in MST
You are given a connected weighted undirected graph without any loops and multiple edges.

Let us remind you that a graph's spanning tree is defined as an acyclic connected 
subgraph of the given graph that includes all of the graph's vertexes. 
The weight of a tree is defined as the sum of weights of the edges that the 
given tree contains. The minimum spanning tree (MST) of a graph is defined as the 
graph's spanning tree having the minimum possible weight. 
For any connected graph obviously exists the minimum spanning tree, 
but in the general case, a graph's minimum spanning tree is not unique.

Your task is to determine the following for each edge of the given graph: 
whether it is either included in any MST, or included at least in one MST, 
or not included in any MST.
Input
The first line contains two integers n and m (2 ≤ n ≤ 105, ) — the number of 
the graph's vertexes and edges, correspondingly. Then follow m lines, each of 
them contains three integers — the description of the graph's edges as "ai bi wi" 
(1 ≤ ai, bi ≤ n, 1 ≤ wi ≤ 106, ai ≠ bi), where ai and bi are the numbers of 
vertexes connected by the i-th edge, wi is the edge's weight. 
It is guaranteed that the graph is connected and doesn't contain loops or multiple edges.
Output
Print m lines — the answers for all edges. If the i-th edge is included in 
any MST, print "any"; if the i-th edge is included at least in one MST, print 
"at least one"; if the i-th edge isn't included in any MST, print "none". 
Print the answers for the edges in the order in which the edges are specified 
in the input.
Sample input 1
4 5
1 2 101
1 3 100
2 3 2
2 4 2
3 4 1
sample output 1
none
any
at least one
at least one
any
Sample input 2
3 3
1 2 1
2 3 1
1 3 2 
sample output 2
any
any
none
sample input 3
3 3
1 2 1
2 3 1
1 3 1
sample output 3
at least one
at least one
at least one
Note
In the second sample the MST is unique for the given graph: it contains two first edges.

In the third sample any two edges form the MST for the given graph. That means that each edge is included at least in one MST.
 */

/*
 * This is codeforces 160D question
 * 
 * Let's take a look at Kruskal Algorithm which solve MST in O(m log m) time. Sort the edges first in weight non-decreasing order, then process each edges. if the edge connects two different connected compoments, add this edge to MST then combine two compoments. We use disjoint-set union here to maintain connectivity.

The main point is that only those edges with same weight may replace each other in MST. First of all, sort edges as what Kruskal do. To get the answer, we construct MST in weight non-decreasing order, and process all edges with same weight together. Now on each step we are to face some edges with same weight x and a forest of connected compoments.

Note that for an edge, what points it connects does not matter, we only need to know what compoments it connects. Now build a new graph G', each point in G' is a connected compoment in the original forest,and edges are added to connect compoments that it connected before. Time complexity is O(|E|) here, with careful implementation.

Let's answer queries on these edges. First of all, if an edge in G' is a loop(connects the same compoment), this edge must not appear in any MSTs. If after deleting an edge V in G', G's connectivity is changed (A connected compoment in G' spilt into two. We call these edges bridge), V must be in any of MST. All edges left can appear in some MSTs, but not any.

What's left is to get all of V quickly. Maybe you hear about Tarjan before, he invented an algorithm based on DFS to get all bridges in an edge-undirected graph in O(|V|+|E|). Read this page on Wikipedia for detailed information: http://en.wikipedia.org/wiki/Bridge_(graph_theory)
 */
public class Edges_in_MST {
	public static int getParent(int[] parent,int i) {
		if(parent[i]==i) {
			return i;
		}
		return getParent(parent, parent[i]);
	}
	
	public static void finder(int[][] edges,int[] parent,String[] comments) {
		Arrays.parallelSort(edges,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[2]<o2[2]) {
					return -1;
				}
				else if(o1[2]>o2[2]) {
					return 1;
				}
				
				return 0;
			}
		});
		//kruskals algo to get MST
		int[] temp_parent = Arrays.copyOf(parent, parent.length);
		for (int i = 0; i < edges.length; i++) {
			int xpar = getParent(parent, edges[i][0]);
			int ypar = getParent(parent, edges[i][1]);
			if(xpar!=ypar) {
				int flag = 0;
				//code is failing where there is no bridge in the graph
				//where all the edges are subsutitable
				//we can try one thing : we will make the graph all the components with same wieght 
				//if n-1 edges are used then we set all to at least one
				for (int j = i+1; j < edges.length; j++) {
					/*
					if(edges[i][2]==edges[j][2]) {
						count++;
					}
					*///new
					// old code failing where there is no bridge in the graph
					if(edges[i][2]==edges[j][2]) {
						int xpar2 = getParent(parent, edges[j][0]);
						int ypar2 = getParent(parent, edges[j][1]);
						if(xpar==xpar2 && ypar==ypar2) {
							flag = 1;
							comments[edges[i][3]] = "at least one";
							comments[edges[j][3]] = "at least one";
						}
					}
				}
				/*
				if(count>1) {
					int[] temp_parent = Arrays.copyOf(parent, parent.length);
					int count_1 = 0;
					for (int j = i; j < count+i; j++) {
						int xparr = getParent(temp_parent, edges[j][0]);
						int yparr = getParent(temp_parent, edges[j][1]);
						if(xparr!=yparr) {
							count_1++;
							temp_parent[xparr] = yparr;
							if(xpar==xparr && ypar==yparr && count_1!=1) {
								flag = 1;
							//	comments[edges[i][3]] = "at least one";
								comments[edges[j][3]] = "at least one";
							}
						}
					}
					if(count_1 == count-1) {
						for (int j = i; j < count+i; j++) {
							comments[edges[j][3]] = "at least one";
						}
					}
				}*/
				parent[xpar] = ypar;
				
				if(flag==0) { comments[edges[i][3]] = "any"; }
				 
			}
			else {
				if(comments[edges[i][3]].isEmpty()) {
					comments[edges[i][3]] = "none";
				}
			}
		}
		for (int k = 0; k < edges.length; k++) {
			int count = 1;
			for (int l = k; l < edges.length; l++) {
				if(edges[k][2]==edges[l][2]) {
					count++;
				}
			}
			/*
			if(count>1) {
				int count_1 = 0;
				for (int j = i; j < count+i; j++) {
					int xparr = getParent(temp_parent, edges[j][0]);
					int yparr = getParent(temp_parent, edges[j][1]);
					if(xparr!=yparr) {
						count_1++;
						temp_parent[xparr] = yparr;
						if(xpar==xparr && ypar==yparr && count_1!=1) {
							flag = 1;
						//	comments[edges[i][3]] = "at least one";
							comments[edges[j][3]] = "at least one";
						}
					}
				}
				if(count_1 == count-1) {
					for (int j = i; j < count+i; j++) {
						comments[edges[j][3]] = "at least one";
					}
				}
			}*/
			//
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int N = sf.nextInt();
		int E = sf.nextInt();
		int[][] edges = new int[E][4];
		for (int i = 0; i < edges.length; i++) {
			int x = sf.nextInt();
			int y = sf.nextInt();
			int wt = sf.nextInt();
			edges[i][0] = x-1;
			edges[i][1] = y-1;
			edges[i][2] = wt;
			edges[i][3] = i;
		}
		int[] parent = new int[N];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		String[] comments = new String[E];
		Arrays.fill(comments, "");
		finder(edges, parent, comments);
		for (int i = 0; i < comments.length; i++) {
			System.out.println(comments[i]);
		}
		
		sf.close();
	}

}
