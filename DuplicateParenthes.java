import java.util.Stack;

public class DuplicateParenthes {
  public static boolean isDuplicate(String str) {
    Stack<Character> st = new Stack<>();
    for(int i=0; i<str.length(); i++ ) {
      char c = str.charAt(i);
      if(c == ')') {
        int count = 0;
        while(st.pop() != '(') {
          count++;
        }
        if(count<1) {
          return true;
        }
      }
      else {
        st.push(c);
      }
    }
    return false;

  }
  public static void main(String[] args) {
    System.out.println(isDuplicate("((a+b))"));
    System.out.println(isDuplicate("(a+b)"));
  }
}
