import java.util.Stack;

public class reverseStack {
  public static void reverser(Stack<Integer> st) {
    if(st.isEmpty()) {
      return;
    }
    int top = st.pop();
    reverser(st);
    st.push(top);
  }
  public static void main(String[] args) {
    Stack <Integer> st = new Stack<>();
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    reverser(st);
    while(!st.isEmpty()) {
    System.out.println(st.pop());
    }
  }
}
