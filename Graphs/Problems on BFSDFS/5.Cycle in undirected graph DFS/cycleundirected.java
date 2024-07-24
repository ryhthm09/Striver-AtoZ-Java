//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(Cycle(i,-1,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean Cycle(int start,int parent,ArrayList<ArrayList<Integer>>adj,int vis[]){
        vis[start]=1;
        for(Integer it:adj.get(start)){
            if(vis[it]!=1){
                if(Cycle(it,start,adj,vis)){
                    return true;
                }
            }
            else if(parent!=it){
                return true;
            }
        }
        return false;
        
    }
    // public boolean Cycle(int start,ArrayList<ArrayList<Integer>>adj,int vis[]){
    //     Queue<Pair> queue=new LinkedList<>();
    //     queue.add(new Pair(start,-1));
    //     vis[start]=1;
        
    //     while(!queue.isEmpty()){
    //         int node=queue.peek().first;
    //         int parent=queue.peek().second;
    //         queue.remove();
            
            
    //         for(Integer i:adj.get(node)){
    //             if(vis[i]!=1){
    //                 queue.add(new Pair(i,node));
    //                 vis[i]=1;
    //             }else if(parent!=i){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}