public class dpEx { //O(n)
  public static int fibTabulation(int n) {
    int dp[] = new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }
  public static int fib(int n,int dp[]) {
  if(n==0 || n==1) {
      return n;
    } 
    if(dp[n]!=0) {
      return dp[n];
    }
    dp[n] = fib(n-1,dp) + fib(n-2,dp);
    return dp[n];
    //called n+1 times without this O(2^n)
    //recursion tree is skewed
    // else we were getting complete binary tree
    // memoization
  }
  public static void main(String[] args) {
    int n = 5;
    int dp[] = new int[n+1];
    System.out.println(fib(n,dp));
    System.out.println(fibTabulation(n));
    //Dp is optimized recursion TC decrease 
    //Hpw to identify DP?
    //a.Optimal Problem
    //b.some choice is given (multiple branches in recursion tree)
    // greedy(least,most,min,max,largest,smallest)  -> optimal
    //Dynamic Programming is a technique in computer programming that helps to efficiently solve a class of problems that have overlapping subproblems and optimal substructure property. 
    //ways of DP 
    //Memoization (Top Down) and Tabulation (Bottom Up)
    // fibonacci 1.Recursion 2.subproblems -> storage -> reuse
    // recursion Iteration -> Tabulation (efficient than memoization)
    // tabulation -> table/set/storage
    // dp[n+1] for(int i=2;i<=n;i++) {dp[i] = dp[i-1] + dp[i-2]} ans = dp[n]
    // 7 Imp Qs
    // Fibonacci, 0-1 Knapsack, Unbound Knapsack, LCS(longest Common Subsequence), Kadane's Algorithm (Arrays), Catalan Number, DP on Grid (2D Arrays)
    // These are 7 Concepts with which can solve atleast 70Qs
    /*
  1) Fibonacci
    Climbing Stairs
    Number Factors
    Min Jumps to reach the end
    Min Jumps with cost
    House thief
  2) Unbounded Knapsack
    Rod Cutting
    Coin Change
    Min Coin Change
    Max Ribbon Cut
  3) 0-1 Knapsack
    Subset Sum
    Equal Subset Sum partition
    Min Subset Sum Difference 
    Count of Subset Sum 
    Target Sum
  4) LCS (Longest Common Subsequence)
    Longest Common Substring
    Edit Distance
    Box Stacking
    Longest Increasing Subsequence 
    Longest Bitonic Subsequence 
    Subsequence Pattern Matching
    Min Add/ Delete to convert one string to another
  5) Catalan Number
    No. of BSTS
    N Parentheses 
    Convex Polygons
    Disjoint Chords
    Catalan Triangle
    Mountain Ranges
    Dyck Words
  */
  }
}