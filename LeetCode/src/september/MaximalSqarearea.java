package september;
//https://leetcode.com/problems/maximal-square/solution/
public class MaximalSqarearea {
    public static int maximalSquare(char[][] matrix) {
        //brute force
        int max = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    //we need to move diagonally and check if the next diagonal is possible
                    boolean failed = false;
                    int len = 1;
                    while(len+i<matrix.length && len+j<matrix[i].length && !failed){
                        for(int k = i;k<=len+i;k++){
                            //check if row is ok
                            if(matrix[k][j+len]=='0'){
                                failed = true;
                                break;
                            }

                        }
                        for(int k = j;k<=j+len && !failed;k++){
                            //check if row is ok
                            if(matrix[len+i][k]=='0'){
                                failed = true;
                            }

                        }
                        if(!failed){
                            len++;
                        }   
                    }
                    max = Math.max(max,len*len);
                }
            }
        }
        return max;
    }
    public static int maximalSquareDP1(char[][] matrix) {
    	int maxLen = 0;
    	if(matrix.length==0)return 0;
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	for (int i = 0; i < dp.length; i++) {
			if(matrix[i][0]=='1')dp[i][0] = 1;
			maxLen = Math.max(maxLen, dp[i][0]);
		}
    	for (int i = 0; i < dp[0].length; i++) {
			if(matrix[0][i]=='1')dp[0][i] = 1;
			maxLen = Math.max(maxLen, dp[0][i]);
		}
    	for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if(matrix[i][j]=='1') {
					dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}
    	return maxLen*maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = {{'1','0','1','1','1'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalSquareDP1(arr));
	}

}
