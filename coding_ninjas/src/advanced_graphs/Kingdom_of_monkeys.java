package advanced_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*
 * Kingdom Of Monkeys
Send Feedback
This is the story in Zimbo, the kingdom officially made for monkeys.
 Our Code Monk visited Zimbo and declared open a challenge in the kingdom,
  thus spoke to all the monkeys :

You all have to make teams and go on a hunt for Bananas. 
The team that returns with the highest number of Bananas will be rewarded with as 
many gold coins as the number of Bananas with them. May the force be with you!
Given there are N monkeys in the kingdom. Each monkey who wants to team up 
with another monkey has to perform a ritual. Given total M rituals are performed. 
Each ritual teams up two monkeys. If Monkeys A and B teamed up and Monkeys B and C 
teamed up, then Monkeys A and C are also in the same team.

You are given an array A where Ai is the number of bananas i'th monkey gathers.

Find out the number of gold coins that our Monk should set aside for the prize.
Input:
First line contains an integer T. T test cases follow. First line of each test case contains two space-separated N and M. M lines follow. Each of the M lines contains two integers Xi and Yi, the indexes of monkeys that perform the i'th ritual. Last line of the testcase contains N space-separated integer constituting the array A.
Output:
Print the answer to each test case in a new line.
Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 10^5
0 ≤ M ≤ 10^5
0 ≤ Ai ≤ 10^12
SAMPLE INPUT
1
4 3
1 2
2 3
3 1
1 2 3 5
SAMPLE OUTPUT
6
Explanation
Monkeys 1,2 ,3 are in the same team. They gather 1+2+3=6 bananas.
Monkey 4 is a team. It gathers 5 bananas.
Therefore, number of gold coins (highest number of bananas by a team) = 6.
 */
/*
 * For no reason Java code is not working Its giving Stack overflow
 * 
 * TRY below code CPP
 * #include <bits/stdc++.h>

using namespace std;

void dfs(long long sv, vector<long long>* graph, long long n, bool* isVisited, unordered_set<long long>* component){
	//unordered_set<long long>* ans = new unordered_set<long long>();
	isVisited[sv] = 1;

	component->insert(sv);
	for (long long i = 0; i < graph[sv].size() ; ++i)
	{
		if (isVisited[graph[sv][i]] == 0)
		{
			dfs(graph[sv][i], graph, n, isVisited, component);
		}
	}

	return;
}

unordered_set<unordered_set<long long>*>* connect(vector<long long>* graph, long long n){
	
	unordered_set<unordered_set<long long>*>* ans = new unordered_set<unordered_set<long long>*>();

	bool* isVisited = new bool[n];
	for (long long i = 0; i < n; ++i)
	{
		isVisited[i] = 0;
	}

	for (long long i = 0; i < n; ++i)
	{
		if (isVisited[i] == 0)
		{
			unordered_set<long long>* component = new unordered_set<long long>();
			dfs(i, graph, n, isVisited, component);
			ans->insert(component);
		}
	}

	return ans;

	
}

long long go(vector<long long>* graph, long long* arr, long long n){
	unordered_set<unordered_set<long long>*>* components = connect(graph, n);

	long long ans = INT_MIN;

	auto it1 = components->begin();
	while(it1!=components->end()){
		auto it2 = (*it1)->begin();
		long long temp = 0;
		while(it2!=(*it1)->end()){
			temp+=arr[*it2];
			it2++;
		}
		ans = max(temp, ans);
		it1++;
	}

	return ans;
}

int main( int argc , char ** argv )
{
	ios_base::sync_with_stdio(false) ; 
	cin.tie(NULL) ; 
	
	long long t;
	cin>>t;
	while(t--){
		long long n, m;
		cin>>n>>m;

		vector<long long>* graph =  new vector<long long>[n];
		for (long long i = 0; i < m; ++i)
		{
			long long a, b;
			cin>>a>>b;
			graph[a-1].push_back(b-1);
			graph[b-1].push_back(a-1);
		}

		long long* arr = new long long[n];
		for (long long i = 0; i < n; ++i)
		{
			cin>>arr[i];
		}

		cout << go(graph, arr, n) << '\n';
	}



	return 0 ; 



}
 * 
 */
public class Kingdom_of_monkeys {
	public static void DFS(ArrayList<ArrayList<Integer>> graph,int start,int[] visited,ArrayList<Integer> comp) {
		visited[start] = 1;
		comp.add(start);
		for (int i = 0; i < graph.get(start).size(); i++) {
			if(visited[graph.get(start).get(i)]==0) {
				DFS(graph, graph.get(start).get(i), visited,comp);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf  = new Scanner(System.in);
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
			/*
			 * int[][] graph = new int[N][N]; for (int j = 0; j < graph.length; j++) {
			 * Arrays.fill(graph[j], 0); } for (int j = 0; j < E; j++) { int x =
			 * sf.nextInt(); int y = sf.nextInt(); graph[x-1][y-1] = 1; graph[y-1][x-1] = 1;
			 * }
			 */
			int[] no_ofB = new int[N];
			for (int j = 0; j < no_ofB.length; j++) {
				no_ofB[j] = sf.nextInt();
			}
			int[] visited = new int[N];
			Arrays.fill(visited, 0);
			ArrayList<ArrayList<Integer>> all_comp = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < visited.length; j++) {
				if(visited[j]==0) {
					ArrayList<Integer> comp = new ArrayList<Integer>();
					DFS(graph,j,visited,comp);
					all_comp.add(comp);
				}
			}
			//we can make DFS a bit faster by calculating what amount of banans in every component
			int max_sum = Integer.MIN_VALUE;
			for (int j = 0; j < all_comp.size(); j++) {
				int sum_par = 0;
				for (int j2 = 0; j2 < all_comp.get(j).size(); j2++) {
					sum_par += no_ofB[all_comp.get(j).get(j2)];
				}
				max_sum = Math.max(max_sum, sum_par);
			}
			System.out.println(max_sum);
		}
		sf.close();
	}

}
