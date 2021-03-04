package strings;

public class MaxUniqueCharLen {
	public static int lengthOfLongestSubstring(String s) {
        int[] seq = new int[128];
        int i = 0;
        int j = 0;
        int max = 0;
        while(j<s.length()){
            int right = (int)s.charAt(j);
            seq[right]++;
            if(seq[right]>1){
                while(i<j && seq[right]>1){
                    seq[(int)s.charAt(i)]--;
                    i++;
                }
            }
            else{
                max = Math.max(max,(j-i+1));
                j++;
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(lengthOfLongestSubstring("abcabc"));
	}

}
