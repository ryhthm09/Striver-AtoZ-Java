class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][]ans=image;
        int iniColor=image[sr][sc];
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        DFS(sr,sc,color,iniColor,ans,image,dx,dy);
        return ans;
    }
    public void DFS(int sr,int sc,int color,int iniColor,int ans[][],int image[][],int dx[],int dy[]){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nr=sr+dx[i];
            int nc=sc+dy[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==iniColor && ans[nr][nc]!=color){
                DFS(nr,nc,color,iniColor,ans,image,dx,dy);
            }
        }
    }
}