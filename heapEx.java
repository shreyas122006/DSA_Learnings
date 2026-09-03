import java.util.*;
public class heapEx {
  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();
    public void add(int data) {
      // add at last idx
      arr.add(data);
      int x = arr.size()-1; // x is child index
      int par = (arr.size()-2)/2; // par index
      while(arr.get(x) < arr.get(par)) { // O(logn)
        //swap
        int temp = arr.get(x);
        arr.set(x,arr.get(par));
        arr.set(par,temp);
        x = par;
        par = (x-1)/2;
      }
    }
    public int peek() {
      return arr.get(0);
    }
    private void heapify(int i) { // O(logn)
      int left = 2*i+1;
      int right = 2*i+2;
      int minIdx = i;
      if(left<arr.size() && arr.get(minIdx) > arr.get(left)) {
        minIdx = left;
      }
      if(right<arr.size() && arr.get(minIdx) > arr.get(right)) {
        minIdx = right;
      }
      if(minIdx != i) {
        //swap
        int temp = arr.get(i);
        arr.set(i,arr.get(minIdx));
        arr.set(minIdx,temp);
        heapify(minIdx);
      }
    }
    public int remove() {
      //step 1 - swap first & last
      int data = arr.get(0);
      int temp = arr.get(0);
      arr.set(0,arr.get(arr.size()-1));
      arr.set(arr.size()-1,temp);
      //step 2 - delete last
      arr.remove(arr.size()-1);
      //step 3 - heapify
      heapify(0);
      return data;
    }
    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }
  public static void main(String[] args) {
    // Max heap -> max priority
    // Min heap -> min priority
    // Visualize -> Heap(BT)
    // Implement -> Array / AL
    // Binary tree at most 2 children
    // Complete Binary tree all levels are filled except possibly the last one which is filled from left to right
    // Heap order property
    // Children >= parent(minHeap)
    // Children <= Parent(maxHeap)
    // Heap is not implemented as a class
    // Heap as an Array/ArrayList (node) idx = i; leftchild = 2i+1; rightchild = 2i+2; parent = (x-1)/2 if child = x;
    // OR (node) idx(0) = -1  (node) idx = 1; leftchild = 2i; rightchild = 2i+1;
    // Insert in heap
    // 1.add at last index
    // 2.fix heap: par = (x-1)/2
    // while(child val < par val) 
    // swap(child,par)
    // get Min in heap -> minHeap arr.get(0)
    // delete in heap
    // 1. 1st and last Node swap
    // 2. remove last idx arr.remove(arr.size()-1)
    // 3. heapify O(logn)  root = i; left = 2i+1; right = 2i+2; min = (i,2i+1,2i+2); swap with root;

    Heap pq = new Heap();
    pq.add(3);
    pq.add(4);
    pq.add(1);
    pq.add(5);
    while(!pq.isEmpty()) { // heap sort - O(nlogn)
      System.out.println(pq.peek());
      pq.remove();
    }
  }
}
