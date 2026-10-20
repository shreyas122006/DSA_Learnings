import java.util.Stack;

public class pushatbot {
  public static void pushAtBottom(Stack<Integer> s, int data) {
    if(s.isEmpty()) {
      s.push(data);
      return;
    }
    int top = s.pop();
    pushAtBottom(s,data);
    s.push(top);
  }
  public static String reverseString(String S) {
    Stack<Character> c = new Stack<>();
    int idx =0;
    while(idx < S.length()) {
      c.push(S.charAt(idx));
      idx++;
    }
    StringBuilder result = new StringBuilder("");
    while(!c.isEmpty()) {
      char curr = c.pop();
      result.append(curr);
    }
    return result.toString();
  }
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    pushAtBottom(s,4);
    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }
    String Result = reverseString("Shreyash");
    System.out.println(Result);
  }
}
