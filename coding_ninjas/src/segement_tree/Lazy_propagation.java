package segement_tree;


public class Lazy_propagation {
	public static void buildTree(int[] arr,int[] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
	}
	public static void updateLazy(int[] arr,int[] tree,int[] lazy,int start,int end,int treeNode,int idx,int idy,int incr) {
		if(start>end) {
			return;
		}
		if(lazy[treeNode]!=0) {
			//this means there is already a value that needs to be updated at this node
			//we will update the node in tree and set value in lazy to 0
			//and we will assign the value to child nodes for update
			//the main logic is to not update directly at leaf nodes instead we will
			//update the intermediate nodes and then fetch the updated answer to higher nodes
			//lower nodes will get updated when results from lower nodes are needed
			//as we are storing update values for lower nodes
			tree[treeNode]+=lazy[treeNode];
			if(start!=end) {
				//assigning update value to child nodes
				lazy[2*treeNode] += lazy[treeNode];
				lazy[2*treeNode+1] += lazy[treeNode];
			}
		}
		if(start>idy || end<idx) {
			return;
		}
		else if(start>=idx && end<=idy) {
			tree[treeNode]+=incr;
			if(start!=end) {
				lazy[2*treeNode]+=incr;
				lazy[2*treeNode+1]+=incr;
			}
			return;
		}
		int mid = (start+end)/2;
		updateLazy(arr, tree, lazy, start, mid, 2*treeNode, idx, idy, incr);
		updateLazy(arr, tree, lazy, mid+1, end, 2*treeNode+1, idx, idy, incr);
		tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);//this will update all the parent nodes in case some value is changed in child nodes
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,23,4,2,-1,2};
		int[] tree = new int[24];
		int[] lazy = new int[24];
		buildTree(arr, tree, 0, 5, 1);
		for (int i = 1; i < 24; i++) {
			System.out.println(tree[i]);
		}
		System.out.println("----------------------------");
		updateLazy(arr, tree, lazy, 0, 5, 1, 3, 4, -50);
		for (int i = 1; i < 24; i++) {
			System.out.println(tree[i]);
		}
		System.out.println("----------------------------");
		for (int i = 1; i < 24; i++) {
			System.out.println(lazy[i]);
		}
		System.out.println("----------------------------");
	}

}
