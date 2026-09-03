import java.util.ArrayList;

public class graphEx {
  static class Edge {
    int src;
    int dest;
    int wt;
    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }
  public static void main(String[] args) {
    //Graph is network of Nodes which has vertex and edges
    //Edges can be Uni-Directional(Directed Graph) or Un-Directed(Undirected Graph) or Bi-Directional
    // type -> Weighted or UnWeighted
    // Weight -> Value associated with edge
    //Storing a graph(Structure | Represent) -> Adjacency List, Adjacency Matrix, Edge List, 2D Matrix(Implicit Graph)
    //Adjacency list -> list of Lists
    //1.find your neighbour O(K)
    //Adjacency matrix O(V^2) > Adj list //VxV matrix
    // TC -> O(V) disadvantage
    //Edge list (Edges Information) -> list of list
    //Edge sorting -> MST(min spanning tree)
    //Implicit Graph -> up(i+1,j),down(i-1,j),right(i,j+1),left(i,j-1)
    //Applications of Graphs
    //1.MAPS (Shortest path)
    //2.Social Network
    //3.Delivery Network (Shortest Cyclic Route)
    //4.Physics & Chemistry
    //5.Routing Algorithms
    //6.Machine Learning (Computation Graphs)
    //7.Dependency Graph
    //8.Computer Vision
    //9.Graph Databases
    //10.Research
    int V = 5;
    ArrayList<Edge>[] graph = new ArrayList[V]; //null ->empty arrayList
    for(int i=0; i<V; i++) {
      graph[i] = new ArrayList<>();
    }
    //0->vertex
    graph[0].add(new Edge(1, 5, 5));
    //1->vertex
    graph[1].add(new Edge(1, 0, 5));
    graph[1].add(new Edge(1, 2, 1));
    graph[1].add(new Edge(1, 3, 3));
    //2->vertex
    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 3, 1));
    graph[2].add(new Edge(2, 4, 2));
    //3->vertex
    graph[3].add(new Edge(3, 1, 3));
    graph[3].add(new Edge(3, 2, 1));
    //4->vertex
    graph[4].add(new Edge(4, 2, 2));
    //2's neighbors
    for(int i=0; i<graph[2].size(); i++) {
      Edge e = graph[2].get(i); //src,dest,wt
      System.out.println(e.dest);
    }
  }
}
