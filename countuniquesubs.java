public class countuniquesubs {
  static class Node {
    Node children[] = new Node[26];
    boolean eow = false;
    public Node() {
      for(int i=0; i<26; i++) {
        children[i] = null;
      }
    }
  }
  public static Node root = new Node();
  public static void insert(String word) { //O(L)
    Node curr = root;
    for(int level=0; level<word.length(); level++) {
      int idx = word.charAt(level) -'a'; 
      if(curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }
      curr = curr.children[idx];
    }
    curr.eow = true;
  }
  public static boolean search(String key) { //O(L)
    int level = 0;
    int len = key.length();
    int idx = 0;
    Node curr = root;
    for(; level<len; level++) {
      idx = key.charAt(level) -'a'; 
      if(curr.children[idx] == null) {
        return false;
      } 
      curr = curr.children[idx];
    }
    return curr.eow == true;
  }
  public static int countNodes(Node root) {
    if(root == null) {
      return 0;
    }
    int count = 0;
    for(int i=0; i<26; i++) {
      if(root.children[i]!=null) {
        count += countNodes(root.children[i]);
      }
    }
    return count+1;
  }
  public static void main(String[] args) {
    // First Cut Suffix
    // Last Cut Prefix
    // substring -> all prefix of all suffix || all suffix of all prefix
    // unique substring -> all unique prefix of all suffix || all unique suffix of all prefix
    // trie stores unique prefixes
    // unique prefix = count of nodes of trie
    //1.find all suffix of string
    //2.Create TRIE + insert
    //3.count nodes of trie == unique prefix == unique subtrings
    String str = "ababa"; //ans=10
    //suffix -> insert in trie;
    for(int i=0; i<str.length(); i++) {
      String suffix = str.substring(i);
      insert(suffix);
    }
    System.out.println(countNodes(root));
    
  }
}
