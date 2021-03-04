package easy;

public class RemoveElements {
	public static int removeElement(int[] nums, int val) {
        int j = nums.length-1;
        while(nums[j]==val){
                    j--;
        }
        for(int i=0;i<nums.length && i<j;i++){
            if(nums[i]==val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                while(nums[j]==val){
                    j--;
                }
            }
        }
        
        return (nums.length);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,2,2,3};
		removeElement(arr, 2);
	}

}
