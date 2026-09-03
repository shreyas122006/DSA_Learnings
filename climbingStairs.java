import java.util.Arrays;

public class climbingStairs {
  public static int countWays(int n) { //O(n) | recursion (2^n) -> n = 10^5
    if(n==0) {
      return 1;
    }
    if(n<0) {
      return 0;
    }
    return countWays(n-1)+countWays(n-2);
  }
  //memoization //O(n)
  public static int countWaysMemo(int n, int ways[]) {
    if(n==0||n==1) {
      return 1;
    }
    if(ways[n] != -1) { //already calculated
      return ways[n];
    }
    ways[n] = countWaysMemo(n-1,ways)+countWaysMemo(n-2,ways);
    return ways[n];
  } //O(n)
  public static int countWaysTab(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    //tabulation loop
    for(int i=1; i<=n; i++) {
      if(i==1) {
        dp[i] = dp[i-1]+0;
      } else {
      dp[i] = dp[i-1]+dp[i-2];
      }
    }
    return dp[n];
  }
  public static void main(String[] args) {
    //Count ways to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time.
    //ways(n) = ways(n-1) + ways(n-2)
    // if can take step of 1,2,3 then ways(n) = ways(n-1)+ways(n-2)+ways(n-3)
    int n = 5; // n=3 -> 3 & n=4 -> 5=>8
    int ways[] = new int[n+1];
    Arrays.fill(ways, -1);
    System.out.println(countWays(n));
    System.out.println(countWaysMemo(n,ways));
    System.out.println(countWaysTab(n));
  }
}
