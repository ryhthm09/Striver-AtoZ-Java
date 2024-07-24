//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] points = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    points[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(points, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int points[][], int N) {
        // code here
        int dp[][]=new int[N+1][4];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        //return maxpts(N-1,3,dp,points);
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for(int day=1;day<=N;day++){
            for(int last=0;last<4;last++){
                int maxi=Integer.MIN_VALUE;
                for(int task=0;task<=2;task++){
                    if(task!=last){
                        int ans=points[day][task]+dp[day-1][task];
                        maxi=Math.max(ans,maxi);
                    }
                }
                dp[day][last]=maxi;
            }
        }
        return dp[N][3];
    }
    public int maxpts(int day,int last,int dp[][],int points[][]){
       if(dp[day][last]!=-1)return dp[day][last];
       
        if(day==0){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    max=Math.max(max,points[0][i]);
                }
            }
            
            return dp[day][last]=max;
        }
        
        
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int ans=points[day][i]+maxpts(day-1,i,dp,points);
                max=Math.max(ans,max);
            }
        }
        
        return dp[day][last]=max;
    }
}