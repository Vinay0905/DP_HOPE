package java_solutions.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    ArrayList<ArrayList<Integer>> g;
    int data;
    public Graph(int data){
        this.data=data;
        g=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<data;i++){
            g.add(new ArrayList<Integer>());

        }
    }
    public void addEdge(int src,int dest){
        g.get(src).add(dest);
        g.get(dest).add(src);
    }
    public void display(){
        for(int i=0;i<data;i++){
            System.out.println("Node : "+i);
            for(int v:g.get(i)){
                System.out.println("-> "+v);

            }
            System.out.println();
        }
    }
    // public void bfs(int start){

    //     boolean[] visited = new boolean[data];
    //     Queue<Integer> q= new LinkedList<>();
    //     visited[start]=true;
    //     q.add(start);
    //     System.out.println("BFS Traversal Starting from "+start+": ");
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         System.out.println(node+" ");

    //     }
    // }
    public void bfs(int start){
        boolean [] visited = new boolean[data];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        System.out.print("BFS Traversal starting from "+start+": ");
        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for (int neighbor: g.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start){
        boolean[] visited = new boolean[data];
        System.out.print("DFS Traversal starting from "+start+": ");
        dfsHelper(start,visited);
        System.out.println();
    }
    private void dfsHelper(int node , boolean[] visited){
        visited[node]=true;
        System.out.print(node+" ");
        for (int neighbor: g.get(node)){
            if(!visited[neighbor]){
                dfsHelper(neighbor,visited);
            }
        }
    }
    public List<Integer> getAdjVertices(int vertex) {
        return g.get(vertex);
    }
    public static void main(String[] args) {
    Graph graph = new Graph(5); 
    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);

    System.out.println("Adjacency list of vertex 1: " + graph.getAdjVertices(1));
    graph.bfs(0);
}

}

