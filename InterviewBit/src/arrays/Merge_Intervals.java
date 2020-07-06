package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
 */

/*
 * Check this link
 * https://www.programcreek.com/2012/12/leetcode-insert-interval/
 */
public class Merge_Intervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		//case 1 partially in first but not in second
		//case 2 partially in first and in second or multiple
		if(newInterval.start>newInterval.end) {
			int temp = newInterval.start;
			newInterval.start=newInterval.end;
			newInterval.end = temp;
		}
		int i = 0;
		boolean add = false;
		while(i<intervals.size()) {
			//case it overlaps the current interval completely
			//it overlaps current through start
			//it overlaps through end
			//it is inside the current interval
			if(intervals.get(i).start>=newInterval.start && intervals.get(i).end<=newInterval.end) {
				//delete current interval
				intervals.remove(i);
				continue;
			}
			else if(newInterval.start>=intervals.get(i).start && newInterval.start<=intervals.get(i).end) {
				//check if start is in the current interval 
				int j = i;
				while(j<intervals.size() && newInterval.end>=intervals.get(j).start) {
					j++;
				}
				j--;
				if(i==j) {
					intervals.get(i).end = Math.max(newInterval.end, intervals.get(i).end);
					add = true;
					break;
				}
				else {
					newInterval.end = Math.max(intervals.get(j).end, newInterval.end);
					newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
					intervals.add(i,newInterval);
					int count = j-i+1;
                    while(count>0) {
                        intervals.remove(i+1);
                        count--;
                    }
					add=true;
					break;
				}
			}
			else if(newInterval.end>=intervals.get(i).start && newInterval.end<=intervals.get(i).end) {
				intervals.get(i).start = Math.min(newInterval.start, intervals.get(i).start);
				add = true;
				break;
			}
			else if(i==0 && newInterval.end<intervals.get(0).start) {
				intervals.add(0,newInterval);
				add = true;
			}
		}
		if(!add) {
			intervals.add(newInterval);
			Collections.sort(intervals,new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					// TODO Auto-generated method stub
					if(o1.start>o2.start) {
						return 1;
					}
					else if(o1.start<o2.start) {
						return -1;
					}
					return 0;
				}
			});
		}
		return intervals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
