public class heapsort {
  private static void heapify(int arr[], int i,int size) { // O(logn)
      int left = 2*i+1;
      int right = 2*i+2;
      int maxIdx = i;
      if(left<size && arr[maxIdx] < arr[left]) {
        maxIdx = left;
      }
      if(right<size && arr[maxIdx] < arr[right]) {
        maxIdx = right;
      }
      if(maxIdx != i) {
        //swap
        int temp = arr[i];
        arr[i]=arr[maxIdx];
        arr[maxIdx]=temp;
        heapify(arr,maxIdx,size);
      }
    }
  public static void heapSort(int arr[]) { // O(nlogn)
    //step 1 - build maxHeap
    int n= arr.length;
    for(int i=n/2; i>=0; i--) {
      heapify(arr,i,n);
    }
    //step 2 - push largest at end
    for(int i=n-1; i>0;i--) {
      //swap
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr,0,i);
    }
  }
  public static void main(String[] args) {
    //arr -> maxHeap -> ascending order; minHeap -> descending order;
    // 1.non-leaf nodes/ last level -> heapify();
    //   for(int i=n/2; i>=0; i--)
    // 2.largest el push at end
    //   ->swap(first,last)
    //   ->heapify(0)
    int arr[] = {1,2,4,5,3};
    heapSort(arr);
    for(int i=0; i<arr.length;i++) {
      System.out.println(arr[i]);
    }
}
}