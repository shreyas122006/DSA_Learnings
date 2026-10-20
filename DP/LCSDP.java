public class LCSDP {
  public static int lcs(String str1, String str2, int n, int m) {
    if(n==0||m==0) {
      return 0;
    }
    if(str1.charAt(n-1)==str2.charAt(m-1)) {
      return lcs(str1,str2,n-1,m-1)+1;
    } else {
      int ans1 = lcs(str1, str2, n-1, m);
      int ans2 = lcs(str1, str2, n, m-1);
      return Math.max(ans1,ans2);
    }
  }
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) { //O(n*m)
    if(n==0||m==0) {
      return 0;
    }
    if(dp[n][m]!=-1) {
      return dp[n][m];
    }
    if(str1.charAt(n-1)==str2.charAt(m-1)) {
      return dp[n][m] = lcs(str1,str2,n-1,m-1)+1;
    } else {
      int ans1 = lcs(str1, str2, n-1, m);
      int ans2 = lcs(str1, str2, n, m-1);
      return dp[n][m] = Math.max(ans1,ans2);
    }
  }
    public static int lcsTab(String str1, String str2, int n, int m) { //O(n*m)
      int dp[][] = new int[str1.length()+1][str2.length()+1];
      for(int i=0; i<dp.length; i++) {
        dp[i][0] = 0;
      }
      for(int j=0; j<dp[0].length; j++) {
        dp[0][j] = 0;
      }
      for(int i=1; i<str1.length()+1; i++) {
        for(int j=1; j<str2.length()+1; j++) {
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
            dp[i][j] = 1 + dp[i-1][j-1];
            } else {
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
      }
      print(dp);
    return dp[str1.length()][str2.length()];
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
    //A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters
    /*/ lcs(str1,str2,n,m) {
        if(n==0 || m==0) 
        return 0
        str1(n-1) == str2(m-1) //same
        return lcs(str1,str2,n-1,m-1)+1
        else // diff
        ans1 = lcs(str1,str2,n-1,m)
        ans2 = lcs(str1,str2,n,m-1)
        return Math.max(ans1,ans2)
        } 
     */
    String str1 = "abcdge";
    String str2 = "abedg"; //lcs = "abdg"; length = 4
    int dp[][] = new int[str1.length()+1][str2.length()+1];
    for(int i=0; i<str1.length()+1; i++) {
      for(int j=0; j<str2.length()+1; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    System.out.println(lcsMemo(str1, str2, str1.length(), str2.length(), dp));
    System.out.println(lcsTab(str1, str2, str1.length(), str2.length()));
  }
}
