package easy;

import java.util.Arrays;
import java.util.Comparator;

/*
 *   Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
/*
 * Wrong implementation
 */
public class Que_reconstr_by_hieght {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.parallelSort(people,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		// TODO Auto-generated method stub
        		if(o1[0]<o2[0]) {
        			return -1;
        		}
        		else if(o1[0]>o2[0]) {
        			return 1;
        		}
        		else {
        			if(o1[1]<o2[1]) {
            			return -1;
            		}
            		else if(o1[1]>o2[1]) {
            			return 1;
            		}
            		return 0;
        		}
        	}
		});
        int[][] new_q = new int[people.length][2];
        Arrays.fill(new_q, null);
        for (int i = 0; i < new_q.length; i++) {
			int idx = people[i][1];
			if(new_q[idx]==null) {
				new_q[idx] = people[i];
			}
			else {
				while(new_q[idx]!=null)idx++;
				new_q[idx] = people[i];
			}
		}
        return new_q;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		System.out.println(reconstructQueue(people));
	}

}
