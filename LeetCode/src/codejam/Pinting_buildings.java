package codejam;

import java.util.Scanner;

public class Pinting_buildings {
	//solver 2 works
	public static long solver2(int index,int now_k_count,int[] building,long[][] matrix,int K,int[] excluded,long[][][] dp3){
        if(now_k_count>K){
            return Long.MAX_VALUE;
        }
        if(index==building.length){
            if(now_k_count==K){
                return 0;
            }
            return Long.MAX_VALUE;
        }
        if(excluded[index]==1){
            if(index>0 && building[index-1]==building[index]){
                return solver2(index+1,now_k_count,building,matrix,K,excluded,dp3);
            }
            else{
                return solver2(index+1,now_k_count+1,building,matrix,K,excluded,dp3);
            }
        }
        long min = Long.MAX_VALUE;
        for(int i =0;i<matrix[index].length;i++){
            building[index] = i+1;
            long ret_val;
            if(index>0 && building[index-1]==building[index]){
                if(dp3[index][now_k_count][i+1]==0){
                    ret_val = solver2(index+1,now_k_count,building,matrix,K,excluded,dp3);
                    dp3[index][now_k_count][i+1] = ret_val;
                }
                else{
                    ret_val = dp3[index][now_k_count][i+1];
                }
                if(ret_val==Long.MAX_VALUE){
                    min = Math.min(min,Long.MAX_VALUE);
                }
                else{
                    min = Math.min(ret_val+matrix[index][i],min);
                }
            }
            else{
                if(dp3[index][now_k_count+1][i+1]==0){
                    ret_val = solver2(index+1,now_k_count+1,building,matrix,K,excluded,dp3);
                    dp3[index][now_k_count+1][i+1] = ret_val;
                }
                else{
                    ret_val = dp3[index][now_k_count+1][i+1];
                }
               // ret_val = solver2(index+1,now_k_count+1,building,matrix,K,excluded,dp3);
                if(ret_val==Long.MAX_VALUE){
                    min = Math.min(min,Long.MAX_VALUE);
                }
                else{
                    min = Math.min(ret_val+matrix[index][i],min);
                }
            }
        }
        return min;
    }

	public static long solver(int idx,int now_k,int[] build,long[][] matrix,int K , long[][] dp2) {
		if(now_k>K) {
			return Long.MAX_VALUE;
		}
		if(idx == build.length) {
			if(now_k==K) {
				return 0;
			}
			return Long.MAX_VALUE;
		}
		if(dp2[idx][now_k] >0) {
			System.out.println("returning");
			//return dp2[idx][now_k];
		}
		if(build[idx]!=0) {
			if(idx>0 && build[idx-1]==build[idx]) {
				long ans = solver(idx+1, now_k, build, matrix, K, dp2);
			//	dp[idx][now_k][build[idx]] = ans;
				return ans;
			}
			else {
				long ans = solver(idx+1, now_k+1, build, matrix, K, dp2);
			//	dp[idx][now_k+1][build[idx]] = ans;
				return ans;
			}
		}
		long min = Long.MAX_VALUE;
		for (int i = 0; i < matrix[idx].length; i++) {
			//selecting all colors for painting
			long ret;
			build[idx] = i+1;
			if(idx>0 && build[idx-1]==i+1) {
				ret =solver(idx+1, now_k, build, matrix, K, dp2);
				if(ret == Long.MAX_VALUE) {
					min = Math.min(min, Long.MAX_VALUE);
				}
				else {
					min = Math.min(min,matrix[idx][i]+ret);
				}
				build[idx] = 0;
			}
			else {
				ret =solver(idx+1, now_k+1, build, matrix, K, dp2);
				if(ret == Long.MAX_VALUE) {
					min = Math.min(min,Long.MAX_VALUE);
				}
				else {
					min = Math.min(min,matrix[idx][i]+ret);
				}
				build[idx]= 0;
			}
		}
		dp2[idx][now_k] = min;
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sf = new Scanner(System.in);
		int test = sf.nextInt();
		for (int i = 0; i < test; i++) {
			int n =sf.nextInt();
			int m =sf.nextInt();
			int k =sf.nextInt();
			int[] build = new int[n];
			for (int j = 0; j < n; j++) {
				build[j] = sf.nextInt();
			}
			long[][] matrix = new long[n][m];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					matrix[j][j2] = sf.nextInt();
				}
			}
			long[][] dp2 = new long[n][k+2];
			long ans = solver(0, 0, build, matrix, k,dp2);
			if(ans==Long.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(ans);
			}
		}
		//sf.close();
	}

}
