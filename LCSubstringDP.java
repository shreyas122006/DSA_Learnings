public class LCSubstringDP {
  public static int lcsTab(String S1, String S2, int n, int m) {
    int dp[][] = new int[n+1][m+1];
    for(int i=0; i<dp.length; i++) {
      dp[i][0] = 0;
    }
    for(int j=0; j<dp[0].length; j++) {
      dp[0][j] = 0;
    }
    int ans = 0;
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<m+1; j++) {
        if(S1.charAt(i-1) == S2.charAt(j-1)) {
          dp[i][j] = 1+dp[i-1][j-1];
          ans = Math.max(ans, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    print(dp);
    return ans;
  }
    public static void print(int dp[][]) {
      for(int i=0; i<dp.length; i++) {
        for(int j=0; j<dp[0].length;j++) {
          System.out.print(dp[i][j] + "  ");
        }
        System.out.println();
      }
      System.out.println();
  }  
  public static void main(String[] args) {
    //a substring is a continous sequence of characters withing a string
    //characters same -> len + 1
    //characters diff -> 0
    String S1 = "ABCDE"; 
    String S2 = "ABCDE";
    System.out.println(lcsTab(S1, S2, S1.length(), S2.length()));
  }
}
