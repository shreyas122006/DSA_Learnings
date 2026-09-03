import java.util.Arrays;
import java.util.HashSet;

public class LISDP {
  public static int lcs(int arr1[], int arr2[]) {
    int dp[][] = new int[arr1.length+1][arr2.length+1];
    for(int i=0; i<dp.length; i++) {
      dp[i][0] = 0;
    }
    for(int j=0; j<dp[0].length; j++) {
      dp[0][j] = 0;
    }
    for(int i=1; i<arr1.length+1; i++) {
      for(int j=1; j<arr2.length+1; j++) {
        if(arr1[i-1] == arr2[j-1]) {
          dp[i][j] = dp[i-1][j-1]+1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    print(dp);
    return dp[arr1.length][arr2.length];
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
  public static int lis(int arr1[]) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<arr1.length; i++) {
      set.add(arr1[i]);
    }
    int arr2[] = new int[set.size()]; //sorted unique els
    int i=0; 
    for(int num : set) {
      arr2[i] = num;
      i++;
    }
    Arrays.sort(arr2); //ascending
    return lcs(arr1,arr2);
  }
  public static void main(String[] args) {
    //sorted and ascending
    //1.Hashset
    //2. arr2[](m)  arr1[](n)
    // LIS = LCS
    int arr1[] = {50,3,10,7,40,80};
    System.out.println(lis(arr1));
  }
}
