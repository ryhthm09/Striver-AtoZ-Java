class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];

        for(int i=0;i<m;i++){
            if(vis[0][i]!=1 && board[0][i]=='O'){
                DFS(0,i,vis,board,n,m);
            }
            if(vis[n-1][i]!=1 && board[n-1][i]=='O'){
                 DFS(n-1,i,vis,board,n,m);
            }
           }
        for(int i=0;i<n;i++){
            if(vis[i][0]!=1 && board[i][0]=='O'){
                DFS(i,0,vis,board,n,m);
            }
            if(vis[i][m-1]!=1 && board[i][m-1]=='O'){
                DFS(i,m-1,vis,board,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void DFS(int i,int j,int vis[][],char [][]board,int n,int m){
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int nr=i+dx[k];
            int nc=j+dy[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=1 && board[nr][nc]=='O'){
                DFS(nr,nc,vis,board,n,m);
            }
        }
    }
}