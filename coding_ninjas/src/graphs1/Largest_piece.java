package graphs1;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Largest Piece
Send Feedback
Its Gary's birthday today and he has ordered his favourite 
square cake consisting of '0's and '1's . But Gary wants the 
biggest piece of '1's and no '0's . A piece of cake is defined as a part 
which consist of only '1's, and all '1's share an edge with eachother on the cake. 
Given the size of cake N and the cake , can you find the size of the biggest 
piece of '1's for Gary ?
Constraints :
1<=N<=50
Input Format :
Line 1 : An integer N denoting the size of cake 
Next N lines : N characters denoting the cake
Output Format :
Size of the biggest piece of '1's and no '0's
Sample Input :
2
11
01
Sample Output :
3
 */
public class Largest_piece {
	public static int finder(String[][] graph,int x,int y,int[][] visited) {
		if(x<0 || x==graph.length || y<0 || y==graph[0].length || visited[x][y]==1 || graph[x][y].equals("0")) {
			return 0;
		}
		else {
			visited[x][y] = 1;
			//we need to make this node visited first otherwise we will get infinite loop in next two calls
			int ans1 = finder(graph, x+1, y, visited);//down
			int ans2 = finder(graph, x-1, y, visited);//up
			int ans3 = finder(graph, x, y-1, visited);//left
			int ans4 = finder(graph, x, y+1, visited);//right
			return 1 + ans1 + ans2 + ans3 + ans4;// 1 is added for current found value
					
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int n = sf.nextInt();
		String[][] graph = new String[n][n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = sf.next().split("");
		}
		int[][] visited = new int[n][n];
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i],0);
		}
		//finder(graph, "CODINGNINJA", x, y, visited);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if(visited[i][j]==0) {//on every 1 found we find the max he can cut
					// as the graph can be disjoint graph i.e. there are more than one connected graphs in full graph
					max = Math.max(max,finder(graph, i, j, visited));
				}
			}
		}
		System.out.println(max);
		sf.close();
	}

}
