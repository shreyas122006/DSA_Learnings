import java.util.ArrayList;
import java.util.PriorityQueue;

public class minimumSpanningTree {
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
    static class Pair implements Comparable<Pair> {
      int v;
      int cost;
      public Pair(int v, int c) {
        this.v = v;
        this.cost = c;
      }
      @Override
      public int compareTo(Pair P2) {
        return this.cost - P2.cost;
      }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 2, 15));
    graph[0].add(new Edge(0, 3, 30));

    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 3, 40));

    graph[2].add(new Edge(2, 0, 15));
    graph[2].add(new Edge(2, 3, 50));

    graph[3].add(new Edge(3, 1, 40));
    graph[3].add(new Edge(3, 2, 50));

  }
  public static void prims(ArrayList<Edge> graph[]) {
    boolean[] vis = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0, 0));
    int finalCost = 0; //MST Cost / total min weight
    while(!pq.isEmpty()) {
      Pair curr = pq.remove();
      if(!vis[curr.v]) {
        vis[curr.v] = true;
        finalCost+=curr.cost;
        for(int i=0; i<graph[curr.v].size(); i++) {
          Edge e = graph[curr.v].get(i);
          pq.add(new Pair(e.dest,e.weight));

        }
      }
    }
    System.out.println("Final(min) Cost of MST = " + finalCost);

  }
  public static void main(String[] args) {
    // A minimum spanning tree(MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
    //subgraph -> 1.No cycle 2.Vertices connect, 3.Weight(min)
    //Prims Algorithm MST set
    // Undirected + weighted graph
    int V = 4;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    prims(graph);
  }
}
