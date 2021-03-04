package september;

public class Search2Darray {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int idx = findRow(matrix,target);
        if(idx==-1)return false;
        return binarySearch(matrix[idx],target);
    }
    public static boolean binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<target){
                start = mid +1;
            }
            else if(arr[mid]>target){
                end = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static int findRow(int[][] matrix,int target){
    	int col = matrix[0].length-1;
        for(int i = 0;i < matrix.length && col>0; i++){
            if(matrix[i][col]>=target)return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,7},{12,15,29},{44,210,2000}};
		System.out.println(searchMatrix(matrix, 2));
	}

}
