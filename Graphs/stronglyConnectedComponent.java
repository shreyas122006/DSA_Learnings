import java.util.ArrayList;
import java.util.Stack;

public class stronglyConnectedComponent {
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
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 4));
  }
  public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
    vis[curr] = true;
    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]) {
        topSort(graph, e.dest, vis, s);
      }
    }
    s.push(curr);
  }
  public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    vis[curr] = true;
    System.out.print(curr+" ");
    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if(!vis[e.dest]) {
        dfs(graph, e.dest, vis);
      }
    }
  }
  public static void kosaraju(ArrayList<Edge> graph[], int V) {
    //step 1 
    Stack<Integer> s = new Stack<>();
    boolean vis[] = new boolean[graph.length];
    for(int i=0; i<V; i++) {
      if(!vis[i]) {
        topSort(graph, i, vis, s);
      }
    }
    //step 2 
    ArrayList<Edge> transpose[] = new ArrayList[V];
    for(int i=0; i<graph.length; i++) {
      vis[i] = false;
      transpose[i] = new ArrayList<Edge>();
    }
    for(int i=0; i<V; i++) {
      for(int j=0; j<graph[i].size(); j++) {
        Edge e = graph[i].get(j); //e.src -> e.dest
        transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
      }
    }
    //step 3
    while(!s.isEmpty()) {
      int curr = s.pop();
      if(!vis[curr]) {
        System.out.print("SCC -> ");
        dfs(transpose,curr,vis);
        System.out.println();
      }
    }
  }
  public static void main(String[] args) { //O(V+E)
    //SCC is a component in which we can reach every vertex of the component from every other vertex in that component
    //Kosaraju's Algorithm -> DFS based -> reverse
    //1.Get nodes in stack (topological sort) O(V+E)
    //2.Transpose the graph O(V+E)
    //3.Do DFS according to stack nodes on the transpose graph O(V+E)
    int V = 5;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    kosaraju(graph, V);
  }
}
