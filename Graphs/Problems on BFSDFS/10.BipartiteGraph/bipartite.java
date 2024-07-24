class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        Arrays.fill(col,-1);
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                if(DFS(i,0,graph,col)==false)return false;
            }
        }
        return true;
    }
    public boolean BFS(int start,int graph[][],int col[]){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        col[start]=0;
        int color=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            
            for(int i=0;i<graph[node].length;i++){

                if(col[graph[node][i]]==-1){
                    queue.add(graph[node][i]);
                    if(col[node]==0)col[graph[node][i]]=1;
                    else col[graph[node][i]]=0;
                }
                else if(col[graph[node][i]]==col[node])return false;
            }
        }
    return true;
    }
    public boolean DFS(int start,int color,int graph[][],int col[]){
        col[start]=color;
        int newColor=0;
        if(color==0)newColor=1;
        else newColor=0;

        for(int i=0;i<graph[start].length;i++)
         if(col[graph[start][i]]==-1){
            if(DFS(graph[start][i],newColor,graph,col)==false)return false;
         }else if(col[graph[start][i]]==color)return false;

         return true;
    }
}