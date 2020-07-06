package medium;
/*
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
 */
public class Friend_request {
	public static int numFriendRequests(int[] ages) {
		int counter = 0;
        for (int i = 0; i < ages.length-1; i++) {
			for (int j = i+1; j < ages.length; j++) {
				if((ages[j] <= (0.5 * ages[i]) + 7)||ages[j] > ages[i]|| (ages[j] > 100 && ages[i] < 100)) {
					if((ages[i] <= (0.5 * ages[j]) + 7)||ages[i] > ages[j]|| (ages[i] > 100 && ages[j] < 100)) {
						continue;
					}
					else {
						counter++;
					}
					continue;
				}
				else {
					counter++;
				}
			}
		}
        return counter;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ages = {16,16};
		System.out.println(numFriendRequests(ages));
	}

}
