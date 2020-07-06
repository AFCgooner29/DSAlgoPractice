package beginner;
/*
 * Problem
Cameron and Jamie's kid is almost 3 years old! However, even though the child is more independent now, scheduling kid activities and domestic necessities is still a challenge for the couple.

Cameron and Jamie have a list of N activities to take care of during the day. Each activity happens during a specified interval during the day. They need to assign each activity to one of them, so that neither of them is responsible for two activities that overlap. An activity that ends at time t is not considered to overlap with another activity that starts at time t.

For example, suppose that Jamie and Cameron need to cover 3 activities: one running from 18:00 to 20:00, another from 19:00 to 21:00 and another from 22:00 to 23:00. One possibility would be for Jamie to cover the activity running from 19:00 to 21:00, with Cameron covering the other two. Another valid schedule would be for Cameron to cover the activity from 18:00 to 20:00 and Jamie to cover the other two. Notice that the first two activities overlap in the time between 19:00 and 20:00, so it is impossible to assign both of those activities to the same partner.

Given the starting and ending times of each activity, find any schedule that does not require the same person to cover overlapping activities, or say that it is impossible.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line containing a single integer N, the number of activities to assign. Then, N more lines follow. The i-th of these lines (counting starting from 1) contains two integers Si and Ei. The i-th activity starts exactly Si minutes after midnight and ends exactly Ei minutes after midnight.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is IMPOSSIBLE if there is no valid schedule according to the above rules, or a string of exactly N characters otherwise. The i-th character in y must be C if the i-th activity is assigned to Cameron in your proposed schedule, and J if it is assigned to Jamie.

If there are multiple solutions, you may output any one of them. (See "What if a test case has multiple correct solutions?" in the Competing section of the FAQ. This information about multiple solutions will not be explicitly stated in the remainder of the 2020 contest.)

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
0 ≤ Si < Ei ≤ 24 × 60.

Test set 1 (Visible Verdict)
2 ≤ N ≤ 10.

Test set 2 (Visible Verdict)
2 ≤ N ≤ 1000.

Sample

Input
 	
Output
 
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

  
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC

  
Sample Case #1 is the one described in the problem statement. As mentioned above, there are other valid solutions, like JCJ and JCC.

In Sample Case #2, all three activities overlap with each other. Assigning them all would mean someone would end up with at least two overlapping activities, so there is no valid schedule.

In Sample Case #3, notice that Cameron ends an activity and starts another one at minute 100.

In Sample Case #4, any schedule would be valid. Specifically, it is OK for one partner to do all activities.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
	public static class pair{
		int start;
		int end;
		public pair(int x,int y) {
			// TODO Auto-generated constructor stub
			start = x;
			end = y;
		}
	}
	public static boolean can_hold(pair k,pair m) {
		if(k.end<=m.start) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int i = 1; i <=test; i++) {
			int act = sf.nextInt();
			int[][] activities = new int[act][3];
			for (int j = 0; j < activities.length; j++) {
				activities[j][0] = sf.nextInt();
				activities[j][1] = sf.nextInt();
				activities[j][2] = j;
			}
			Arrays.parallelSort(activities,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if(o1[1]<o2[1]) {
						return -1;
					}
					else if(o1[1]>o2[1]) {
						return 1;
					}
					return 0;
				}
			});
			Stack<pair> sc1 = new Stack<pair>();
			Stack<pair> sc2 = new Stack<pair>();
			sc1.add(new pair(0,0));
			sc2.add(new pair(0,0));
			int flag = 0;
			StringBuilder ans = new StringBuilder();
			for (int j = 0; j < activities.length; j++) {
				ans.append("A");
			}
			for (int j = 0; j < activities.length; j++) {
				pair temp = new pair(activities[j][0], activities[j][1]);
				if(can_hold(sc1.peek(),temp)) {
					sc1.pop();
					sc1.add(temp);
					ans.replace(activities[j][2], activities[j][2]+1, "J");
				}
				else if(can_hold(sc2.peek(),temp)) {
					sc2.pop();
					sc2.add(temp);
					ans.replace(activities[j][2], activities[j][2]+1, "C");
					}
				else {
					flag = 1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("Case #"+i+": "+ans);
			}
			else {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
		}
		sf.close();
	}

}
