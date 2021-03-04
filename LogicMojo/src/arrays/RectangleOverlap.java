package arrays;

public class RectangleOverlap {
	//just find where all overlap is not possible
	public static boolean isOverlap(int x11,int y11,int x12,int y12,int x21,int y21,int x22,int y22) {
		if(x12<x21 || y12<y21)return false;
		if(x22<x11 || y22<y11)return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
