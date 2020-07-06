package easy;

import java.util.Scanner;

public class CheckIfStLine {
	public static double findSlope(int[][] cor,int x,int y){
        return Math.abs((double)(cor[x][1]-cor[y][1])/(cor[x][0]-cor[y][0]));
    }
    public static boolean checkStraightLine(int[][] co) {
        if(co.length<3){
            return true;
        }
        double slop = findSlope(co,0,1);
        for(int i= 2;i<co.length;i++){
            if(slop!=findSlope(co,0,i)){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cor = new int[6][2];
		Scanner sf = new Scanner(System.in);
		for (int i = 0; i < cor.length; i++) {
			cor[i][0] = sf.nextInt();
			cor[i][1] = sf.nextInt();
		}
		System.out.println(checkStraightLine(cor));
	}

}
