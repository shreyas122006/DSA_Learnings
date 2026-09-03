public class segmentTreeEx {
  static int tree[];
  public static void init(int n) {
    tree = new int[4*n];
  }
  public static int buildST(int arr[], int i, int start, int end) {
    if(start == end) {
      tree[i] = arr[start];
      return arr[start];
    }
    int mid = (start+end)/2;
    buildST(arr, 2*i+1, start, mid); //left subtree - 2*i+1
    buildST(arr, 2*i+2, mid+1, end); //right subtree - 2*i+2
    tree[i] = tree[2*i+1] + tree[2*i+2];
    return tree[i];
  }
  public static void buildTree(int arr[], int i, int si, int sj) { //O(n)
    if(si==sj) {
      tree[i] = arr[si];
      return;
    }
    int mid = (si+sj)/2;
    buildTree(arr, 2*i+1, si, mid);
    buildTree(arr, 2*i+2, mid+1, sj);
    tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
  }
  public static int getMax(int arr[], int qi, int qj) { //Max/Min type query 
    int n = arr.length;
    return getMaxUtil(0, 0, n-1, qi, qj);
  }
  public static int getMaxUtil(int i, int si, int sj, int qi, int qj) { //Max/Min type query //O(logn)
    if(si>qj || sj<qi) { //no overlap
      return Integer.MIN_VALUE;
    } else if(si>=qi && sj<=qj) { //complete overlap
      return tree[i];
    } else { // partial overlap
      int mid = (si+sj)/2;
      int leftAns = getMaxUtil(2*i+1, si, mid, qi, qj);
      int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
      tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
      return Math.max(leftAns,rightAns);
    }
  }
  public static int getSumUtil(int i, int si, int sj, int qi, int qj) { //O(logn)
    if(qj <= si || qi>=sj) { //non overlapping
      return 0;
    } else if(si>=qi && sj<=qj) { //complete overlap
      return tree[i];
    } else { //partial overlap
      int mid = (si+sj)/2;
      int left = getSumUtil(2*i+1, si, mid, qi, qj);
      int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
      return left+right;
    }
  }
  public static int getSum(int arr[], int qi, int qj) { //Sum type query
    int n = arr.length;
    return getSumUtil(0, 0, n-1, qi, qj);
  }
  public static void updateUtil(int i, int si, int sj, int idx, int diff) { //O(logn) // Sum type query
    if(idx > sj || idx < si){
      return;
    }
    tree[i] += diff;
    if(si != sj) { //non-leaf
      int mid = (si+sj)/2;
      updateUtil(2*i+1, si, mid, idx, diff); //left
      updateUtil(2*i+2, mid+1, sj, idx, diff); //right
    }
  }
  public static void update(int arr[], int idx, int newVal) { //O(logn) for single upd and O(nlogn) for multiple
    int n = arr.length;
    int diff = newVal-arr[idx];
    arr[idx] = newVal;
    updateUtil(0, 0, n-1, idx, diff); //segment tree updation
  }
  public static void update1(int arr[], int idx, int newVal) {
    arr[idx] = newVal;
    int n = arr.length;
    update1Util(0, 0, n-1, idx, newVal);
  }
  public static void update1Util(int i, int si, int sj, int idx, int newVal) {
    if(idx < si || idx > sj) {
      return;
    }// if(si==sj) { tree[i] = newVal }; for min query
    tree[i] = Math.max(tree[i],newVal); // for max query
    if(si!=sj) { //only for non leafs
      // tree[i] = Math.min(tree[i],newVal); for min query
      int mid = (si+sj)/2;
      update1Util(2*i+1, si, mid, idx, newVal); //left
      update1Util(2*i+2, mid+1, sj, idx, newVal); //right
    }
  }
  public static void main(String[] args) {
    //brute force -> query O(n) Update O(1)
    //prefix sum -> query O(1) Update O(n)
    //segment tree -> query O(logn) Update O(logn)
    //levels -> log2(n)
    //total nodes for size n -> 2n-1 for safety take 4*n as its full BT
    //subarray sum of different ranges
    //segment tree contruction requires O(n) while query and upd O(logn)
    //1.max element queries
    //Given an arr[], we have to answer few queries :
    // a.Output Max/Min for the subarray[i..j]
    // b.Update the element at idx
    // for min element queries just reverse condition for max also for building TREE

    int arr[] = {1,2,3,4,5,6,7,8};
    int n = arr.length;
    init(n);
    buildST(arr, 0, 0, n-1);
    for(int i=0; i<tree.length; i++) {
      System.out.print(tree[i]+" ");
    }
    System.out.println(getSum(arr,2,5)); //36
    update(arr, 2, 2);
    System.out.println(getSum(arr, 2, 5)); //35
    int arr1[] = {6,8,-1,2,17,1,3,2,4};
    int n1 = arr1.length;

    init(n1);
    buildTree(arr1, 0, 0, n-1);
    for(int i=0; i<tree.length; i++) {
      System.out.print(tree[i]+" ");
    }
    int max = getMax(arr,2,5);
    System.out.println(max);

    update1(arr1, 2, 20);
    int max1 = getMax(arr1,2,5);
    System.out.println(max1);
  }
}
