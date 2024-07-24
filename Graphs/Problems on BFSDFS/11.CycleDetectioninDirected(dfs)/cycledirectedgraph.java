//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
         int indegree[]=new int[V];
         Queue<Integer>queue=new LinkedList<>();
         int n=adj.size();
         for(int i=0;i<n;i++){
             for(Integer node:adj.get(i)){
                 indegree[node]++;
             }
         }
         for(int i=0;i<V;i++){
             if(indegree[i]==0){
                 queue.add(i);
             }
         }
         int topo[]=new int[V];
         int i=0;
         
         while(!queue.isEmpty()){
             int node=queue.peek();
             queue.remove();
             topo[i++]=node;
             for(Integer it:adj.get(node)){
                 indegree[it]--;
                 if(indegree[it]==0)queue.add(it);
             }
         }
         if(i==V)return false;
         else return true;
         
     }
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
    //     int vis[]=new int[V];
    //     int pathvis[]=new int[V];
    //     for(int i=0;i<V;i++){
    //         if(vis[i]!=1){
    //             if(DFS(i,vis,pathvis,adj)==true)return true;
    //         }
    //     }
    //     return false;
    // }
    // public boolean DFS(int start,int vis[],int pv[],ArrayList<ArrayList<Integer>>adj){
    //     vis[start]=1;
    //     pv[start]=1;
        
    //     for(Integer node:adj.get(start)){
    //         if(vis[node]!=1 && pv[node]!=1){
    //             if(DFS(node,vis,pv,adj)==true)return true;
    //         }else if(vis[node]==1 && pv[node]==1)return true;
    //     }
    //     pv[start]=0;
    //     return false;
    // }
}