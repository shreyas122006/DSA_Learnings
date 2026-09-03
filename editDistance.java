public class editDistance {
  public static int editDist(String str1, String str2) { //O(n*m)
    int n = str1.length();
    int m = str2.length();
    int dp[][] = new int[n+1][m+1];
    for(int i=0; i<dp.length; i++) {
      for(int j=0; j<dp[0].length; j++) {
        if(i==0) {
          dp[i][j] = j; // first string is empty
        } else if(j==0) {
          dp[i][j] = i; // second string is empty
        }
      }
    }
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<m+1; j++) {
        if(str1.charAt(i-1) == str2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];  
        } else {
          dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
        }
      }
    }
    print(dp);
    return dp[n][m];
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
    //Given two strings word1 and word2, return the minimum number of operations required to convert wrod1 to word2.
    // You have the following three operations permitted on a word:
    // if same -> n-1, m-1
    // . Insert a character -> str1(n)str2(m-1) + 1
    // . Delete a character -> str1(n-1)str2(m) + 1
    // . Replace a character -> str1(n-1)str2(m-1) + 1
    String word1 = "intention";
    String word2 = "execution";
    System.out.println(editDist(word1, word2));
  }
}
