class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        int mini=Integer.MAX_VALUE;
       // for(int  i=0;i<m;i++){
         //   int ans=minSum(matrix,dp,n,0,i);
           // mini=Math.min(mini,ans);
        //}
        //return mini;
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for( int i=1;i<n;i++){
            for(int j=0;j<m;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];

                int left=matrix[i][j];
                if(j-1>=0){
                    left+=dp[i-1][j-1];
                }else{
                    left+=(int)Math.pow(10,9);
                }
                int right=matrix[i][j];
                if(j+1<m){
                    right+=dp[i-1][j+1];
                }else{
                    right+=(int)Math.pow(10,9);
                }

                dp[i][j]=Math.min(up,Math.min(left,right));
            }
        }
        
        for(int i=0;i<m;i++){
            int ans=dp[n-1][i];
            mini=Math.min(ans,mini);
        }
        return mini;
    }
    public int minSum(int[][] matrix,int [][]dp,int n,int i,int j){
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE; // Handle out of bounds
        }
        if(i==n-1){
            return dp[i][j]=matrix[i][j];
        }
        if(dp[i][j]!=-1)return dp[i][j];

        int d=matrix[i][j]+minSum(matrix,dp,n,i+1,j);
        int d1=(j + 1 < n) ?matrix[i][j]+minSum(matrix,dp,n,i+1,j+1):Integer.MAX_VALUE;
        int d2=(j - 1>=0)?matrix[i][j]+minSum(matrix,dp,n,i+1,j-1):Integer.MAX_VALUE;

        return dp[i][j]=Math.min(d,Math.min(d1,d2));
    }
}