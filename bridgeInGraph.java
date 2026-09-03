import java.util.ArrayList;

public class bridgeInGraph {
      static class Edge {
    int src;
    int dest;
    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }
    static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));
    // graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 3));
    // graph[4].add(new Edge(4, 5));

    // graph[5].add(new Edge(5, 3));
    // graph[5].add(new Edge(5, 4));
  }
  public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time) {
    vis[curr] = true;
    dt[curr] = low[curr] = ++time;
    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i); //e.src --- e.dest
      int neigh = e.dest;
      if(neigh == par) {
        continue;
      } else if (!vis[neigh]) {
        dfs(graph, neigh, curr, dt, low, vis, time);
        low[curr] = Math.min(low[curr], low[neigh]);
        if(dt[curr]<low[neigh]) {
          System.out.println("Bridge : " + curr + " --- " + neigh);
        } 
      } else {
          low[curr] = Math.min(low[curr], dt[neigh]);
        }
      }
    }
  public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
    int dt[] = new int[V];
    int low[] = new int[V];
    int time = 0;
    boolean vis[] = new boolean[V];
    for(int i=0; i<V; i++) {
      if(!vis[i]) {
        dfs(graph,i,-1,dt,low,vis,time);
      }
    }
  }
  public static void main(String[] args) { //O(V+E)
    //Bridge is an edge whose deletion increases the graph's number of connected components
    //undirected DFS
    //tarjan's algorithm -> bridge, articulation point
    //dt[] -> discovery time of node
    //low[] -> lowest discovery time of all neighbours(including node)
    // dt[u] < low[v] where u is src and v is dest
    // disc[curr] = low[curr] = ++time
    // for(all neigh) {
    // Edge e //src, dest }
    // 1. neigh = par - ignore
    // 2. !vis[neigh] 
    //    dfs(neigh)
    //    low[curr] = min(low[curr], low[neigh])
    //    if(dt[curr] < low[neigh]) print(Bridge(curr,neigh))
    // 3. vis[neigh]
    //    low[curr] = min(low[curr], dt[neigh]) // we consider single back edge
    //               dfs(0)
    //               /    \
    //           dfs(1)   dfs(3)
    //            /         \
    //          dfs(2)      dfs(4)
    //                       /
    //                     dfs(5)
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    tarjanBridge(graph, V);
    }
}
