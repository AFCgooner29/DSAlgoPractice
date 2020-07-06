package graphs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_all_connected_components_bfs {
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
		int start = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(start);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while(!qu.isEmpty()) {
			int i = qu.poll();
			visited[i] = 1;
			temp.add(i);
			for (int j = 0; j < visited.length; j++) {
				if(graph[i][j]==1 && visited[j]==0) {
					visited[j]=1;
					qu.add(j);
				}
			}
			if(qu.isEmpty()) {
				Collections.sort(temp);
				listprinter(temp);
				temp.clear();
				for (int j = 0; j < visited.length; j++) {
					if(visited[j]==0) {
						qu.add(j);
						break;
					}
				}
			}
		}
		sf.close();
	}

}
