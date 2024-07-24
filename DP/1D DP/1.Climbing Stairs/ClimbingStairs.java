class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1)return 1;
        
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        //return stairs(n,n,dp);
    }
    public int stairs(int ind,int n,int dp[]){
        if(ind==0 || ind==1)return dp[ind];
        
        if(dp[ind]!=-1)return dp[ind];
        int left=stairs(ind-1,n,dp);
        int right=stairs(ind-2,n,dp);
        dp[ind]=left+right;
        return dp[ind];
    }
}