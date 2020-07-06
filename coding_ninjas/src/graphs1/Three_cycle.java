package graphs1;

import java.util.Scanner;

/*
 * 3 Cycle
Send Feedback
Given a graph with N vertices (numbered from 1 to N) and Two Lists (U,V) of size M where (U[i],V[i]) and (V[i],U[i]) are connected by an edge , then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected an edge.
Input Format :
Line 1 : Two integers N and M
Line 2 : List u of size of M
Line 3 : List v of size of M
Return Format :
The count the number of 3-cycles in the given Graph
Constraints :
1<=N<=100
1<=M<=(N*(N-1))/2
1<=u[i],v[i]<=N
Sample Input:
3 3
1 2 3
2 3 1
Sample Output:
1
 */
public class Three_cycle {
	/*
	 * Approach is to go to next nodes and if k becomes 4 then we find that start becomes start_save 
	 * in any case then its a 3 cycle
	 * Why we are dividing count/6 I dont know
	 * see video again 
	 */
	public static int finder(int[][] graph,int start,int start_save,int k) {
		if(k==4 && start == start_save) {
			return 1;
		}
		else if(k==4 && start != start_save) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			if(graph[start][i]==1) {
				count+= finder(graph, i, start_save, k+1);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		int m = sf.nextInt();
		int[][] garph = new int[n+1][n+1];
		int[] U = new int[m];
		int[] V = new int[m];
		for (int i = 0; i < m; i++) {
			U[i] = sf.nextInt();
		}
		for (int i = 0; i < m; i++) {
			V[i] = sf.nextInt();
		}
		for (int i = 0; i < m; i++) {
			garph[U[i]][V[i]] = 1;
			garph[V[i]][U[i]] = 1;
		}
		U = null;
		V = null;
		int tot_count = 0;
		for (int i = 1; i <=n; i++) {
			tot_count+= finder(garph, i, i, 1);
		}
		System.out.println(tot_count/6);
		sf.close();
	}

}
