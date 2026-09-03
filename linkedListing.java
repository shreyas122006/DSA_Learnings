import java.util.*;
public class linkedListing {
  public static class Node {
    int data;
    Node next;
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  public static Node head;
  public static Node tail;
  public static int size;
    
    public void addFirst(int data) { // O(1)
      Node newNode = new Node(data);
      size++;
      if(head == null) {
        head = tail = newNode;
        return;
      }
      newNode.next = head;
      head = newNode;
    }
    public void addLast(int data) { // O(1)
      Node newNode = new Node(data);
      size++;
      if(head == null) {
        head = tail = newNode;
        return;
      }
      tail.next = newNode;
      tail = newNode;
    }
    public void addMiddle(int data, int index) { // O(n)
      if(index == 0) {
        addFirst(data);
        return;
      }
      Node newNode = new Node(data);
      size++;
      if(head == null) {
        head = tail = newNode;
        return;
      }
      Node temp = head;
      int i=0;
      while(i<index-1) {
        temp = temp.next;
        i++;
      }
      newNode.next = temp.next;
      temp.next = newNode;
    }
    public int removeFirst() {
      if(size == 0) {
        System.out.println("Linked List is empty");
        return Integer.MIN_VALUE;
      }
      else if (size == 1) {
        int val = head.data;
        head = tail = null;
        size=0;
        return val;
      }
      int val = head.data;
      head = head.next;
      size--;
      return val;
    }
    public int removeLast() {
      if(size == 0) {
        System.out.println("Linked List is empty");
        return Integer.MIN_VALUE;
      }
      else if (size == 1) {
        int val = head.data;
        head = tail = null;
        size = 0;
        return val;
      }
      Node temp = head;
      int val = tail.data;
      for(int i=0; i<size-2; i++) {
        temp = temp.next;
      }
      temp.next = null;
      tail = temp;
      return val;
    }
    public int Itrsearch(int key) {
      int i=0;
      Node temp = head;
      while(temp!=null) {
        if(temp.data == key) {
          return i;
        }
        temp = temp.next;
        i++;
      }
      return -1;
    }
    public int helper(Node head, int key) {
      if(head == null) {
        return -1;
      }
      if(head.data == key) {
        return 0;
      }
      int index = helper(head.next,key);
      if(index == -1) {
        return -1;
      }
      return index + 1;
    }
    public int Recursearch(int key) { // O(n)
      return helper(head,key);
    }
    public static void display() { // O(n)
      if(head == null) {
        System.out.println("Linked List is empty");
        return;
      }
      Node temp = head;
      while(temp!= null) {
        System.out.print(temp.data + "->");
        temp = temp.next;
      }
      System.out.println("null");
    }
    public void reverse() {
      Node prev = null;
      Node curr = tail = head;
      Node next;
      while(curr!=null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      head = prev;
    }
    public void deleteNthfromEnd(int n) {
      int size = 0;
      Node temp = head;
      while(temp!=null) {
        temp = temp.next;
        size++;
      }
      if(n==size) {
        head = head.next;
        return;
      }
      int i = 1;
      int iToFind = size-n;
      Node prev = head;
      while(i<iToFind) {
        prev = prev.next;
        i++;
      }
      prev.next = prev.next.next;
      return;
    }
    public Node findMidNode(Node head) { // slow and fast pointer
      Node slow = head;
      Node fast = head;
      while(fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
    public boolean checkPalindrome() { // mid divide into halfs
      if(head == null || head.next == null) {
        return true;
      }
      Node mid = findMidNode(head);

      Node curr = mid;
      Node prev = null;
      while(curr !=null) {
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      Node right = prev; // Right Half
      Node left = head; // Left Half

      while(right!=null) {
        if(left.data != right.data) {
          return false;
        }
        left = left.next;
        right = right.next;
      }
      return true;
    }
    public static boolean isCycle() { // slow and fast pointer
      Node slow = head;
      Node fast = head;
      while(fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) {
          return true;
        }
      }
      return false;
    }
    public static void remCycle() {
      if(isCycle() == true) {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(slow == fast) {
          prev = fast;
          slow = slow.next;
          fast = fast.next;
        }
        prev.next = null;
      }
      else {
        return;
      }
    }
  public static void main(String[] args) {
    // linkedListing ll = new linkedListing();
    // Node temp = ll.head;
    // ll.display();
    // ll.addFirst(2);
    // ll.display();
    // ll.addFirst(1);
    // ll.display();
    // ll.addLast(3);
    // ll.display();
    // ll.addLast(4);
    // ll.display();
    // ll.addMiddle(5,1);
    // ll.display();
    // ll.addMiddle(6,2);
    // ll.display();
    // System.out.println("Size of Linked List is :" + LinkedList.size);
    // ll.removeFirst();
    // ll.display();
    // ll.removeLast();
    // ll.display();
    // System.out.println("Element found at index: "+ ll.Itrsearch(3));
    // System.out.println("Element found at index: "+ ll.Recursearch(2));
    // ll.reverse();
    // ll.display();
    // ll.deleteNthfromEnd(2);
    // ll.display();
    // System.out.println(ll.checkPalindrome());
    // System.out.println(ll.isCycle()); // Floyds cycle finding algo
    // head = new Node(1);
    // head.next = new Node(2);
    // head.next.next = new Node(3);
    // head.next.next.next = new Node(1);
    // System.out.println(isCycle());
    // remCycle();
    // display();
    LinkedList<Integer> ll = new LinkedList<>(); // optimized
    ll.addLast(1);
    ll.addLast(2);
    ll.addFirst(0);
    System.out.println(ll);
    
  }
}
