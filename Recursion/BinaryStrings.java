public class BinaryStrings {
  public static void printBinaryStrings(String str, int n, int lastplace) {
    if(n==0) {
      System.out.println(str);
      return;
    }
    printBinaryStrings(str+'0',n-1,0);
    if(lastplace == 0) {
      printBinaryStrings(str+'1',n-1,1);
    }
  }
  public static void main(String[] args) {
    printBinaryStrings("",4,0);
  }
}
