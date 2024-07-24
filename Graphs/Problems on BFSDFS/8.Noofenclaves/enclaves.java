class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for(int j=0;j<m;j++){
            if(vis[0][j]!=1 && grid[0][j]==1){
                DFS(0,j,vis,grid,n,m);
            }
            if(vis[n-1][j]!=1 && grid[n-1][j]==1){
                DFS(n-1,j,vis,grid,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]!=1 && grid[i][0]==1){
                DFS(i,0,vis,grid,n,m);
            }
            if(vis[i][m-1]!=1 && grid[i][m-1]==1){
                DFS(i,m-1,vis,grid,n,m);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public void DFS(int i,int j,int vis[][],int grid[][],int n,int m){
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int nr=i+dx[k];
            int nc=j+dy[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=1 && grid[i][j]==1){
                DFS(nr,nc,vis,grid,n,m);
            }
        }
    }
}