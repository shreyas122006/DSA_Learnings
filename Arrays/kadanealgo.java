public class kadanealgo {
  public static void kadanes (int arr[]) {
    int maxsum = Integer.MIN_VALUE;
    int currsum = 0;
    for(int i=0; i<arr.length; i++) {
      currsum += arr[i];
      if(currsum < 0 ) {
      currsum = 0;
      }
      maxsum = Math.max(currsum,maxsum);
    }
    System.out.println("Maximum Sum : "+ maxsum);
  }
  public static void main(String[] args) {
    int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    kadanes(arr);
  }
}
