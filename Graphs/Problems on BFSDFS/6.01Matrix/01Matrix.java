class Pair{
    int row;
    int col;
    int distance;
    Pair(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int dis[][]=new int[n][m];


        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};

        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int distance=queue.peek().distance;
            queue.poll();
            dis[row][col]=distance;
            for(int i=0;i<4;i++){
                int nr=row+dx[i];
                int nc=col+dy[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=1){
                    vis[nr][nc]=1;
                    queue.add(new Pair(nr,nc,distance+1));
                }
            }
            
        }
        return dis;

    }
}