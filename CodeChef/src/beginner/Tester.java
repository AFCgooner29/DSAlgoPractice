package beginner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tester {
	public static int[] getRowCol(int num,int n){
        int[] ret = new int[2];
        ret[0] = (n-1) - (int)Math.ceil(num/n);
        ret[1] = num%n == 0 ? n : num%n;
        return ret;
    }
	public static void main(String[] args) {

        int[] ret = getRowCol(15, 6);
        System.out.println(ret[0]+","+ret[1]);

    }

}
