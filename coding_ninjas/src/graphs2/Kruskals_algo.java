package graphs2;

import java.util.Arrays;
import java.util.Scanner;


/*
 * Kruskal's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format -
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
MST
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
1 2 1
0 1 3
0 3 5
 */
class edge implements Comparable<edge> {
	int start;
	int end;
	int wieght;
	public edge(int s1,int s2,int s3) {
		start = s1;
		end = s2;
		wieght = s3;
	}
	public void showData() {
		System.out.println(this.start+" "+this.end+" "+this.wieght);
		return;
	}
	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		int compareage=o.wieght;
        /* For Ascending order*/
        return this.wieght-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
	}
	/*
	@Override
	public int compare(edge o1, edge o2) {
		// TODO Auto-generated method stub
		if(o1.wieght<o2.wieght) {
			return -1;
		}
		else if(o1.wieght>o2.wieght) {
			return 1;
		}
		return 0;
	}*/
}
public class Kruskals_algo {
	public static int getPar(int v, int[] parent) {
		if(parent[v]==v) {
			return parent[v]; 
		}
		return getPar(parent[v], parent);
	}
	public static void algo(edge[] arr,int n,int e,int[] parent) {
		for (int i = 0; i < arr.length; i++) {
			int src_par = getPar(arr[i].start,parent);
			int des_par = getPar(arr[i].end,parent);
			if(src_par!=des_par) {
				arr[i].showData();
				parent[src_par] = des_par;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
 		int n = sf.nextInt();
 		int e = sf.nextInt();
 		edge eges[] = new edge[e];
 		for (int i = 0; i < e; i++) {
 			int s = sf.nextInt();
 			int en = sf.nextInt();
 			int wi = sf.nextInt();
 			if(s<en) {
 				eges[i] = new edge(s,en,wi) {};
 			}
 			else {
 				eges[i] = new edge(en,s,wi) {};
 			}
		}
 		int[] parent = new int[n];
 		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
 		Arrays.sort(eges);
		/*
		 * for (int i = 0; i < eges.length; i++) { eges[i].showData(); }
		 */
 		algo(eges, n, e, parent);
 		sf.close();
	}

}
