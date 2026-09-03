public class palindrome {
  public static boolean palindrm(String x) {
    for(int i=0; i<(x.length())/2; i++) {
      if(x.charAt(i)==x.charAt(x.length()-1-i)) {
        return true;
      }
      }
      return false;
    }
  public static void main(String[] args) {
    String x = "121";
    System.out.println(palindrm(x));
  }
}
