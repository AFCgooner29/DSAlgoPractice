package arrays;

public class MinSlidingSubstringLength {
	public static String minWindow(String A, String B) {
        int target = B.length();
        int i = 0;
        int j = 0;
        int minX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int[] pat = new int[128];
        int[] src = new int[128];
        generateHash(B,pat);
        while(j<A.length()){
            if(target>0){
                int idx = (int)A.charAt(j);
                if(pat[idx]!=0 && src[idx]<pat[idx]){
                    target--;
                }
                src[idx]++;
                j++;
            }
            else{
                int idx = (int)A.charAt(i);
                if(target==0 && (minX == Integer.MIN_VALUE || minY-minX > (j-i))){
                    minX = i;
                    minY = j;
                }
                if(pat[idx]!=0 && src[idx]<=pat[idx]){
                    target++;
                }
                src[idx]--;
                i++;
            }
        }
        while(target==0){
        	int idx = (int)A.charAt(i);
            if(target==0 && (minX == Integer.MIN_VALUE || minY-minX > (j-i))){
                minX = i;
                minY = j;
            }
            if(pat[idx]!=0 && src[idx]<=pat[idx]){
                target++;
            }
            src[idx]--;
            i++;
        }
        if(minX==Integer.MIN_VALUE)return "";
        return A.substring(minX,minY);
    }
    public static void generateHash(String S,int[] hash){
        for(char i : S.toCharArray()){
            hash[(int)i]++;
        }
        return;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

}
