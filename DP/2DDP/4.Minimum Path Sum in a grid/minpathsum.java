class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int dp[][]=new int[m][n];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        dp[0][0]=grid[0][0];
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
            if(i!=0 || j!=0){
                int up = grid[i][j];
                    if (i > 0)
                        up += dp[i - 1][j]; // Add the value from above if it's not out of bounds
                    else
                        up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

                    int left = grid[i][j];
                    if (j > 0)
                        left += dp[i][j - 1]; // Add the value from the left if it's not out of bounds
                    else
                        left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

                    // Store the minimum of the two possible paths
                    dp[i][j] = Math.min(up, left);
            }
           }
        }
        return dp[m-1][n-1];
        //return minSum(grid,m-1,n-1,dp);

    }
    public int minSum(int [][]grid,int i,int j,int [][]dp){
        int leftCount=Integer.MAX_VALUE,rightCount=Integer.MAX_VALUE;
        if(i==0 && j==0)return grid[i][j];

        if(dp[i][j]!=-1)return dp[i][j];

        

        if(i>0)leftCount=grid[i][j]+minSum(grid,i-1,j,dp);
        if(j>0)rightCount=grid[i][j]+minSum(grid,i,j-1,dp);

        return dp[i][j]=Math.min(leftCount,rightCount);

    }
}