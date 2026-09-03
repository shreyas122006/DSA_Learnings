public class countBSTs {
  public static int countTrees(int n) { //O(n^2)
    int dp[] = new int[n+1];
     dp[0] = 1;
     dp[1] = 1;
     for(int i=2; i<=n; i++) {
      //Ci ->BST (i nodes) dp[i]
      for(int j=0; j<i; j++) {
        int left = dp[j];
        int right = dp[i-j-1];
        dp[i] += left*right; //Ci = Cj*C(i-j-1)
      }
     }
     return dp[n];
  }
  public static void main(String[] args) {
    //Find number of all possible BSTs with given n nodes
    System.out.println(countTrees(5));
  }
}
