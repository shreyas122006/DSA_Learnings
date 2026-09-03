import java.util.Arrays;

public class mcmDp {
  public static int mcm(int arr[], int i, int j) {
    if(i==j) {
      return 0; //single matrix
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<=j-1; k++) {
      int cost1 = mcm(arr,i,k); //Ai...Ak => arr[i-1]xarr[k]
      int cost2 = mcm(arr,k+1,j); //Ak+1...Aj => arr[k]xarr[j]
      int cost3 = arr[i-1]*arr[k]*arr[j];
      int finalCost = cost1+cost2+cost3;
      ans = Math.min(ans,finalCost);
    }
    return ans;
  }
  public static int mcmMem(int arr[], int dp[][], int i, int j) {
    if(i==j) {
      return 0; //single matrix
    }
    if(dp[i][j]!=-1) {
      return dp[i][j];
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<=j-1; k++) {
      int cost1 = mcmMem(arr,dp,i,k); //Ai...Ak => arr[i-1]xarr[k]
      int cost2 = mcmMem(arr,dp,k+1,j); //Ak+1...Aj => arr[k]xarr[j]
      int cost3 = arr[i-1]*arr[k]*arr[j];
      ans = Math.min(ans,cost1+cost2+cost3);
    }
    return dp[i][j]=ans;
  }
  public static int mcmTab(int arr[]) {
    int n = arr.length;
    int dp[][] = new int[n][n];
    //initialization
    for(int i=0; i<n; i++) {
        dp[i][i] = 0;
      }
    //bottom up
      for(int len=2; len<=n-1; len++) {
        for(int i=1; i<=n-len; i++) {
          int j = i+len-1; //col
          dp[i][j] = Integer.MAX_VALUE;
          for(int k=i; k<=j-1; k++) {
            int cost1 = dp[i][k];
            int cost2 = dp[k+1][j];
            int cost3 = arr[i-1]*arr[k]*arr[j];
            dp[i][j] = Math.min(dp[i][j],cost1+cost2+cost3);
          }
        }
      }
      print(dp);
      return dp[1][n-1];
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
    //A.B 
    // A->axb
    // B->cxd
    //1. b==c
    //2. final result => matrix[axd]
    //3. operation => axbxd
    // arr[] = 1,2,3,4,3 (n) this has n-1 matrices info
    // Find min cost
    // i = starting point
    // j = ending point
    // K = start -> end
    //int mcm(arr[], int i, int j) {
    //  if(i==j) return 0 -> single matrix
    //  int ans = Integer.MAX_VALUE
    //  for(int k=i to j-1) {      Ai => arr[i-1]xa[i] axb  Ak => arr[k-1]xa[k]  
    //  cost1 = mcm(arr,i,k)  Resultant cost => arr[i-1]xarr[k] axd row x col    
    //  cost2 = mcm(arr,k+1,j) Resultant cost => arr[k]xarr[j]
    //  cost3 = arr[i-1]xarr[k]xarr[j]
    //  finalcost = cost1+cost2+cost3
    //  ans = min(ans,finalcost)
    //  }
    //}
    int arr[] = {1,2,3,4,3}; //n=5
    int n = arr.length;
    int dp[][] = new int[n][n];
    for(int i=0; i<n; i++) {
      Arrays.fill(dp[i],-1);
    }
    System.out.println(mcm(arr, 1, n-1));
    System.out.println(mcmMem(arr, dp, 1, n-1));
    System.out.println(mcmTab(arr));
  }
}
