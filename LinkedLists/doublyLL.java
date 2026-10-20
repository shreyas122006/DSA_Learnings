public class doublyLL {
  public class Node {
    int data;
    Node prev;
    Node next;
    public Node(int data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }
    public static Node head;
    public static Node tail;
    public static int size;
  public void addFirst(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null) {
      head = tail = newNode;
      return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }
  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;
    if(head == null) {
      head = tail = newNode;
      return;
    }
    
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
  }
  public void print() {
    Node temp = head;
    System.out.print("null<->");
    while(temp!=null) {
      System.out.print(temp.data + "<->");
      temp = temp.next;
    }
    System.out.println("null");
  }
  public int removeFirst() {
    if(head == null) {
      System.out.println("DLL is Empty");
      return Integer.MIN_VALUE;
    }
    if(size == 1) {
      int val = head.data;
      size--;
      return val;
    }
    int val = head.data;
    head = head.next;
    head.prev = null;
    return val;
  }
  public int removeLast() {
    if (head == null) {
        return Integer.MIN_VALUE;
    }
    int val = tail.data;
    if (head == tail) {
        head = tail = null;
    } else {
        tail = tail.prev;
        tail.next = null;
    }

    return val;
}
public void reverse() {
  Node curr = head;
  Node prev = null;
  Node next;
  while(curr!=null) {
    next = curr.next;
    curr.next = prev;
    curr.prev = next;
    prev = curr;
    curr = next;
  }
  head = prev;
}
  public static void main(String[] args) {
    doublyLL ll = new doublyLL();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);
    ll.print();
    ll.removeFirst();
    ll.print();
    ll.addLast(6);
    ll.addLast(7);
    ll.addLast(8);
    ll.addLast(9);
    ll.addLast(10);
    ll.print();
    ll.removeLast();
    ll.print();
    ll.reverse();
    ll.print();
  }
}
