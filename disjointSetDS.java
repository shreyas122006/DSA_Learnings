public class disjointSetDS {
  static int n =7;
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
  //path compression
  public static void main(String[] args) {
    //union find ds or merge ds
    //store and track non overlapping sets
    // find union
    // find -> which set el belongs to
    // used to cycle detection
    // kruskal's algorithm (MST)
    // implementation -> parent(leader) + union by rank(height)
    // find -> leader
    // union -> 2 groups join
    // find(x)
    // if(x=par[x]) return x
    // return find(par[x])
    // union(a,b) parA(find(a)), parB(find(b))
    // rank - parA,parB equal -> par[parA] = parB
    //                           rank[parB]++
    // parA(rank) < parB(rank)
    // parA(rank) > parB(rank)
    init();
    union(1, 3);
    System.out.println(find(3));
    union(2, 4);
    union(3, 6);
    union(1, 4);
    System.out.println(find(3));
    System.out.println(find(4));
    union(1, 5);
  }
}
