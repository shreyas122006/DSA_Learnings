import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackandqueueUSDeque {
  static class Stack {
    Deque<Integer> deque = new LinkedList<>();
    public void push(int data) {
      deque.addLast(data);
    }
    public int pop() {
      if(deque.isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      int top = deque.removeLast();
      return top;
    }
    public int peek() {
      if(deque.isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      return deque.getLast();
    }
  }
  static class Queue {
    Deque<Integer> deque1 = new LinkedList<>();
    public void add(int data) {
      deque1.addLast(data);
    }
    public int remove() {
      if(deque1.isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      int top = deque1.removeFirst();
      return top;
    }
    public int show() {
      if(deque1.isEmpty()) {
        System.out.println("Stack is Empty");
        return -1;
      }
      return deque1.getFirst();
    }
  }
  public static void main(String[] args) {
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.peek());
    Queue q = new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.show());
  }
}
