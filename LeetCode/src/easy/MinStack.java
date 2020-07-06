package easy;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
	ArrayList<Integer> min_list= new ArrayList<Integer>();
	Stack<Integer> curr = new Stack<Integer>();
	public MinStack() {
       
    }
    public int findIndex(ArrayList<Integer> list,int x) {
    	int start = 0;
    	int end = list.size()-1;
    	int ans=0;
    	while(start<=end) {
    		int mid = (start+end)/2;
    		if(list.get(mid)>x) {
    			end = mid-1;
    		}
    		else {
    			ans = mid+1;
    			start = mid+1;
    		}
    	}
    	return ans;
    }
    public void push(int x) {
        //here we can use binary search to optimize
        if(this.min_list.size()>0) {
        	this.min_list.add(findIndex(this.min_list, x),x);
        }
        else {
        	this.min_list.add(x);
        }
        /*
        for(int i=0;i<this.min_list.size(); i++){
            if(this.min_list.get(i)>x){
            	flag=1;
            	this.min_list.add(i, x);
            	break;
            }
        }
        if(flag==0) {
        	min_list.add(x);
        }*/
		/*
		 * if(this.min_list.isEmpty()) { min_list.add(x); }
		 */
        this.curr.push(x);
    }
    
    public void pop() {
    	this.min_list.remove(new Integer(this.curr.get(this.curr.size()-1)));
        this.curr.pop();
    }
    
    public int top() {
        return this.curr.get(this.curr.size()-1);
    }
    
    public int getMin() {
        return this.min_list.get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();
		obj.push(0);
		obj.push(1);
		obj.push(0);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
	}

}
