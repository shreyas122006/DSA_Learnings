import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class kruskalsAlgorithm {
  static class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int weight;
    public Edge(int s, int d, int wt) {
      this.src = s;
      this.dest = d;
      this.weight = wt;
    }
    @Override
    public int compareTo(Edge E2) {
      return this.weight-E2.weight;
    }
  }
  static void createGraph(ArrayList<Edge> edges) {
    //edges
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));
    edges.add(new Edge(1, 3, 40));
    edges.add(new Edge(2, 3, 50));
  }
  static int n=4; //vertices
  static int par[] = new int[n];
  static int rank[] = new int[n];
  public static void init() {
    for(int i=0; i<n; i++) {
      par[i] = i;
    }
  }
  public static int find(int x) { //O(1) 
    if(x==par[x]) {
      return x;
    }
    return par[x] = find(par[x]); 
  }
  public static void union(int a, int b) { //O(1) | O(4k) k is constant
    int parA = find(a);
    int parB = find(b);
    if(rank[parA] == rank[parB]) {
      par[parB] = parA;
      rank[parA]++;
    } else if(rank[parA]<rank[parB]) {
      par[parA] = parB;
    } else {
      par[parB] = parA;
    }
  }
  public static void kruskalsMST(ArrayList<Edge> edges, int V) {
    init();
    Collections.sort(edges); //O(ElogE)
    int mstCost = 0;
    int count = 0;
    for(int i=0; count<V-1; i++) { //O(V)
      Edge e = edges.get(i);
      //(src, dest, wt)
      int parA = find(e.src);  // src = a
      int parB = find(e.dest); // src = b
      if(parA != parB) {
        union(e.src, e.dest);
        mstCost+= e.weight;
        count++;
      }
    }
    System.out.println(mstCost);
  }
  public static void main(String[] args) { //O(V+ElogE)
    //1.sort edges
    //2.take min cost edge -> x form cycle then include in ans
    int V = 4;
    ArrayList<Edge> edges = new ArrayList<>();
    createGraph(edges);
    kruskalsMST(edges,V);
  }
}
