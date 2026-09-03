public class mountainRanges {
  public static int mountainranges(int n) { //O(n^2)
    int dp[] = new int[n+1];
     dp[0] = 1;
     dp[1] = 1;
     for(int i=2; i<=n; i++) {
      //i pairs -> mountain ranges => Ci
      for(int j=0; j<i; j++) {
        int inside = dp[j];
        int outside = dp[i-j-1];
        dp[i] += inside*outside; //Ci = Cj*C(i-j-1)
      }
     }
     // n pairs
     return dp[n];
  }
  public static void main(String[] args) {
    //mountains & valleys at any moment the number of down strokes cannot be more than number of up strokes.
    // / -> up stroke
    // \ -> down stroke
    //n pairs -> nth catalan
    int n = 4; //14
    System.out.println(mountainranges(n));
  }
}
