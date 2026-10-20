import java.util.*;
public class binarysearch {
  public static void main(String[] args) {
    int start, mid, end, key;

    System.out.println("Enter Value to Search: ");
    Scanner sc = new Scanner(System.in);
    key = sc.nextInt();
    int[] arr = new int[10];
    System.out.println("Enter Array Elements: ");
    for(int i =0; i<arr.length; i++) {
      arr[i] = sc.nextInt();
    }
      start = 0;
      end = arr.length;
    while(start<end) {
      mid = start + (end-start)/2;
      if(key == arr[mid]) {
        System.out.println("Element found at index " + mid);
        break;
      }
      else if (key>mid) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
  }
}
