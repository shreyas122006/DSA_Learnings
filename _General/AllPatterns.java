public class AllPatterns {
  public static void main(String[] args) {
    /* SLIDING WINDOW
    
        //constant Window //O(n)
        while(r<n-1) {
        sum = sum-arr[l]
        l++;
        r++;
        sum = sum + arr[r];
        maxSum = max(maxSum,sum);
        }


        longest subarray with sum <= k //O(n)
        arr = [2,5,1,10,10]  k = 14
        l=0  r=0  sum=0  maxlen=0
        while(r < n) {
          sum = sum + arr[r];
          if(sum > k) {
            sum = sum - arr[l]
            l = l + 1;
          }
          if(sum<=k) {
          maxlen = max(maxlen,r-l+1)
          }
          r = r + 1;
        }


        //No of subarrays where<condition> 
        //No of subarrays with sum = k
        no. of subarrays where sum <= k  -> x
        no. of subarrays where sum <= (k-1) -> y
        ans -> x-y


        //Shortest/Minimum Wondow <condition>

    
    */
  }
}
