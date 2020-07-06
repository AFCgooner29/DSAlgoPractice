package segement_tree;
/*
 * Segement Tree
 * this data structure will have leaf nodes as all the values of arr
 * and all the other tree nodes will contain data based on range in arr
 * for eg
 * 
 * 			[0,3]
 * 			 /\
 *          /  \ 
 *       [0,1]  [2,3]
 *       /  \     / \
 *      [0] [1]  [2] [3]
 *      
 * the upper nodes can have data based on logic
 * we can create this tree recursively in a arr with base case as leaf nodes which
 * will give us data of array
 * 
 * we will number every node
 * left node will be stored at 2*P
 * right node will be stored at 2*P+1
 * 
 * Total number of nodes can be
 * 2N-1
 * N is length of array
 */
public class Create_seg_tree {
	public static void buildTree(int[] arr,int[] tree,int start,int end,int treeNode) {
		if(start==end) {
			tree[treeNode] = arr[start];//we have reached the leaf node
			return;
		}
		int mid = (start+end)/2;
		buildTree(arr, tree, start, mid, 2*treeNode);//go find the left child node
		buildTree(arr, tree, mid+1, end, 2*treeNode+1);//go find the right child node
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	}
	
	public static void updateTree(int[] arr,int[] tree,int start,int end,int treeNode,int idx,int value) {
		if(start == end) {
			arr[idx] = value;
			tree[treeNode] = value;
			return;
		}
		int mid = (start+end)/2;
		if(idx<=mid) {
			updateTree(arr, tree, start, mid, 2*treeNode,idx,value);//go find the left child node
		}
		else {
			updateTree(arr, tree, mid+1, end, 2*treeNode+1,idx,value);//go find the right child node
		}
		tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
	} 
	public static int fetch(int[] tree,int start,int end,int treeNode,int left,int right) {
		//start and end are completely inside the range left and right then we can return val at treeNode
		if(start>=left && end<=right) {
			return tree[treeNode];
		}
		//not in range ofleft and right
		else if(start>right || end<left) {
			return 0;
		}
		//now the start and end are partially in range
		int mid = (start+end)/2;
		int ans1 = fetch(tree, start, mid, 2*treeNode, left, right);
		int ans2 = fetch(tree, mid+1, end, 2*treeNode+1, left, right);
		return ans1+ans2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {1,2,3};
		int[] tree = new int[6];
		buildTree(n, tree, 0, n.length-1,1);
		//updateTree(n, tree, 0, 2, 1, 0, 0);
		/*
		 * for (int i = 1; i < tree.length; i++) { System.out.println(tree[i]); }
		 */
		System.out.println(fetch(tree, 0, 2, 1, 1, 2));
	}

}
