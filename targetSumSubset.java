public class targetSumSubset {
  public static boolean targetSumSubset(int arr[], int sum) {
    int n = arr.length;
    boolean dp[][] = new boolean[n+1][sum+1];
    //i=itmes & j = target sum
    for(int i=0; i<n+1; i++) {
      dp[i][0] = true;
    }
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<sum+1; j++) {
        int v = arr[i-1];
        //include
        if(v<=j && dp[i-1][j-v]==true) {
          dp[i][j] = true;
        }
        //exclude
        else if(dp[i-1][j] == true) {
          dp[i][j] = true;
        }
      }
    }
    print(dp);
    return dp[n][sum];
  }
  public static void print(boolean dp[][]) {
    for(int i=0; i<dp.length; i++) {
      for(int j=0; j<dp[0].length;j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void main(String[] args) { //O(n*sum)
    //Variation of 0-1 knapsack
    //1.choice of elements
    //2.limit on max allowed capacity
    //3.val=wt
    //tabulation approach
    //1.table
    //2.meaning + initialization
    //3.bottom up manner(small to large)
    // dp[i,j] i items => subset sum = j ?  T/F
    /*  for(int i=1 to n-1)
          for(int j=1 to sum+1)
            //include (V=arr[i-1])
          if(v<=j && dp[i-1][j-v] = T) 
              dp[i][j] = T
            //exclude
          if(dp[i-1][j] = T)
              dp[i][j] = T
    */
   int arr[] = {4,2,7,1,3};
   int sum = 10;
   System.out.println(targetSumSubset(arr, sum));
  }
}
