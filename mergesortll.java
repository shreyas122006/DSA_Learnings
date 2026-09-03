public class mergesortll { // T.C : O(nlogn)

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
    public static int size = 0;

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Display linked list
    public static void display() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Find middle node
    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head.next; // better split

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted lists
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // dummy node
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // Merge Sort
    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = findMidNode(head);

        // split
        Node rightHead = mid.next;
        mid.next = null;

        // recursive sort
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }
    public void zigZag() {
      Node slow = head;
      Node fast = head.next;
      while(fast!= null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      Node mid = slow; // reverse second half
      Node curr = mid.next;
      mid.next = null;
      Node prev = null;
      Node next;
      while(curr!=null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      Node left = head;
      Node right = prev;
      Node nextL, nextR;
      while(left!=null && right!=null) {
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
      }
    }
    public static void main(String[] args) {
        mergesortll ll = new mergesortll();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        System.out.println("Original List:");
        ll.display();
        ll.zigZag();

        // head = ll.mergeSort(head);

        System.out.println("Sorted List:");
        ll.display();
    }
}