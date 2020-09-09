package bitmanipulation;
/*
 * If we observe bits from rightmost side at distance i than bits get inverted after 2i position in vertical sequence.

For example A = 5;
0 = 0000
1 = 0001
2 = 0010
3 = 0011
4 = 0100
5 = 0101

Observe the right most bit (i = 0) the bits get flipped after (20 = 1)
Observe the 3rd rightmost bit (i = 2) the bits get flipped after (22 = 4)

So, We can count bits in vertical fashion such that at i’th right most position bits will be get flipped after 2i iteration;

https://www.interviewbit.com/problems/count-total-set-bits/
 */
public class CountSetBitstillN {
	public int solve(int A) {
		int powerOf2 = 2;
		int count = A/2;
		while(powerOf2<=A) {
			int tot = A/powerOf2;
			count+= (tot/2) * powerOf2;
			powerOf2 = powerOf2<<1;
		}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
