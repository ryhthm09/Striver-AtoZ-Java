class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected==null || isConnected.length==0)
        return 0;

        int cnt=0;
        int n=isConnected.length;

        boolean vis[]=new boolean[n+1];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(isConnected,vis,i);
                cnt++;
            }
        }
        return cnt;
    }

    public static void bfs(int [][] isConnected,boolean[] vis,int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=1;i<isConnected.length;i++){
                if(isConnected[node][i]==1 && !vis[i]){
                    q.add(i);
                    vis[i]=true;
                }
            }

        }
    }
}