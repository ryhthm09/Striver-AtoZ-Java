class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)cntFresh++;
            }
        }
        int tm=0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int count=0;
        while(!queue.isEmpty()){
            int r=queue.peek().row;
            int c=queue.peek().col;
            int t=queue.peek().tm;
            tm=Math.max(t,tm);
            queue.remove();
            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    queue.add(new Pair(nr,nc,tm+1));
                    vis[nr][nc]=2;
                    count++;
                }
            }
        }
        if(cntFresh!=count)return -1;
        else return tm;
    }
}