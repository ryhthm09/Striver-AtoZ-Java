import java.util.*;
import java.io.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0){
            return 0;
        }
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //return minSum(triangle,0,0,dp,n);
        for(int j=0;j<triangle.get(n-1).size();j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d=triangle.get(i).get(j)+dp[i+1][j];
                int dg=triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j]=Math.min(d,dg);
            }
        }
        return dp[0][0];
    }
    public int minSum(List<List<Integer>> triangle,int i,int j,int [][]dp,int n){
        if(i==n-1){
            return dp[i][j]=triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1)return dp[i][j];

        int d=triangle.get(i).get(j)+minSum(triangle,i+1,j,dp,n);
        int dg=triangle.get(i).get(j)+minSum(triangle,i+1,j+1,dp,n);

        return dp[i][j]=Math.min(d,dg);
    }
}