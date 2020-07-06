package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Connected horses
Send Feedback
You all must be familiar with the chess-board having 
8*8 squares of alternate black and white cells. Well, here 
we have for you a similar 
N*M size board with similar arrangement of black and white 
cells.
A few of these cells have Horses placed over them. 
Each horse is unique. Now these horses are not the 
usual horses which could jump to any of the 
8 positions they usually jump in. They can move only if there is another horse on one of the 8-positions that it can     go to usually and then both the horses will swap their positions. This swapping can happen infinitely times.
A photographer was assigned to take a picture of all the different ways that the horses occupy the board! Given the state of the board, calculate answer. Sincethis answer may be quite large, calculate in modulo 
10^9+7
Input:
First line contains 
T which is the number of test cases.
T test cases follow first line of each containing three integers 
N, M and Q where 
N,M is the size of the board and 
Q is the number of horses on it.

Q lines follow each containing the 2 integers 
X and Y which are the coordinates of the Horses.
Output:
For each test case, output the number of photographs taken by photographer.
Constraints:
 1<=T<=10
 1<=N,M<=1000
 1<=Q<=N*M
SAMPLE INPUT
2
4 4 4
1 1
1 2
3 1
3 2
4 4 4
1 1
1 2
3 1
4 4
SAMPLE OUTPUT
4
2
 */
public class Connected_Horses {
	public static long factorial(int num) {
		long ans = 1;
		long mod = (long)Math.pow(10, 9) +7;
		for (int i = 2; i <=num; i++) {
			ans = ans * i;
		}
		return ans%mod;
	}
	public static void DFS(int[][] graph,int[] visited,int start,ArrayList<Integer> comp) {
		visited[start] = 1;
		comp.add(start);
		for (int i = 0; i < graph.length; i++) {
			if(graph[start][i]==1 && visited[i]==0) {
				DFS(graph, visited, i, comp);
			}
		}
	}
	public static void fill_matrix(int[][] board,int[][] graph) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]!=-1) {
					//we have to check all the moves of horse from here
					// if the move already has got a horse then we update the graph for these two
					//below are moves code this can be made better
					if(i-1>0) {
						if(j-1>-1 && board[i-2][j-1]!=-1) {
							graph[board[i][j]][board[i-2][j-1]] = 1;
							graph[board[i-2][j-1]][board[i][j]] = 1;
						}
						if(j+1<board[0].length && board[i-2][j+1]!=-1) {
							graph[board[i][j]][board[i-2][j+1]] = 1;
							graph[board[i-2][j+1]][board[i][j]] = 1;
						}
					}
					if(i+1<board.length-1) {
						if(j-1>-1 && board[i+2][j-1]!=-1) {
							graph[board[i][j]][board[i+2][j-1]] = 1;
							graph[board[i+2][j-1]][board[i][j]] = 1;
						}
						if(j+1<board[0].length && board[i+2][j+1]!=-1) {
							graph[board[i][j]][board[i+2][j+1]] = 1;
							graph[board[i+2][j+1]][board[i][j]] = 1;
						}
					}
					if(j-1>0) {
						if(i-1>-1 && board[i-1][j-2]!=-1) {
							graph[board[i][j]][board[i-1][j-2]] = 1;
							graph[board[i-1][j-2]][board[i][j]] = 1;
						}
						if(i+1<board.length && board[i+1][j-2]!=-1) {
							graph[board[i][j]][board[i+1][j-2]] = 1;
							graph[board[i+1][j-2]][board[i][j]] = 1;
						}
					}
					if(j+1<board[0].length-1) {
						if(i-1>-1 && board[i-1][j+2]!=-1) {
							graph[board[i][j]][board[i-1][j+2]] = 1;
							graph[board[i-1][j+2]][board[i][j]] = 1;
						}
						if(i+1<board.length && board[i+1][j+2]!=-1) {
							graph[board[i][j]][board[i+1][j+2]] = 1;
							graph[board[i+1][j+2]][board[i][j]] = 1;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		long mod = (long)Math.pow(10, 9) +7;
		int test_case = sf.nextInt();
		for (int i = 0; i < test_case; i++) {
			int N = sf.nextInt();
			int M = sf.nextInt();
			int Q = sf.nextInt();
			int[][] graph = new int[Q][Q];
			int[][] board = new int[N][M];
			for (int j = 0; j < graph.length; j++) {
				Arrays.fill(graph[j], 0);
			}
			for (int j = 0; j < board.length; j++) {
				Arrays.fill(board[j], -1);
			}
			int count = 0;
			for (int j = 0; j < Q; j++) {
				int x = sf.nextInt();
				int y = sf.nextInt();
				board[x-1][y-1] = count;
				count++;
			}
			fill_matrix(board, graph);
			int[] visited = new int[Q];
			Arrays.fill(visited, 0);
			ArrayList<ArrayList<Integer>> all_comp = new ArrayList<ArrayList<Integer>>();
			for (int j = 1; j < visited.length; j++) {
				if(visited[j]==0) {
					ArrayList<Integer> comp = new ArrayList<Integer>();
					DFS(graph,visited,j,comp);
					all_comp.add(comp);
				}
			}
			long ans = 1;
			for (int j = 0; j < all_comp.size(); j++) {
				ans = (ans * factorial(all_comp.get(j).size()))%mod;
			}
			System.out.println(ans);
			
		}
		sf.close();
	}

}
