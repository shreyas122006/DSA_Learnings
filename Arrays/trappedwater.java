public class trappedwater {
  //O(n)
  public static int trapwater( int height[]) {
    int n = height.length;
    // Auxillary arrays
    int leftmax[] = new int[n];
    leftmax[0] = height[0];
    for(int i=1; i<leftmax.length; i++) {
      leftmax[i] = Math.max(height[i], leftmax[i-1]);
    }
    int rightmax[] = new int[n];
    rightmax[n-1] = height[n-1];
    for(int i=n-2; i>=0; i--) {
      rightmax[i] = Math.max(height[i], rightmax[i+1]);
    }
    int trappwater = 0;
    for(int i=0; i<n; i++) {
      int waterlevel = Math.min(leftmax[i], rightmax[i]);
      trappwater += waterlevel - height[i];
    }
    return trappwater;
  }
  public static void main(String[] args) {
    int height[] = {4,2,0,6,3,2,5};
    System.out.println( "Total Trapped Water : "+ trapwater(height));
  }
}
