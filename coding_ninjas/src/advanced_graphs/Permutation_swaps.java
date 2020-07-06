package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Permutation Swaps
Send Feedback
Kevin has a permutation P of N integers 1, 2, ..., N, but he doesn't like it. Kevin wants to get a permutation Q.

Also he believes that there are M good pairs of integers (ai , bi). Kevin can perform following operation with his permutation:

Swap Px and Py only if (x, y) is a good pair.
Help him and tell if Kevin can obtain permutation Q using such operations.
Input format:
The first line of input will contain an integer T, denoting the number of test cases.

Each test case starts with two space-separated integers N and M. The next line contains N space-separated integers Pi. The next line contains N space-separated integers Qi. Each of the next M lines contains two space-separated integers ai and bi.
Output format:
For every test case output "YES" (without quotes) if Kevin can obtain permutation Q and "NO" otherwise.
Constraints:
1 ≤ T ≤ 10
2 ≤ N ≤ 100000
1 ≤ M ≤ 100000
1 ≤ Pi, Qi ≤ N. Pi and Qi are all distinct.
1 ≤ ai < bi ≤ N
SAMPLE INPUT
2
4 1
1 3 2 4
1 4 2 3
3 4
4 1
1 3 2 4
1 4 2 3
2 4
SAMPLE OUTPUT
NO 
YES
 */
//coding ninjas is giving runtime error for this code maybe because of running out of memory
//but this is using same memory as cpp code below which is accepted
/*
 * #include <bits/stdc++.h>
using namespace std;

void dfs(vector<int> *graph, int start, bool *isVisited, unordered_set<int> *part){
    isVisited[start] = true;
    part->insert(start);

    for(int i = 0; i < graph[start].size(); i++){
        int next = graph[start][i];
        if(!isVisited[next]){
            dfs(graph, next, isVisited, part);
        }
    }
}

unordered_set< unordered_set<int> *> *getComponent(vector<int> *graph, int n){
    bool *isVisited = new bool[n];
    for(int i = 0; i < n; i++) isVisited[i] = false;

    unordered_set< unordered_set<int> * > *component = new unordered_set< unordered_set<int> * >();
    for(int i = 0; i < n; i++){
        if(!isVisited[i]){
            unordered_set<int> *part = new unordered_set<int>();
            dfs(graph, i, isVisited, part);
            component->insert(part);
        }
    }

    return component;
}

int main(){
    int flag;
    int t;
    cin >> t;
    while(t--){
        flag = 1;
        int n, m;
        cin >> n >> m;

        int *p = new int[n];
        for(int i = 0; i < n; i++){
            int x;
            cin >> x;
            p[i] = x-1;
        }

        int *q = new int[n+1];
        for(int i = 0; i < n; i++){
            int x;
            cin >> x;
            q[i] = x-1;
        }

        vector<int> *graph = new vector<int>[n];
        for(int i = 0; i < m; i++){
            int a, b;
            cin >> a >> b;
            graph[a-1].push_back(b-1);
            graph[b-1].push_back(a-1);
        }

        unordered_set< unordered_set<int> * > *component = getComponent(graph, n);

        // for(unordered_set< unordered_set<int> * >::iterator i = component->begin(); i != component->end(); i++){
        //     for(unordered_set<int>::iterator j = (*i)->begin(); j != (*i)->end(); j++){
        //         cout << (*j)+1 << " ";
        //     }
        //     cout << endl;
        // }

        for(unordered_set< unordered_set<int> * >::iterator i = component->begin(); i != component->end(); i++){
            set<int> setA;
            set<int> setB;
            for(unordered_set<int>::iterator j = (*i)->begin(); j != (*i)->end(); j++){
                setA.insert(p[*j]);
                setB.insert(q[*j]);
            }

            if(setA != setB){
                flag = 0;
                cout << "NO" << endl;
                break;
            }
        }

        if(flag) cout << "YES" << endl;
    }
}
 */
public class Permutation_swaps {
	public static void DFS(int[][] graph,int[] visited,int start,ArrayList<Integer> comp) {
		visited[start] = 1;
		comp.add(start);
		for (int i = 0; i < graph.length; i++) {
			if(graph[start][i]==1 && visited[i]==0) {
				DFS(graph, visited, i, comp);
			}
		}
	}
	public static void getComponent(int[][] graph,int N,ArrayList<ArrayList<Integer>> all_comp){
		int[] visited = new int[N+1];
		Arrays.fill(visited, 0);
		for (int j = 1; j < visited.length; j++) {
			if(visited[j]==0) {
				ArrayList<Integer> comp = new ArrayList<Integer>();
				DFS(graph,visited,j,comp);
				all_comp.add(comp);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test_cases = sf.nextInt();
		outer : for (int i = 0; i < test_cases; i++) {
			int N = sf.nextInt();
			int M = sf.nextInt();
			int[] P = new int[N];
			int[] Q = new int[N];
			for (int j = 0; j < N; j++) {
				P[j] = sf.nextInt();
			}
			for (int j = 0; j < N; j++) {
				Q[j] = sf.nextInt();
			}
			int[][] graph = new int[N+1][N+1];
			for (int j = 0; j < graph.length; j++) {
				Arrays.fill(graph[j], 0);
			}
			for (int j = 0; j < M; j++) {
				int x = sf.nextInt();
				int y = sf.nextInt();
				graph[x][y] = 1;
				graph[y][x] = 1;//filling adjacency matrix
			}
			ArrayList<ArrayList<Integer>> all_comp = new ArrayList<ArrayList<Integer>>();
			getComponent(graph, N, all_comp);
			graph = null;
		//	visited = null;
			//we have to find the thing now
			for (int j = 0; j < all_comp.size(); j++) {
				int sum1 = 0;
				int sum2 = 0;
				for (int j2 = 0; j2 < all_comp.get(j).size(); j2++) {
					sum1+= P[all_comp.get(j).get(j2)-1];
					sum2+= Q[all_comp.get(j).get(j2)-1];
				}
				if(sum1!=sum2) {
					System.out.println("NO");
					continue outer;
				}
			}
			System.out.println("YES");
		}
		sf.close();
	}

}
