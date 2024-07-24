class Solution {
    public int uniquePaths(int m, int n) {
       int dp[][]=new int[m][n];
       for(int []rows:dp){
        Arrays.fill(rows,-1);
       } 
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 && j==0){
                dp[i][j]=1;
                continue;
            }
            int up=0;
            int left=0;
            if(i>0)up=dp[i-1][j];
            if(j>0)left=dp[i][j-1];
            dp[i][j]=up+left;
        }
       }
       return dp[m-1][n-1];
       //return unique(m-1,n-1,dp);
    }
    public int unique(int i,int j,int [][]dp){
        int leftCount=0,rightCount=0;
        if(i==0 && j==0){
            return 1;
        }

        if(dp[i][j]!=-1)return dp[i][j];

        if(i>0)leftCount=unique(i-1,j,dp);
        if(j>0)rightCount=unique(i,j-1,dp);

        return dp[i][j]=leftCount+rightCount;
    }
}