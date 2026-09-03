import java.util.Arrays; // .Collections for reverse Order works on Object Integer instead of int
//Time Complexity : O(nlogn)
public class inbuiltsort {
  public static void inBuiltSort(int Arr[]) {
    Arrays.sort(Arr, 0, 3); // Arrays.sort(Arr,0,2,Collections.reverseOrder())
  }
  public static void main(String[] args) {
    int Arr[] = {5,4,3,2,1};
    inBuiltSort(Arr);
    for(int i=0; i<Arr.length ; i++) {
      System.out.print(Arr[i] + " ");
    }
  }
}
