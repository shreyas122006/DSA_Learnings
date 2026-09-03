import java.util.ArrayList;

public class cyclegraph {
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

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 3));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 5));
  }
  public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    for(int i=0;i<graph.length; i++) {
      if(!vis[i]) {
        if(detectCycleUtil(graph,vis,i,-1)) {
          return true;
          //cycle exists in one of the parts
        }
      }
    }
    return false;
  }
  public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[], int curr, int par) { //O(V+E)
    vis[curr] = true;
    for(int i=0; i<graph[curr].size();i++) {
      Edge e = graph[curr].get(i);
      //Case 3
      if(!vis[e.dest]) {
        if(detectCycleUtil(graph,vis,e.dest,curr)) {
        return true;
        }
      }
      //Case 1
      else if(vis[e.dest]&&e.dest!=par) {
        return true;
      }
      //case 2 -> do nothing -> continue

    }
    return false;
  }
  public static void main(String[] args) {
    //Undirected ->DFS,BFS,DSU
    //Directed ->DFS,BFS,Topological Sort(Kahn's Algorithm)
    //Case 1.vis[neigh] correct and not the parent then return true
    //Case 2.vis[neigh] correct and parent then continue
    //Case 3.vis[neigh] not correct ->normal dfs call(visit) return true
    int V = 7;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    System.out.println(detectCycle(graph));
  }
}
