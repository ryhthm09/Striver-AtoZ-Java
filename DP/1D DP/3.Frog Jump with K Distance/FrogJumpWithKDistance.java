//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int dp[]=new int[N];
        Arrays.fill(dp,-1);
        dp[0]=0;
        int right=Integer.MAX_VALUE;
        for(int i=1;i<N;i++){
            int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            if(i>1)right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            dp[i]=Math.min(right,left);
        }
        return dp[N-1];
        //return minJumps(arr,dp,N-1);
    }
    public static int minJumps(int arr[],int[]dp,int ind){
        if(ind==0)return 0;
        
        int right =Integer.MAX_VALUE;
        if(dp[ind]!=-1)return dp[ind];
        
        int left=minJumps(arr,dp,ind-1)+Math.abs(arr[ind]-arr[ind-1]);
        if(ind>1)right=minJumps(arr,dp,ind-2)+Math.abs(arr[ind]-arr[ind-2]);
        dp[ind]=Math.min(left,right);
        return dp[ind];
    }
}