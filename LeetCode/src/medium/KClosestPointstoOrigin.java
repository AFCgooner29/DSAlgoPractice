package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KClosestPointstoOrigin {
	static class Point{
		int x;
		int y;
		Point(int a,int b){
			this.x = a;
			this.y = b;
		}
	}
	static class PointQue implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			double dist1 = Math.sqrt(Math.pow((o1.x), 2) + Math.pow((o1.y), 2));
			double dist2 = Math.sqrt(Math.pow((o2.x), 2) + Math.pow((o2.y), 2));
			if(dist1<dist2) {
				return -1;
			}
			else if(dist1>dist2) {
				return 1;
			}
			return 0;
		}
		
	}
	public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> listt = new PriorityQueue<Point>(new PointQue());
        int[][] ans = new int[K][2];
		for (int i = 0; i < points.length; i++) {
			listt.add(new Point(points[i][0], points[i][1]));
		}
		for (int i = 0; i < K; i++) {
			Point test = listt.poll();
			ans[i][0] = test.x;
			ans[i][1] = test.y;
		}
		return ans;
    }
	public static int[][] kClosest2(int[][] points, int K) {
		Arrays.parallelSort(points,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				double dist1 = Math.sqrt(Math.pow((o1[0]), 2) + Math.pow((o1[1]), 2));
				double dist2 = Math.sqrt(Math.pow((o2[0]), 2) + Math.pow((o2[1]), 2));
				if(dist1<dist2) {
					return -1;
				}
				else if(dist1>dist2) {
					return 1;
				}
				return 0;
			}
		});
		return Arrays.copyOfRange(points, 0, K);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] listt = {{1,3},{-2,2}};
		System.out.println(kClosest(listt, 1));
	}

}
