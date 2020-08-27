package august;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        return helper(ans, rowIndex);
    }
	public static List<Integer> helper(List<Integer> prevRow,int row) {
		if(row==0)return prevRow;
		List<Integer> curr = new ArrayList<Integer>();
		for (int i = 0; i <=prevRow.size(); i++) {
			int val = 0;
			if(i!=0 && i !=prevRow.size()) {
				val = prevRow.get(i-1)+prevRow.get(i);
			}
			else {
				if(i==0) {
					val = prevRow.get(i);
				}
				else {
					val = prevRow.get(i-1);
				}
			}
			curr.add(val);
		}
		return helper(curr, row-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));
	}

}
