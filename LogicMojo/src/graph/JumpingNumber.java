package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpingNumber {
	public static List<Integer> getAllJumingNum(int n){
		Queue<Integer> que = new LinkedList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		for(int i =1;i<10;i++)que.offer(i);
		while(!que.isEmpty()) {
			int curr = que.poll();
			if(curr==-1)continue;
			if(curr>=n)break;
			ans.add(curr);
			int newUp = (curr%10)==9 ? -1 : (curr*10)+(curr%10)+1;
			int newDown = (curr%10)==0 ? -1 : (curr*10)+(curr%10)-1;
			if(newUp<n)que.offer(newUp);
			if(newDown<n)que.offer(newDown);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getAllJumingNum(65));
	}

}
