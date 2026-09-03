import java.util.ArrayList;

public class bellmanFordAlgorithm {
  static class Edge {
    int src;
    int dest;
    int weight;
    public Edge(int s, int d, int wt) {
      this.src = s;
      this.dest = d;
      this.weight = wt;
    }
  }
  //Edge[]
  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 2, -4));

    graph[2].add(new Edge(2, 3, 2));

    graph[3].add(new Edge(3, 4, 4));
    
    graph[4].add(new Edge(4, 1, -1));
  }
  static void createGraph2(ArrayList<Edge> graph) {
    graph.add(new Edge(0, 1, 2));
    graph.add(new Edge(0, 2, 4));
    graph.add(new Edge(1, 2, -4));
    graph.add(new Edge(2, 3, 2));
    graph.add(new Edge(3, 4, 4));
    graph.add(new Edge(4, 1, -1));
  }
  public static void bellmanFord(ArrayList<Edge> graph[], int src) {
    int dist[] = new int[graph.length];
    for(int i=0; i<dist.length; i++) {
      if(i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }
    int V = graph.length;
    //O(V*E)
    //algo - O(V)
    for(int i=0; i<V-1; i++) {
      //edges - O(E)
      for(int j=0; j<graph.length; j++) {
        for(int k=0; k<graph[j].size(); k++) {
          Edge e = graph[j].get(k);
          //u,v,wt
          int u = e.src;
          int v = e.dest;
          int wt = e.weight;
          //relaxation
          if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }
    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i] +" ");
    }
    System.out.println();
  }
  public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
    int dist[] = new int[V];
    for(int i=0; i<dist.length; i++) {
      if(i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }
    //O(VE)
    for(int i=0; i<V-1; i++) {
      //edges - O(E)
      for(int j=0; j<graph.size(); j++) {
          Edge e = graph.get(j);
          //u,v,wt
          int u = e.src;
          int v = e.dest;
          int wt = e.weight;
          //relaxation
          if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
      }
    }
    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i] +" ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    //shortest paths from the source to all vertices(negative edges)
    // dijkstras -> greedy based
    // bellman ford -> Dp based
    // perform this operation V-1 times
    // for all edges (u,v)
    // if dist[u] + wt(u,v) < dist[v] | ->  Relaxation
    //    dist[v] = dist[u] + wt(u,v) |
    // for(int i=0 to V-1) 
    // edge (u->v)
    // Relaxation
    // Note: doesnt work for Negative Weight Cycles
    int V = 5;
    // ArrayList<Edge>[] graph = new ArrayList[V];
    ArrayList<Edge> graph = new ArrayList<>();
    // createGraph(graph);
    createGraph2(graph);
    bellmanFord2(graph, 0, V);
  }
}
