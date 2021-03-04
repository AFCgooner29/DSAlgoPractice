package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public int colorful(int A) {
        String num = String.valueOf(A);
        HashMap<Integer,Integer> store = new HashMap<Integer,Integer>();
        if(helper(num,0,store,1))return 1;
        return 0;
    }
    public boolean helper(String num,int i,HashMap<Integer,Integer> store,int mult){
        if(i==num.length()){
            return true;
        }
        System.out.println(num.charAt(i)-'0');
        int curr = mult*(num.charAt(i)-'0');
        if(store.containsKey(curr))return false;
        store.put(curr,curr);
        return helper(num,i+1,store,mult) && helper(num,i+1,store,curr);
    }
    
}
