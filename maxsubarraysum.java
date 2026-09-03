public class maxsubarraysum {
   //Time Complexity : O(n^3)
  public static void maxsubsum(int arr[]) {
    int currsum=0;
    int maxsum = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++) {
      int start = i;
      for(int j=i; j<arr.length; j++) {
        int end = j;
        currsum=0;
        for(int k = start; k<=end; k++) {
          currsum += arr[k];
        }
        System.out.println(currsum);
        if(maxsum < currsum) {
          maxsum=currsum;
        }
      }
    }
    System.out.println("Maximum sum: " + maxsum);
  }
  public static void main(String[] args) {
    int[] arr = {1,-2,6,-1,3};
    maxsubsum(arr);
  }
}
