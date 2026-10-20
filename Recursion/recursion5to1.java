public class recursion5to1 {
    public static void Print5to1(int n) {
        if ((n==0)) {
            return;
        }
        System.out.println(n);
        Print5to1(n-1);
    }
    public static void main(String[] args) {
        int n =5;
        Print5to1(n);
    }
}