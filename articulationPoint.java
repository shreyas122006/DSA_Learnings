import java.util.ArrayList;

public class articulationPoint {
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

    graph[4].add(new Edge(4, 3));
  }
  //O(V+E)
  public static void dfs(ArrayList<Edge> graph[], int curr,int par, int dt[], int low[], int time, boolean vis[], boolean ap[]) {
    vis[curr] = true;
    dt[curr] = low[curr] = ++time;
    int children = 0;
    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      int neigh = e.dest;

      if(par == neigh) {
        continue;
      } else if(vis[neigh]) {
        low[curr] = Math.min(low[curr], dt[neigh]);
      } else {
        dfs(graph, neigh, curr, dt, low, time, vis, ap);
        low[curr] = Math.min(low[curr], low[neigh]);
        if(par!= -1 && dt[curr] <= low[neigh]) {
          ap[curr] = true;
          // System.out.println("Ap : "+ curr);
        }
        children++;
      }
    }
    if(par == -1 && children > 1) {
      ap[curr] = true;
      // System.out.println("Ap : "+ curr);
    }
  }
  public static void getAP(ArrayList<Edge> graph[], int V) {
    int dt[] = new int[V];
    int low[] = new int [V];
    int time = 0;
    boolean vis[] = new boolean[V];
    boolean ap[] = new boolean[V];
    for(int i=0 ;i<V; i++) {
      if(!vis[i]) {
        dfs(graph, i, -1, dt, low, time, vis, ap);
      }
    }//print all APs
    for(int i=0 ;i<V; i++) {
      if(ap[i]) {
        System.out.println("Ap : "+ i);
      }
    }
  }
  public static void main(String[] args) { //O(V+E) || naive approach O(V*(V+E))
    //A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it) increases the connected components of graph.
    //tarjan's Algorithm
    //Ancestor and child
    //A node A that was discovered before curr node in DFS, is the ancestor of curr
    //discovery time
    // child -> unvisited
    // Node -> AP  3 cases
    // 1. starting pt of DFS par == -1
    //    disconnected children > 1 (AP) where disconnected children are    unvisited neighbours
    // 2. Single edge from U to V no back edge -> AP
    //    dt[u] < low[v]
    // 3. Starting point of cycle / root of cycle -> AP
    //    dt[u] = low[v]
    // so the condition for 2&3 becomes par!=-1 && dt[u] <= low[v] where u is curr and v is neigh
    // children = 0;
    // for(neigh) Edge e // e.dest = neigh
    // 1.neigh = par -> ignore
    // vis[neigh] //back edge
    // low[curr] = min(low[curr], dt[neigh])
    // !vis[neigh] //children (disconnected)
    // dfs -> visit
    // low[curr] = min(low[curr],low[neigh])
    // if(par!=-1 && dt[curr] <= low[high]) | -> AP2
    // print AP                             |
    // children++                           |
    // if(par==-1 && children>1)            | -> AP1
    // print AP                             |
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    getAP(graph,V);
  }
}
