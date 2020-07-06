package easy;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */
public class FindTownJudge {
	public int findJudge(int N, int[][] trust) {
		ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<HashMap<Integer,Integer>>();
		for (int i = 0; i <=N; i++) {
			graph.add(new HashMap<Integer, Integer>());
		}
		for (int i = 0; i < trust.length; i++) {
			if(graph.get(trust[i][0]).containsKey(trust[i][1])) {
				int val = graph.get(trust[i][0]).get(trust[i][1]);
				graph.get(trust[i][0]).put(trust[i][1], val+1);
			}
			else {
				graph.get(trust[i][0]).put(trust[i][1], 1);
			}
		}
		int found = -1;
		for (int i = 1; i < graph.size(); i++) {
			if(graph.get(i).isEmpty()) {
				found = i;
				break;
			}
		}
		for (int i = 1; i < graph.size(); i++) {
			if(!graph.get(i).containsKey(found)) {
				if(i==found)continue;
				found = -1;
				break;
			}
		}
		return found;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
