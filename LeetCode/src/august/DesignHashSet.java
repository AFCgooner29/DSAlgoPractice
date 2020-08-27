package august;

import java.util.HashMap;

public class DesignHashSet {
	class MyHashSet {
		HashMap<Integer, Integer> data;
	    /** Initialize your data structure here. */
	    public MyHashSet() {
	        this.data = new HashMap<Integer, Integer>();
	    }
	    
	    public void add(int key) {
	        if(!this.data.containsKey(key)) {
	        	this.data.put(key,1);
	        }
	    }
	    
	    public void remove(int key) {
	        this.data.remove(key);
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        return this.data.containsKey(key);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
