class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int n=nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        //return calculateMax(nums,dp,n);
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        

        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=dp[i-2];
                int nonpick=dp[i-1];
                dp[i]=Math.max(pick,nonpick);
            }
            
        }
        return dp[n-1];
    }
    public int calculateMax(int nums[],int dp[],int ind){
        if(ind==0)return nums[0];

        

        if(ind<0)return 0;

        if(dp[ind]!=-1)return dp[ind];
        int pick=nums[ind]+calculateMax(nums,dp,ind-2);
        int nonpick=0+calculateMax(nums,dp,ind-1);

        return dp[ind]=Math.max(pick,nonpick);
    }
}