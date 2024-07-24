class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int dp[][]=new int[m][n];
       for(int []rows:dp){
        Arrays.fill(rows,-1);
       }
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            
            if(i==0 && j==0 ){
                if(obstacleGrid[i][j]==1){
                   dp[i][j]=0;
                   continue;
                }else{
                    dp[i][j]=1;
                    continue;
                }
               
            }
            int up=0;
            int left=0;
            if(obstacleGrid[i][j]==1)dp[i][j]=0;
            if(i>0 && obstacleGrid[i-1][j]!=1)up=dp[i-1][j];
            if(j>0 && obstacleGrid[i][j-1]!=1)left=dp[i][j-1];
         
            dp[i][j]=up+left;
        }
       }
       return dp[m-1][n-1];
       //return unique(m-1,n-1,dp,obstacleGrid);
    }
     public int unique(int i,int j,int [][]dp,int [][]obstacleGrid){
        int leftCount=0,rightCount=0;
        if(i==0 && j==0){
            return 1;
        }
        if(obstacleGrid[i][j]==1)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        if(i>0 && obstacleGrid[i-1][j]!=1)leftCount=unique(i-1,j,dp,obstacleGrid);
        if(j>0 && obstacleGrid[i][j-1]!=1)rightCount=unique(i,j-1,dp,obstacleGrid);

        return dp[i][j]=leftCount+rightCount;
    }
}