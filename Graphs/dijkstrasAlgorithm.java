import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstrasAlgorithm {
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
  static class Pair implements Comparable<Pair>{
    int n;
    int path;
    public Pair(int n, int path) {
      this.n = n;
      this.path = path;
    }
    @Override
    public int compareTo(Pair P2) {
      return this.path-P2.path; // path based sorting for my pairs
    }
  }
  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 5, 1));
    
    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));

  }
  public static void dijkstra(ArrayList<Edge>[] graph, int src) {
    int dist[] = new int[graph.length]; // dist[i] -> src to i
    for(int i=0; i<graph.length; i++) {
      if(i!=src) {
        dist[i] = Integer.MAX_VALUE; //+infinty
      }
    }
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src,0));
    //loop
    while(!pq.isEmpty()) {
      Pair curr = pq.remove();
      if(!vis[curr.n]) {
        vis[curr.n] = true;
        //neighbours
        for(int i=0; i<graph[curr.n].size(); i++) {
          Edge e = graph[curr.n].get(i);
          int u = e.src;
          int v = e.dest;
          int wt = e.weight;
          if(dist[u] + wt < dist[v]) { //update distance of src to v;
            dist[v] = dist[u] + wt;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
    }
    //print all source to vertices shortest dist
    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i]+" ");
    }
    System.out.println();
  }
  public static void main(String[] args) { // O(V+ElogV) with PQ else O(V^2)
    //shortest paths from the source to all vertices(weighted graph)
    //dis[u] + wt(u,v) < dis[v] 
    //dis[v] = dis[u] + wt(u,v)
    // not visited but shortest
    //1.Initialize Distance
    //2.PriorityQueue<Pair> (n,dist) sort on basis of distance
    //while(pq is not empty) 
    // curr -> visit
    // if(vis[curr] = false) {
    //neighbours -> dis[u] + wt(u,v) < dis[v] update dis[v]
    int V = 6;
    ArrayList<Edge>[] graph = new ArrayList[V];
    createGraph(graph);
    dijkstra(graph, 0);

  }
}
