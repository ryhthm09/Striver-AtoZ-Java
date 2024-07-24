//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>>st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String>vec=new ArrayList<>();
                    DFS(i,j,grid,vec,vis,i,j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
    private String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    void DFS(int row,int col,int [][]grid,ArrayList<String>vec,int vis[][],int row0,int col0){
        vis[row][col]=1;
        vec.add(toString(row-row0,col-col0));
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nr=row+dx[i];
            int nc=col+dy[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=1 && grid[nr][nc]==1){
                DFS(nr,nc,grid,vec,vis,row0,col0);
            }
        }
    }
}
